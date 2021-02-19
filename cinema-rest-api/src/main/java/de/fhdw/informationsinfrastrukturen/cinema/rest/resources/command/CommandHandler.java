package de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commands.Command;
import idManagement.Identifiable;

public class CommandHandler {

	public static final String COMMAND_CONSTRUCTOR = "constructor";
	public static final String COMMAND_TARGET_SERVICE = "Service";
	private static final String COMMAND_SUFFIX = "Command";
	private static final String COMMAND_DELIMITER = "_";
	private static final String COMMAND_PACKAGE_SUBPATH = "commands";
	private static final String SERVICE_CHACHE_GETTER_PREFIX = "get";
	private static final String SERVICE_CHACHE_NAME_SUFFIX = "Cache";
	private static final Map<String, String> BASE_TYPES = Map.ofEntries(Map.entry("String", "java.lang.String"),
			Map.entry("Integer", "java.lang.Integer"), Map.entry("Boolean", "java.lang.Boolean"));

	private Map<String, Map<Integer, Identifiable>> targets;
	private Set<String> targetTypes;
	private Map<String, String> parameterTypes;
	private String commandsPackage;

	@SuppressWarnings("unchecked")
	public CommandHandler(Object service) throws Exception {
		this.targets = new HashMap<String, Map<Integer, Identifiable>>();

		final List<Method> cacheGetters = Stream.of(service.getClass().getMethods())
				.filter(method -> method.getName().contains(CommandHandler.SERVICE_CHACHE_NAME_SUFFIX))
				.collect(Collectors.toList());

		for (Method getter : cacheGetters) {
			this.targets.put(
					this.capitalize(getter.getName().replace(CommandHandler.SERVICE_CHACHE_NAME_SUFFIX, "")
							.replace(CommandHandler.SERVICE_CHACHE_GETTER_PREFIX, "")),
					(Map<Integer, Identifiable>) getter.invoke(service));
		}

		this.commandsPackage = service.getClass().getPackageName().concat(".")
				.concat(CommandHandler.COMMAND_PACKAGE_SUBPATH);

		this.parameterTypes = Stream
				.concat(this.targets.keySet().stream().map(key -> Map.entry(key, this.commandsPackage)),
						CommandHandler.BASE_TYPES.entrySet().stream())
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

		this.targetTypes = Stream
				.concat(Set.of(CommandHandler.COMMAND_TARGET_SERVICE).stream(), this.targets.keySet().stream())
				.collect(Collectors.toSet());
	}

	public CommandResponse handle(CommandRequest request) {
		try {
			// 1. validate request
			Class<?> commandClass = this.validate(request);
			// 2. create actual command
			Command<?> command;
			if (request.targetFunction.parameter != null) {
				final List<Parameter> parameters = request.targetFunction.parameter;
				Class<?>[] commandConstructorTypes = new Class<?>[parameters.size()];
				Object[] commandConstructorArgs = new Object[parameters.size()];
				for (int i = 0; i < parameters.size(); i++) {
					commandConstructorTypes[i] = Class.forName(this.parameterTypes.get(parameters.get(i).type));
					if (CommandHandler.BASE_TYPES.keySet().contains(parameters.get(i).type))
						commandConstructorArgs[i] = parameters.get(i).value;
					else
						commandConstructorArgs[i] = this
								.getObject(parameters.get(i).type, (Integer) parameters.get(i).value).get();
				}
				command = (Command<?>) commandClass.getConstructor(commandConstructorTypes)
						.newInstance(commandConstructorArgs);
			} else
				command = (Command<?>) commandClass.getConstructor().newInstance();
			// 3. execute command
			command.execute();
			// 4. build response
			return new CommandResponse(command.getResult(), command.getResult().getClass().getSimpleName());
		} catch (Exception e) {
			return new CommandResponse(e.getMessage());
		}
	}

	private Class<?> validate(CommandRequest command) throws Exception {
		// Handle unknown target type
		if (!this.targetTypes.contains(command.targetType))
			throw new Exception(String.format("Unsupported target type %s. Supported target types are %s",
					command.targetType, this.targetTypes));
		// handle parameter
		if (command.targetFunction.parameter != null) {
			// Handle unknown parameter types
			final Optional<Parameter> unknownParameter = command.targetFunction.parameter.stream()
					.filter(parameter -> !this.parameterTypes.keySet().contains(parameter.type)).findAny();
			if (unknownParameter.isPresent())
				throw new Exception(String.format("Unsupported type for parameter %s. Supported types are %s",
						unknownParameter.get(), this.parameterTypes.keySet()));
			// Handle unidentified objects
			final List<Parameter> unknownObjects = command.targetFunction.parameter.stream()
					.filter(parameter -> !CommandHandler.BASE_TYPES.keySet().contains(parameter.type))
					.filter(parameter -> this.getObject(parameter.type, (Integer) parameter.value).isEmpty())
					.collect(Collectors.toList());
			if (unknownObjects.size() > 0)
				throw new Exception(String.format("Can not handle unknown objects %s", unknownObjects));
		}
		try {
			// Handle unknown command
			if (command.targetType.equals(CommandHandler.COMMAND_TARGET_SERVICE))
				return Class.forName(this.buildCommandClassNameForService(command));
			else
				return Class.forName(this.buildCommandClassNameForType(command));
		} catch (ClassNotFoundException e) {
			throw new Exception(String.format("Unsupported command %s, no command found for %s", command,
					this.buildCommandClassNameForType(command)));
		} catch (Exception e) {
			throw e;
		}

	}

	private String buildCommandClassNameForType(CommandRequest command) {
		return new StringBuilder(this.commandsPackage).append(".").append(command.targetType)
				.append(CommandHandler.COMMAND_DELIMITER).append(command.targetFunction.name)
				.append(CommandHandler.COMMAND_DELIMITER).append(CommandHandler.COMMAND_SUFFIX).toString();
	}

	private String buildCommandClassNameForService(CommandRequest command) {
		return new StringBuilder(this.commandsPackage).append(".").append(command.targetFunction.name)
				.append(CommandHandler.COMMAND_DELIMITER).append(CommandHandler.COMMAND_SUFFIX).toString();
	}

	private Optional<?> getObject(String type, Integer id) {
		return Optional.ofNullable(this.targets.get(type).get(id));
	}

	private String capitalize(String str) {
		if (str == null)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}

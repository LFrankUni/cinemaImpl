package de.fhdw.informationsinfrastrukturen.cinema.rest;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.CommandHandler;
import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.CommandHandlerFactory;
import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.CommandRequest;
import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.CommandResponse;
import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.Function;
import de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command.Parameter;

@TestInstance(Lifecycle.PER_CLASS)
public class CommandHandlerTest {

	private CommandHandler handler;

	@BeforeAll
	public void setup() throws Exception {
		this.handler = CommandHandlerFactory.INSTANCE.createCommandHandler();
	}

	@Test
	public void createUser() {
		assertNull(this.createUser("Hugo", "Schmied").getError());
	}

	private CommandResponse createUser(String firstName, String lastName) {
		return this.handler.handle(new CommandRequest(new Function(CommandHandler.COMMAND_CONSTRUCTOR,
				List.of(new Parameter(firstName, "String"), new Parameter(lastName, "String"))), "User"));
	}
}

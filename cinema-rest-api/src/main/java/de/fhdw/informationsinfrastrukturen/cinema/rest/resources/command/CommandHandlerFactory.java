package de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command;

import java.util.Properties;

import generated.cinemaService.CinemaService;

public class CommandHandlerFactory {

	public static final CommandHandlerFactory INSTANCE = new CommandHandlerFactory();
	private Exception INIT_ERROR;
	private Object service;

	private CommandHandlerFactory() {
		try {
			//TODO doesnt work in eclipse, try mvn install and deploy manually
			java.io.InputStream is = CommandHandlerFactory.class.getClassLoader()
					.getResourceAsStream("config.properties");
			java.util.Properties p = new Properties();
			p.load(is);
			System.out.println(p.get("service"));
			this.service = Class.forName((String) p.get("service"));
		} catch (Exception e) {
			this.INIT_ERROR = e;
		}
	}

	public CommandHandler createCommandHandler() throws Exception {
//		if (this.INIT_ERROR != null)
//			throw this.INIT_ERROR;
//		return new CommandHandler(service);
		return new CommandHandler(CinemaService.getInstance());
	}

}

package de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/command")
public class CommandResource {

	private CommandHandler handler;
	private Exception INIT_ERROR;

	public CommandResource() {
		try {
			this.handler = CommandHandlerFactory.INSTANCE.createCommandHandler();
		} catch (Exception e) {
			this.INIT_ERROR = e;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response handle(CommandRequest request) {
		if (this.INIT_ERROR != null)
			return this.status();
		final CommandResponse res = this.handler.handle(request);
		if (res.error == null)
			return Response.status(200).entity(res).build();
		else
			return Response.status(400).entity(res).build();
	}

	@Path("/status")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public Response status() {
		if (this.INIT_ERROR == null)
			return Response.status(200).entity("1 nice api 🚀").build();
		else
			return Response.status(500).entity("1 nice api 🚀  if working").build();
	}
}

package de.fhdw.informationsinfrastrukturen.cinema.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import de.fhdw.informationsinfrastrukturen.cinema.rest.api.CommandHandler;
import de.fhdw.informationsinfrastrukturen.cinema.rest.api.CommandHandlerFactory;
import de.fhdw.informationsinfrastrukturen.cinema.rest.api.CommandRequest;
import de.fhdw.informationsinfrastrukturen.cinema.rest.api.CommandResponse;
import de.fhdw.informationsinfrastrukturen.cinema.rest.api.Function;
import de.fhdw.informationsinfrastrukturen.cinema.rest.api.Parameter;
import generated.cinemaService.Movie;
import generated.cinemaService.Room;
import idManagement.Identifiable;
import utilities.TimeConverter;

@TestInstance(Lifecycle.PER_CLASS)
public class CommandHandlerTest {

	private CommandHandler handler;

	@BeforeAll
	public void setup() throws Exception {
		this.handler = CommandHandlerFactory.INSTANCE.createCommandHandler();
	}

	@Test
	public void getObject() throws Exception {
		final Integer id_1 = ((Identifiable) this.createCinema("test").getValue()).getId();
		final Integer id_2 = ((Identifiable) this.getObject(id_1)).getId();
		assertEquals(id_1, id_2);
	}

	@Test
	public void getObjectError() {
		assertThrows(Exception.class, () -> this.getObject(-1));
	}

	private Object getObject(Integer id) throws Exception {
		return this.handler.getObject(id);
	}

	@Test
	public void createUser() {
		assertNull(this.createUser("Hugo", "Schmied").getError());
	}

	@Test
	public void createCinema() {
		assertNull(this.createCinema("1 nice cinema").getError());
	}

	@Test
	public void createCinemaError() {
		assertNotNull(this.createCinema("").getError());
		assertNotNull(this.createCinema(null).getError());
	}

	private CommandResponse createCinema(String name) {
		return this.handler.handle(new CommandRequest(
				new Function(CommandHandler.COMMAND_CONSTRUCTOR, List.of(new Parameter(name, "String"))), "Cinema"));
	}

	@Test
	public void createMovie() {
		assertNull(this.createMovie("Ice Age", 90, "1 nice description").getError());
	}

	@Test
	public void createMovieError() {
		assertNotNull(this.createMovie("Bla", -1, "1 nice description").getError());
	}

	private CommandResponse createMovie(String title, Integer minutes, String description) {
		return this.handler.handle(new CommandRequest(
				new Function(CommandHandler.COMMAND_CONSTRUCTOR, List.of(new Parameter(title, "String"),
						new Parameter(description, "String"), new Parameter(minutes, "Integer"))),
				"Movie"));
	}

	@Test
	public void createMovieShow() {
		assertNull(this.scheduleMovieShow((Room) this.createRoom("42", true).getValue(),
				(Movie) this.createMovie("1 nice movie", 42, "1 nice description").getValue(),
				TimeConverter.toInstant("2007-12-03T10:00:00.00Z"), 3, true, 1000).getError());
	}

	private CommandResponse createRoom(String name, Boolean open) {
		return this.handler.handle(new CommandRequest(new Function(CommandHandler.COMMAND_CONSTRUCTOR,
				List.of(new Parameter(name, "String"), new Parameter(open, "Boolean"))), "Room"));
	}

	private CommandResponse createUser(String firstName, String lastName) {
		return this.handler.handle(new CommandRequest(new Function(CommandHandler.COMMAND_CONSTRUCTOR,
				List.of(new Parameter(firstName, "String"), new Parameter(lastName, "String"))), "User"));
	}

	private CommandResponse scheduleMovieShow(Room room, Movie movie, Instant start, Integer days,
			Boolean threeDimensional, Integer price) {
		return this.handler.handle(new CommandRequest(
				new Function("scheduleMovieShow",
						List.of(new Parameter(movie.getId(), "Movie"),
								new Parameter(TimeConverter.toString(start), "String"), new Parameter(days, "Integer"),
								new Parameter(threeDimensional, "Boolean"), new Parameter(price, "Integer"))),
				"Room", room.getId()));
	}

}

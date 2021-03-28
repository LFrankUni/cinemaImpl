package test.java;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.Booked;
import generated.cinemaService.Cinema;
import generated.cinemaService.ModelException;
import generated.cinemaService.Movie;
import generated.cinemaService.MovieShow;
import generated.cinemaService.Room;
import generated.cinemaService.RoomRow;
import generated.cinemaService.RowCategory;
import generated.cinemaService.Seat;
import generated.cinemaService.Ticket;

class TicketTest {

	@Test
	void ticketUnreservedToReveservedTest() throws PersistenceException, ConstraintViolation {
		//Setup von anderen Objekten zum Aufbauen des Tickets
		RowCategory testLoge = RowCategory.createFresh("Loge", 300);
		RoomRow testRow = RoomRow.createFresh(testLoge, "Saal 1");
		Seat testSeat = Seat.createFresh(2, testRow);
		Cinema testCinema = Cinema.createFresh("Test Cinema");
		Room testRoom = Room.createFresh("Saal 1", true, testCinema);
		Movie testMovie = Movie.createFresh("Test Film", "Einfach nur zum Testen", 90);
		MovieShow testShow = MovieShow.createFresh(testMovie, "2021-10-03 20:00:00", "2021-10-03 21:30:00", false, 500, testRoom);
		Ticket testTicket = Ticket.createFresh(testSeat, testShow);
		
		//Ticket sollte nicht gebucht werden können, wenn es nicht schon im State reserved ist
		assertThrows(ModelException.class, () -> {
			testTicket.setState(Booked.createFresh());
		});
	}

}

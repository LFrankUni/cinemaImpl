package test.java;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.Available;
import generated.cinemaService.ModelException;

class TicketTest {

	@Test
	void ticketUnreservedToReveservedTest() throws PersistenceException, ConstraintViolation {
		Available availableState = Available.createFresh();
		
		//Im AvailableState sollte ein Ticket nicht gebucht werden können
		assertThrows(ModelException.class, () -> {
			availableState.book();
		});
	}

}

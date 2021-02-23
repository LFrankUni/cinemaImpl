package db.executer;

import generated.cinemaService.ModelException;

public class PersistenceException extends ModelException {
	public PersistenceException(String message) {
		super("Exception when trying to communicate with database: " + message);
	}
}

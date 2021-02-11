package db.executer;

public class PersistenceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String message) {
		super("Exception when trying to communicate with database: " + message);
	}
}

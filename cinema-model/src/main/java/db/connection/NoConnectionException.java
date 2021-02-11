package db.connection;

public class NoConnectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoConnectionException(String message) {
		super(message);
	}
}

/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;

//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.CinemaProxy;
import generated.cinemaService.proxies.ICinema;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import exceptions.ConstraintViolation;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinema extends HasIncome implements java.io.Serializable, ICinema {
	// 30 ===== GENERATED: Attribute Section ======
	private String nameOfCinema;
	// 40 ===== Editable : Your Attribute Section ======

	// 50 ===== GENERATED: Constructor ============
	private Cinema(Integer id, String nameOfCinema, boolean objectOnly) throws PersistenceException {
		super(id, objectOnly);
		this.nameOfCinema = nameOfCinema;
		if (objectOnly)
			return;
	}

	/**
	 * Caution: A Call to this Method Requires to add any newly instantiated Object
	 * to its Cache!
	 */
	public static Cinema createAlreadyPersistent(CinemaProxy proxy, String nameOfCinema) throws PersistenceException {
		if (proxy.isObjectPresent())
			return proxy.getTheObject();
		return new Cinema(proxy.getId(), nameOfCinema, true);
	}

	public static Cinema createFresh(String nameOfCinema) throws PersistenceException {
		db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
		Integer id = dmlExecuter.getNextId();
		try {
			dmlExecuter.insertInto("HasIncome", "id, typeKey, nameOfCinema",
					id.toString() + ", "
							+ TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Cinema").toString() + ", "
							+ "'" + nameOfCinema + "'");
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
		Cinema me = new Cinema(id, nameOfCinema, false);
		CinemaService.getInstance().addCinemaProxy(new CinemaProxy(me));
		return me;
	}
	// 60 ===== Editable : Your Constructors ===========

	// 70 ===== GENERATED: Feature Access =========
	public Cinema getTheObject() {
		return this;
	}

	public Set<Room> getRoomes() throws PersistenceException {
		Set<Room> result = new HashSet<>();
		for (IRoom i : roomesSupervisor.getInstance().getRoomes(this))
			result.add(i.getTheObject());
		return result;
	}

	public void addToRoomes(Room arg) throws PersistenceException {
		roomesSupervisor.getInstance().add(this, arg);
	}

	public boolean removeFromRoomes(Room arg) throws PersistenceException {
		return roomesSupervisor.getInstance().remove(this, arg);
	}

	public Set<Movie> getMovies() throws PersistenceException {
		Set<Movie> result = new HashSet<>();
		for (IMovie i : moviesSupervisor.getInstance().getMovies(this))
			result.add(i.getTheObject());
		return result;
	}

	public void addToMovies(Movie arg) throws PersistenceException {
		moviesSupervisor.getInstance().add(this, arg);
	}

	public boolean removeFromMovies(Movie arg) throws PersistenceException {
		return moviesSupervisor.getInstance().remove(this, arg);
	}

	public String getNameOfCinema() {
		return this.nameOfCinema;
	}

	public void setNameOfCinema(String newNameOfCinema) throws PersistenceException {
		this.nameOfCinema = newNameOfCinema;
		try {
			PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "nameOfCinema",
					"'" + newNameOfCinema + "'", this.getId());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	// 80 ===== Editable : Your Operations =============
	/**
	 * Returns all movies of this cinema.
	 */
	public Collection<Movie> getAllMovies() throws ModelException {
		// TODO: Implement Operation getAllMovies
		return null;
	}

	/**
	 * Returns all movie shows between from and to (inclusive).
	 */
	public Collection<MovieShow> getScheduledMovieShows(String from, String to) throws ModelException {
		// TODO: Implement Operation getScheduledMovieShows
		return null;
	}

	/**
	 * Adds a movie to this cinema
	 */
	public void addMovie(Movie movie) throws ModelException {
		// TODO: Implement Operation addMovie
		return;
	}

	/**
	 * Returns all the rooms of this cinema.
	 */
	public Collection<Room> getAllRooms() throws ModelException {
		// TODO: Implement Operation getAllRooms
		return null;
	}

	/**
	 * Returns the income that the elements currently has.
	 */
	public Integer income() throws ModelException {
		Integer sum = 0;
		for (Iterator<Movie> iterator = this.getAllMovies().iterator(); iterator.hasNext();) {
			sum += iterator.next().income();
		}
		return sum;
	}

//90 ===== GENERATED: End of Your Operations ======
}

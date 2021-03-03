/**--- Generated at Wed Mar 03 18:19:11 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;

//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.RoomProxy;
import generated.cinemaService.proxies.IRoom;
import generated.cinemaService.relationControl.*;
import utilities.TimeConverter;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashSet;
import java.util.Iterator;

import exceptions.ConstraintViolation;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Room extends HasIncome implements java.io.Serializable, IRoom {
	//30 ===== GENERATED:      Attribute Section ======
	private String nameOfRoom;
	private Boolean open;
	//40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
	private Room(Integer id, String nameOfRoom, Boolean open, boolean objectOnly) throws PersistenceException {
		super(id, objectOnly);
		this.nameOfRoom = nameOfRoom;
		this.open = open;
		if (objectOnly)
			return;
	}

	/** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
	public static Room createAlreadyPersistent(RoomProxy proxy, String nameOfRoom, Boolean open)
			throws PersistenceException {
		if (proxy.isObjectPresent())
			return proxy.getTheObject();
		return new Room(proxy.getId(), nameOfRoom, open, true);
	}

	public static Room createFresh(String nameOfRoom, Boolean open) throws PersistenceException {
		db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
		Integer id = dmlExecuter.getNextId();
		try {
			dmlExecuter.insertInto("HasIncome", "id, typeKey, nameOfRoom, open",
					id.toString() + ", "
							+ TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Room").toString() + ", "
							+ "'" + nameOfRoom + "'" + ", " + open.toString());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
		Room me = new Room(id, nameOfRoom, open, false);
		CinemaService.getInstance().addRoomProxy(new RoomProxy(me));
		return me;
	}
	//60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
	public Room getTheObject() {
		return this;
	}

	public Set<MovieShow> getMovieShows() throws PersistenceException {
		Set<MovieShow> result = new HashSet<>();
		for (IMovieShow i : movieShowsOfRoomSupervisor.getInstance().getMovieShows(this))
			result.add(i.getTheObject());
		return result;
	}

	public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException {
		movieShowsOfRoomSupervisor.getInstance().add(this, arg);
	}

	public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException {
		return movieShowsOfRoomSupervisor.getInstance().remove(this, arg);
	}

	public Set<RoomRow> getRows() throws PersistenceException {
		Set<RoomRow> result = new HashSet<>();
		for (IRoomRow i : rowsOfRoomSupervisor.getInstance().getRows(this))
			result.add(i.getTheObject());
		return result;
	}

	public void addToRows(RoomRow arg) throws PersistenceException {
		rowsOfRoomSupervisor.getInstance().add(this, arg);
	}

	public boolean removeFromRows(RoomRow arg) throws PersistenceException {
		return rowsOfRoomSupervisor.getInstance().remove(this, arg);
	}

	public String getNameOfRoom() {
		return this.nameOfRoom;
	}

	public void setNameOfRoom(String newNameOfRoom) throws PersistenceException {
		this.nameOfRoom = newNameOfRoom;
		try {
			PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "nameOfRoom",
					"'" + newNameOfRoom + "'", this.getId());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public Boolean getOpen() {
		return this.open;
	}

	public void setOpen(Boolean newOpen) throws PersistenceException {
		this.open = newOpen;
		try {
			PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "open",
					newOpen.toString(), this.getId());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	//80 ===== Editable : Your Operations =============

	/**
	 * Adds a row to the Room.
	 */
	public RoomRow addRow(String name, RowCategory category) throws ModelException {
		final RoomRow row = RoomRow.createFresh(category, name);
		this.addToRows(row);
		return row;
	}

	/**
	 * Opens the room for service.
	 */
	public void open() throws ModelException {
		this.setOpen(true);
	}

	/**
	 * Returns the income that the elements currently has.
	 */
	public Integer income() throws ModelException {
		Integer sum = 0;
		for (Iterator<MovieShow> iterator = this.getMovieShows().iterator(); iterator.hasNext();) {
			sum += iterator.next().income();
		}
		return sum;
	}

	/**
	 * Returns all rows of this room.
	 */
	public Collection<RoomRow> getAllRows() throws ModelException {
		return this.getRows();
	}

	/**
	 * Closes the room so that no MovieShow can be hosted.
	 */
	public void close() throws ModelException {
		this.setOpen(false);
	}

	/**
	 * Schedules a MovieShow if schedule is free.
	 */
	public MovieShow scheduleMovieShow(Movie movie, String start, String end, Boolean threeDimensional, Integer price)
			throws ModelException {
		final Instant _start = TimeConverter.toInstant(start);
		final Instant _end = TimeConverter.toInstant(end);

		if (movie == null || start == null || end == null || threeDimensional == null || price == null)
			throw new ModelException("Must provide non null-values!");

		if (_end.isBefore(_start))
			throw new ModelException("End must be after start!");

		if (movie.getMinutes() * 60 > TimeConverter.toInstant(end).getEpochSecond() - _start.getEpochSecond())
			throw new ModelException(String.format(
					"Movie length longer than requested time slot! Minutes of requested movie: %s <-> Length of requested timeslot %s",
					movie.getMinutes(), TimeConverter.toInstant(end).getEpochSecond() - _start.getEpochSecond()));

		final Set<MovieShow> possibleConflicts = this.getMovieShows().stream()
				.filter(show -> _start.isBefore(TimeConverter.toInstant(show.getEnd()))
						&& _end.isAfter(TimeConverter.toInstant(show.getStart())))
				.collect(Collectors.toSet());

		Instant currentStart = _start;
		Instant currentEnd = _start.plus(movie.getMinutes(), ChronoUnit.MINUTES);

		while (currentStart.isBefore(_end)) {
			for (MovieShow show : possibleConflicts) {
				if (currentStart.isBefore(TimeConverter.toInstant(show.getEnd()))
						&& currentEnd.isAfter(TimeConverter.toInstant(show.getStart())))
					throw new ModelException("Requested shedule not available!");
			}
			currentEnd = currentEnd.plus(1, ChronoUnit.DAYS);
			currentStart = currentStart.plus(1, ChronoUnit.DAYS);
		}

		final MovieShow show = MovieShow.createFresh(movie, start, end, threeDimensional, price, this);
		for (RoomRow row : this.getRows()) {
			for (Seat seat : row.getSeats()) {
				final Ticket ticket = Ticket.createFresh(seat, show);
				ticket.setState(Available.createFresh(ticket));
				show.addToTickets(ticket);
			}
		}

		this.addToMovieShows(show);

		return show;
	}
//90 ===== GENERATED: End of Your Operations ======
}

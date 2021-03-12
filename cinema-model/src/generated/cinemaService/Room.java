/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import exceptions.ConstraintViolation;

import java.util.ArrayList;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========
import java.util.HashMap;

//25 ===== GENERATED:      Header Section =========
public class Room extends HasIncome implements java.io.Serializable, IRoom
{
   //30 ===== GENERATED:      Attribute Section ======
   private String nameOfRoom;
   private Boolean open;
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private Room(Integer id, String nameOfRoom, Boolean open, Cinema cinema, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      this.nameOfRoom = nameOfRoom;
      this.open = open;
      if(objectOnly) return;
      try{roomesSupervisor.getInstance().add(cinema,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Room createAlreadyPersistent(RoomProxy proxy, String nameOfRoom, Boolean open, Cinema cinema)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Room(proxy.getId(), nameOfRoom, open, cinema, true);
   }
   public static Room createFresh(String nameOfRoom, Boolean open, Cinema cinema)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, nameOfRoom, open", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Room").toString() + ", " + "'" + nameOfRoom + "'" + ", " + open.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Room me = new Room(id, nameOfRoom, open, cinema, false);
      CinemaService.getInstance().addRoomProxy(new RoomProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public Room getTheObject(){
      return this;
   }
   public Set<MovieShow> getMovieShows() throws PersistenceException{
      Set<MovieShow> result = new HashSet<>();
      for (IMovieShow i : movieShowsOfRoomSupervisor.getInstance().getMovieShows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      movieShowsOfRoomSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      return movieShowsOfRoomSupervisor.getInstance().remove(this, arg);
   }
   public Set<RoomRow> getRows() throws PersistenceException{
      Set<RoomRow> result = new HashSet<>();
      for (IRoomRow i : rowsOfRoomSupervisor.getInstance().getRows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToRows(RoomRow arg) throws PersistenceException{
      rowsOfRoomSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromRows(RoomRow arg) throws PersistenceException{
      return rowsOfRoomSupervisor.getInstance().remove(this, arg);
   }
   public String getNameOfRoom() {
      return this.nameOfRoom;
   }
   public void setNameOfRoom(String newNameOfRoom) throws PersistenceException{
      this.nameOfRoom = newNameOfRoom;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "nameOfRoom", "'" + newNameOfRoom + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getOpen() {
      return this.open;
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.open = newOpen;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "open", newOpen.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Cinema getCinema() throws PersistenceException{
      return roomesSupervisor.getInstance().getCinema(this).getTheObject();
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
	public Collection<MovieShow> scheduleMovieShows(Movie movie, String start, Integer days, Boolean threeDimensional,
			Integer price) throws ModelException {
		final Instant _start = TimeConverter.toInstant(start);
		final Instant end = TimeConverter.toInstant(start).plus(days, ChronoUnit.DAYS);

		if (movie == null || start == null || days == null || threeDimensional == null || price == null)
			throw new ModelException("Must provide non null-values!");

		final Map<Instant, Instant> dates = new HashMap<Instant, Instant>();
		Instant current = Instant.ofEpochMilli(_start.toEpochMilli());
		for (int i = 0; i <= days; i++) {
			dates.put(current, current.plus(movie.getMinutes(), ChronoUnit.MINUTES));
			current = current.plus(1, ChronoUnit.DAYS);
		}

		final Map<Instant, Instant> possibleConflicts = this.getMovieShows().stream().map(
				show -> Map.entry(TimeConverter.toInstant(show.getStart()), TimeConverter.toInstant(show.getEnd())))
				.filter(entry -> _start.isBefore(entry.getValue()) && end.isAfter(entry.getKey()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		// validate
		for (Entry<Instant, Instant> request : dates.entrySet()) {
			for (Entry<Instant, Instant> scheduled : possibleConflicts.entrySet()) {
				if (request.getKey().isBefore(scheduled.getValue()) && request.getValue().isAfter(scheduled.getKey()))
					throw new ModelException("Requested shedule not available!");
			}
		}

		final List<MovieShow> out = new ArrayList<>();
		MovieShow show;

		// create
		for (Entry<Instant, Instant> request : dates.entrySet()) {
			show = MovieShow.createFresh(movie, TimeConverter.toString(request.getKey()),
					TimeConverter.toString(request.getValue()), threeDimensional, price, this);
			for (RoomRow row : this.getRows()) {
				for (Seat seat : row.getSeats()) {
					final Ticket ticket = Ticket.createFresh(seat, show);
					ticket.setState(Available.createFresh(ticket));
					show.addToTickets(ticket);
				}
			}
			this.addToMovieShows(show);
			out.add(show);
		}

		return out;
	}

//90 ===== GENERATED: End of Your Operations ======
}

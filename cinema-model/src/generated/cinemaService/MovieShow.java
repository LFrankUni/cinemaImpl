/**--- Generated at Sun Mar 14 00:09:50 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MovieShowProxy;
import generated.cinemaService.proxies.IMovieShow;
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
public class MovieShow extends HasIncome implements java.io.Serializable, IMovieShow
{
   //30 ===== GENERATED:      Attribute Section ======
   private String start;
   private String end;
   private Boolean threeDimensional;
   private Integer priceInCent;
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private MovieShow(Integer id, Movie movie, String start, String end, Boolean threeDimensional, Integer priceInCent, Room room, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      movieOfMovieShowSupervisor.getInstance().set(this, movie);
      this.start = start;
      this.end = end;
      this.threeDimensional = threeDimensional;
      this.priceInCent = priceInCent;
      if(objectOnly) return;
      try{movieShowsOfRoomSupervisor.getInstance().add(room,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static MovieShow createAlreadyPersistent(MovieShowProxy proxy, Movie movie, String start, String end, Boolean threeDimensional, Integer priceInCent, Room room)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new MovieShow(proxy.getId(), movie, start, end, threeDimensional, priceInCent, room, true);
   }
   public static MovieShow createFresh(Movie movie, String start, String end, Boolean threeDimensional, Integer priceInCent, Room room)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, start, end, threeDimensional, priceInCent", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "MovieShow").toString() + ", " + "'" + start + "'" + ", " + "'" + end + "'" + ", " + threeDimensional.toString() + ", " + priceInCent.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MovieShow me = new MovieShow(id, movie, start, end, threeDimensional, priceInCent, room, false);
      CinemaService.getInstance().addMovieShowProxy(new MovieShowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public MovieShow getTheObject(){
      return this;
   }
   public Movie getMovie() throws PersistenceException{
      return movieOfMovieShowSupervisor.getInstance().getMovie(this).getTheObject();
   }
   public void setMovie(Movie newMovie)throws PersistenceException{
      movieOfMovieShowSupervisor.getInstance().change(this, this.getMovie(), newMovie);
   }
   public Set<Ticket> getTickets() throws PersistenceException{
      Set<Ticket> result = new HashSet<>();
      for (ITicket i : movieShowToTicketSupervisor.getInstance().getTickets(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      movieShowToTicketSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return movieShowToTicketSupervisor.getInstance().remove(this, arg);
   }
   public String getStart() {
      return this.start;
   }
   public void setStart(String newStart) throws PersistenceException{
      this.start = newStart;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "start", "'" + newStart + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getEnd() {
      return this.end;
   }
   public void setEnd(String newEnd) throws PersistenceException{
      this.end = newEnd;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "end", "'" + newEnd + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getThreeDimensional() {
      return this.threeDimensional;
   }
   public void setThreeDimensional(Boolean newThreeDimensional) throws PersistenceException{
      this.threeDimensional = newThreeDimensional;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "threeDimensional", newThreeDimensional.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getPriceInCent() {
      return this.priceInCent;
   }
   public void setPriceInCent(Integer newPriceInCent) throws PersistenceException{
      this.priceInCent = newPriceInCent;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "priceInCent", newPriceInCent.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Room getRoom() throws PersistenceException{
      return movieShowsOfRoomSupervisor.getInstance().getRoom(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Returns all tickets of this show.
	 */
	public Collection<Ticket> getAllTickets() throws ModelException {
		return this.getTickets();
	}

	/**
	 * Returns the room of this show.
	 * 
	 * @throws PersistenceException
	 */
	public Room getTheRoom() throws ModelException {
		return this.getRoom();
	}

	/**
	 * Returns the movie of this show.
	 */
	public Movie getTheMovie() throws ModelException {
		return this.getMovie();
	}

	/**
	 * Returns the income that the elements currently has.
	 */
	public Integer income() throws ModelException {
		Integer sum = 0;
		for (Iterator<Ticket> iterator = this.getTickets().iterator(); iterator.hasNext();) {
			if (iterator.next().getState().get() instanceof Booked)
				sum += iterator.next().getPrice();
		}
		return sum;
	}
//90 ===== GENERATED: End of Your Operations ======
}

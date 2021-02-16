/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.IMovieShow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class MovieShow extends Observable implements java.io.Serializable, IMovieShow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String start;
   private String end;
   private Integer price;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private MovieShow(Integer id, Movie shownMovie, String start, String end, Integer price, Room room, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      shownMovieSupervisor.getInstance().set(this, shownMovie);
      this.start = start;
      this.end = end;
      this.price = price;
      if(objectOnly) return;
      try{showsSupervisor.getInstance().add(room,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static MovieShow createAlreadyPersistent(Integer id, Movie shownMovie, String start, String end, Integer price, Room room)throws PersistenceException{
      return new MovieShow(id, shownMovie, start, end, price, room, true);
   }
   public static MovieShow createFresh(Movie shownMovie, String start, String end, Integer price, Room room)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("MovieShow", "id, typeKey, start, end, price", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "MovieShow").toString() + ", " + "'" + start + "'" + ", " + "'" + end + "'" + ", " + price.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MovieShow me = new MovieShow(id, shownMovie, start, end, price, room, false);
      generated.cinemaService.proxies.MovieShowProxy p = new generated.cinemaService.proxies.MovieShowProxy(me);
      CinemaService.getInstance().addMovieShowProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public MovieShow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovieShow)) return false;
      return ((IMovieShow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Movie getShownMovie() throws PersistenceException{
      return shownMovieSupervisor.getInstance().getShownMovie(this).getTheObject();
   }
   public void setShownMovie(Movie newShownMovie)throws PersistenceException{
      shownMovieSupervisor.getInstance().change(this, this.getShownMovie(), newShownMovie);
   }
   public Set<Ticket> getTickets() throws PersistenceException{
      Set<Ticket> result = new HashSet<>();
      for (ITicket i : ticketsOfMovieShowSupervisor.getInstance().getTickets(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      ticketsOfMovieShowSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return ticketsOfMovieShowSupervisor.getInstance().remove(this, arg);
   }
   public String getStart() {
      return this.start;
   }
   public void setStart(String newStart) throws PersistenceException{
      this.start = newStart;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("MovieShow", "start", "'" + newStart + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getEnd() {
      return this.end;
   }
   public void setEnd(String newEnd) throws PersistenceException{
      this.end = newEnd;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("MovieShow", "end", "'" + newEnd + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = newPrice;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("MovieShow", "price", newPrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Room getRoom() throws PersistenceException{
      return showsSupervisor.getInstance().getRoom(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Throws an exception if already booked, else returns the price.
 */
   public Ticket book(Integer seat, Integer row, User by)throws SeatAlreadyBookedException{
      // TODO: Implement Operation book
      return null;
   }
/**
 * Throws an exception if already reserved, else returns the price.
 */
   public Ticket reserve(Integer seat, Integer row, User by)throws SeatAlreadyReservedException{
      // TODO: Implement Operation reserve
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

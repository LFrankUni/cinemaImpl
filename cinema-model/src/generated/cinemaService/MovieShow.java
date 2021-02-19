/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IMovieShow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class MovieShow extends HasIncome implements java.io.Serializable, IMovieShow
{
   //30 ===== GENERATED:      Attribute Section ======
   private String start;
   private String end;
   private Integer price;
   private Boolean threeD;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private MovieShow(Integer id, String start, String end, Integer price, Boolean threeD, Room room, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      this.start = start;
      this.end = end;
      this.price = price;
      this.threeD = threeD;
      if(objectOnly) return;
      try{movieShowsOfRoomSupervisor.getInstance().add(room,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static MovieShow createAlreadyPersistent(Integer id, String start, String end, Integer price, Boolean threeD, Room room)throws PersistenceException, ConstraintViolation{
      return new MovieShow(id, start, end, price, threeD, room, true);
   }
   public static MovieShow createFresh(String start, String end, Integer price, Boolean threeD, Room room)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, start, end, price, threeD", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "MovieShow").toString() + ", " + "'" + start + "'" + ", " + "'" + end + "'" + ", " + price.toString() + ", " + threeD.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MovieShow me = new MovieShow(id, start, end, price, threeD, room, false);
      generated.cinemaService.proxies.MovieShowProxy p = new generated.cinemaService.proxies.MovieShowProxy(me);
      CinemaService.getInstance().addMovieShowProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public MovieShow getTheObject(){
      return this;
   }
   public List<Movie> getMovie() throws PersistenceException{
      List<Movie> result = new ArrayList<>();
      for (IMovie i : movieShowsOfMovieSupervisor.getInstance().getMovie(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMovie(Movie arg) throws PersistenceException{
      movieShowsOfMovieSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMovie(Movie arg) throws PersistenceException{
      return movieShowsOfMovieSupervisor.getInstance().remove(this, arg);
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
   public Integer getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = newPrice;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "price", newPrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getThreeD() {
      return this.threeD;
   }
   public void setThreeD(Boolean newThreeD) throws PersistenceException{
      this.threeD = newThreeD;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "threeD", newThreeD.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Room getRoom() throws PersistenceException{
      return movieShowsOfRoomSupervisor.getInstance().getRoom(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Throws an exception if already reserved, else returns the price.
 */
   public Ticket reserve(Seat seat, User by)throws SeatAlreadyReservedException{
      // TODO: Implement Operation reserve
      return null;
   }
/**
 * Calculates an income
 */
   public Integer income(){
      // TODO: Implement Operation income
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

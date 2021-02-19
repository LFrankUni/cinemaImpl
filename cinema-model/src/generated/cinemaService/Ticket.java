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
import generated.cinemaService.proxies.ITicket;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Ticket extends TicketAction implements java.io.Serializable, ITicket
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Ticket(Integer id, TicketState state, Seat seat, MovieShow movieShow, User by, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      ticketStateSupervisor.getInstance().set(this, state);
      ticketSeatSupervisor.getInstance().set(this, seat);
      if(objectOnly) return;
      try{ticketsOfMovieShowSupervisor.getInstance().add(movieShow,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
      try{ticketsOfUserSupervisor.getInstance().add(by,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Ticket createAlreadyPersistent(Integer id, TicketState state, Seat seat, MovieShow movieShow, User by)throws PersistenceException, ConstraintViolation{
      return new Ticket(id, state, seat, movieShow, by, true);
   }
   public static Ticket createFresh(TicketState state, Seat seat, MovieShow movieShow, User by)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Ticket").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Ticket me = new Ticket(id, state, seat, movieShow, by, false);
      generated.cinemaService.proxies.TicketProxy p = new generated.cinemaService.proxies.TicketProxy(me);
      CinemaService.getInstance().addTicketProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Ticket getTheObject(){
      return this;
   }
   public TicketState getState() throws PersistenceException{
      return ticketStateSupervisor.getInstance().getState(this).getTheObject();
   }
   public void setState(TicketState newState)throws PersistenceException{
      ticketStateSupervisor.getInstance().change(this, this.getState(), newState);
   }
   public Seat getSeat() throws PersistenceException{
      return ticketSeatSupervisor.getInstance().getSeat(this).getTheObject();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      ticketSeatSupervisor.getInstance().change(this, this.getSeat(), newSeat);
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return ticketsOfMovieShowSupervisor.getInstance().getMovieShow(this).getTheObject();
   }
   public User getBy() throws PersistenceException{
      return ticketsOfUserSupervisor.getInstance().getBy(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Price of this ticket.
 */
   public Integer getPrice(){
      // TODO: Implement Operation getPrice
      return null;
   }
/**
 * Tries to book.
 */
   public TicketState book(){
      // TODO: Implement Operation book
      return null;
   }
/**
 * Tries to reserve.
 */
   public TicketState reserve(){
      // TODO: Implement Operation reserve
      return null;
   }
/**
 * Tries to unreserve.
 */
   public TicketState unreserve(){
      // TODO: Implement Operation unreserve
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

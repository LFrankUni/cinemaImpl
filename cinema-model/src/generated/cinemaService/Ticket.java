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
import generated.cinemaService.proxies.ITicket;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Ticket extends Observable implements java.io.Serializable, ITicket
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String state;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Ticket(Integer id, Seat seat, String state, MovieShow movieShow, User user, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      ticketSeatSupervisor.getInstance().set(this, seat);
      this.state = state;
      if(objectOnly) return;
      try{ticketsOfMovieShowSupervisor.getInstance().add(movieShow,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
      try{ticketsOfUserSupervisor.getInstance().add(user,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Ticket createAlreadyPersistent(Integer id, Seat seat, String state, MovieShow movieShow, User user)throws PersistenceException{
      return new Ticket(id, seat, state, movieShow, user, true);
   }
   public static Ticket createFresh(Seat seat, String state, MovieShow movieShow, User user)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Ticket", "id, typeKey, state", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Ticket").toString() + ", " + "'" + state + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Ticket me = new Ticket(id, seat, state, movieShow, user, false);
      generated.cinemaService.proxies.TicketProxy p = new generated.cinemaService.proxies.TicketProxy(me);
      CinemaService.getInstance().addTicketProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Ticket getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITicket)) return false;
      return ((ITicket)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Seat getSeat() throws PersistenceException{
      return ticketSeatSupervisor.getInstance().getSeat(this).getTheObject();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      ticketSeatSupervisor.getInstance().change(this, this.getSeat(), newSeat);
   }
   public String getState() {
      return this.state;
   }
   public void setState(String newState) throws PersistenceException{
      this.state = newState;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Ticket", "state", "'" + newState + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return ticketsOfMovieShowSupervisor.getInstance().getMovieShow(this).getTheObject();
   }
   public User getUser() throws PersistenceException{
      return ticketsOfUserSupervisor.getInstance().getUser(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Price of this ticket.
 */
   public Integer getPrice(){
      // TODO: Implement Operation getPrice
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

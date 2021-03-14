/**--- Generated at Sun Mar 14 13:03:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.TicketProxy;
import generated.cinemaService.proxies.ITicket;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Optional;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Ticket extends TicketAction implements java.io.Serializable, ITicket
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private Ticket(Integer id, Seat seat, MovieShow movieShow, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      ticketToSeatSupervisor.getInstance().set(this, seat);
      if(objectOnly) return;
      try{movieShowToTicketSupervisor.getInstance().add(movieShow,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Ticket createAlreadyPersistent(TicketProxy proxy, Seat seat, MovieShow movieShow)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Ticket(proxy.getId(), seat, movieShow, true);
   }
   public static Ticket createFresh(Seat seat, MovieShow movieShow)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Ticket").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Ticket me = new Ticket(id, seat, movieShow, false);
      CinemaService.getInstance().addTicketProxy(new TicketProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public Ticket getTheObject(){
      return this;
   }
   public Seat getSeat() throws PersistenceException{
      return ticketToSeatSupervisor.getInstance().getSeat(this).getTheObject();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      ticketToSeatSupervisor.getInstance().change(this, this.getSeat(), newSeat);
   }
   public Optional<User> getUser() throws PersistenceException{
      Optional<IUser> opt = TicketsOfUserSupervisor.getInstance().getUser(this);
      return opt.isPresent() ? Optional.of(TicketsOfUserSupervisor.getInstance().getUser(this).get().getTheObject()) : Optional.empty();
   }
   public void setUser(User newUser)throws PersistenceException{
      if(this.getUser().isPresent()) TicketsOfUserSupervisor.getInstance().change(this, this.getUser().get(), newUser); else TicketsOfUserSupervisor.getInstance().set(this, newUser);
   }
   public Optional<TicketState> getState() throws PersistenceException{
      Optional<ITicketState> opt = TicketToStateSupervisor.getInstance().getState(this);
      return opt.isPresent() ? Optional.of(TicketToStateSupervisor.getInstance().getState(this).get().getTheObject()) : Optional.empty();
   }
   public void setState(TicketState newState)throws ConstraintViolation, PersistenceException{
      if(this.getState().isPresent()) TicketToStateSupervisor.getInstance().change(this, this.getState().get(), newState); else TicketToStateSupervisor.getInstance().set(this, newState);
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return movieShowToTicketSupervisor.getInstance().getMovieShow(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Returns the seat of this ticket.
	 */
	public Seat getTheSeat() throws ModelException {
		return this.getSeat();
	}

	/**
	 * Cost of this ticket.
	 */
	public Integer getPrice() throws ModelException {
		return this.getMovieShow().getPriceInCent() + this.getSeat().getRow().getCategory().getPriceInCents();
	}

	/**
	 * Unreserves the ticket if possible.
	 */
	public Ticket unreserve() throws ModelException {
		return this.getState().get().unreserve();
	}

	/**
	 * Reserves the ticket if possible.
	 */
	public Ticket reserve(User user) throws ModelException {
		return this.getState().get().reserve(user);
	}

	/**
	 * Books the ticket if possible.
	 */
	public Ticket book() throws ModelException {
		return this.getState().get().book();
	}
/**
 *  
 */
   public String getTheState()throws ModelException{
      return this.getState().get().toString();
   }
/**
 *  
 */
   public User getTheUser()throws ModelException{
      return this.getUser().orElse(null);
   }
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Sun Mar 14 22:23:09 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.ReservedProxy;
import generated.cinemaService.proxies.IReserved;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reserved extends TicketState implements java.io.Serializable, IReserved
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private Reserved(Integer id, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reserved createAlreadyPersistent(ReservedProxy proxy)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reserved(proxy.getId(), true);
   }
   public static Reserved createFresh()throws ConstraintViolation, PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Reserved").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reserved me = new Reserved(id, false);
      CinemaService.getInstance().addReservedProxy(new ReservedProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public Reserved getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Unreserves the ticket if possible.
	 */
	public Ticket unreserve() throws ModelException {
		final Ticket ticket = this.getTicket().get();
		// TODO eigentlich ticket.setUser(null), aber db sagt nein 
		ticket.setState(Available.createFresh());
		return ticket;
	}

	/**
	 * Reserves the ticket if possible.
	 */
	public Ticket reserve(User user) throws ModelException {
		throw new ModelException("Must not reserve a reserved Ticket");
	}

	/**
	 * Books the ticket if possible.
	 */
	public Ticket book() throws ModelException {
		final Ticket ticket = this.getTicket().get();
		ticket.setState(Booked.createFresh());
		return ticket;
	}

	/**
	 *  
	 */
	public String toString() {
		return "Reserved";
	}
//90 ===== GENERATED: End of Your Operations ======
}

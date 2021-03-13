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
import generated.cinemaService.proxies.AvailableProxy;
import generated.cinemaService.proxies.IAvailable;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Available extends TicketState implements java.io.Serializable, IAvailable
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

//50 ===== GENERATED:      Constructor ============
   private Available(Integer id, Ticket ticket, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, ticket, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Available createAlreadyPersistent(AvailableProxy proxy, Ticket ticket)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Available(proxy.getId(), ticket, true);
   }
   public static Available createFresh(Ticket ticket)throws ConstraintViolation, PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Available").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Available me = new Available(id, ticket, false);
      CinemaService.getInstance().addAvailableProxy(new AvailableProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

//70 ===== GENERATED:      Feature Access =========
   public Available getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Unreserves the ticket if possible.
	 */
	public Ticket unreserve() throws ModelException {
		throw new ModelException("Must not unreserve an available Ticket");
	}

	/**
	 * Reserves the ticket if possible.
	 */
	public Ticket reserve(User user) throws ModelException {
		this.getTicket().setUser(user);
		this.getTicket().setState(Reserved.createFresh(this.getTicket()));
		return this.getTicket();
	}

	/**
	 * Books the ticket if possible.
	 */
	public Ticket book() throws ModelException {
		throw new ModelException("Must not booked an available Ticket");
	}
/**
 *  
 */
   public String toString(){
      return "Available";
   }
//90 ===== GENERATED: End of Your Operations ======
}

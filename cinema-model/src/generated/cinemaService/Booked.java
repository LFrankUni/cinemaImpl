/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.BookedProxy;
import generated.cinemaService.proxies.IBooked;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Booked extends TicketState implements java.io.Serializable, IBooked
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private Booked(Integer id, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Booked createAlreadyPersistent(BookedProxy proxy)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Booked(proxy.getId(), true);
   }
   public static Booked createFresh()throws ConstraintViolation, PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Booked").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Booked me = new Booked(id, false);
      CinemaService.getInstance().addBookedProxy(new BookedProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public Booked getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Unreserves the ticket if possible.
	 */
	public Ticket unreserve() throws ModelException {
		throw new ModelException("Must not unreserve a booked Ticket");
	}

	/**
	 * Reserves the ticket if possible.
	 */
	public Ticket reserve(User user) throws ModelException {
		throw new ModelException("Must not reserve a booked Ticket");
	}

	/**
	 * Books the ticket if possible.
	 */
	public Ticket book() throws ModelException {
		throw new ModelException("Must not book a booked Ticket");
	}
/**
 *  
 */
   public String toString(){
      return "Booked";
   }
//90 ===== GENERATED: End of Your Operations ======
}

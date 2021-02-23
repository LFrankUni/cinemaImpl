/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
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
   private Reserved(Integer id, Ticket ticket, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, ticket, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reserved createAlreadyPersistent(ReservedProxy proxy, Ticket ticket)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reserved(proxy.getId(), ticket, true);
   }
   public static Reserved createFresh(Ticket ticket)throws ConstraintViolation, PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Reserved").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reserved me = new Reserved(id, ticket, false);
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
 * Reserves the ticket if possible.
 */
   public Ticket reserve(User user)throws ModelException{
      // TODO: Implement Operation reserve
      return null;
   }
/**
 * Books the ticket if possible.
 */
   public Ticket book()throws ModelException{
      // TODO: Implement Operation book
      return null;
   }
/**
 * Unreserves the ticket if possible.
 */
   public Ticket unreserve()throws ModelException{
      // TODO: Implement Operation unreserve
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

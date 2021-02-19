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
import generated.cinemaService.proxies.ITicketState;
import generated.cinemaService.relationControl.*;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaService.proxies.ITicket;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class TicketState extends TicketAction implements java.io.Serializable, ITicketState
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private TicketState(Integer id, boolean objectOnly)
   {
      super(id, objectOnly);
      if(objectOnly) return;
   }
   public static TicketState createAlreadyPersistent(Integer id){
      return new TicketState(id, true);
   }
   public static TicketState createFresh()throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("TicketAction", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "TicketState").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      TicketState me = new TicketState(id, false);
      generated.cinemaService.proxies.TicketStateProxy p = new generated.cinemaService.proxies.TicketStateProxy(me);
      CinemaService.getInstance().addTicketStateProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public TicketState getTheObject(){
      return this;
   }
   public Set<Ticket> getTicket() throws PersistenceException{
      Set<Ticket> result = new HashSet<>();
      for (ITicket i : ticketStateSupervisor.getInstance().getTicket(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
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

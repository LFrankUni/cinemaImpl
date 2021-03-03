/**--- Generated at Wed Mar 03 19:05:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import generated.cinemaService.proxies.ITicketState;
import generated.cinemaService.relationControl.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class TicketState extends TicketAction implements java.io.Serializable, ITicketState
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   public TicketState(Integer id, Ticket ticket, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, objectOnly);
      if(objectOnly) return;
      if(ticket.getState().isPresent()) throw new ConstraintViolation("Object cannot be instantiated, because " + ticket+ " is full");
      try{TicketToStateSupervisor.getInstance().set(ticket,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public TicketState getTheObject(){
      return this;
   }
   public Ticket getTicket() throws PersistenceException{
      return TicketToStateSupervisor.getInstance().getTicket(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
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
import java.util.Optional;
import generated.cinemaService.proxies.ITicket;
import java.util.List;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class TicketState extends TicketAction implements java.io.Serializable, ITicketState
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   public TicketState(Integer id, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, objectOnly);
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public TicketState getTheObject(){
      return this;
   }
   public Optional<Ticket> getTicket() throws PersistenceException{
      Optional<ITicket> opt = TicketToStateSupervisor.getInstance().getTicket(this);
      return opt.isPresent() ? Optional.of(TicketToStateSupervisor.getInstance().getTicket(this).get().getTheObject()) : Optional.empty();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

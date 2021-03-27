/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketState;
import generated.cinemaService.Ticket;
import java.util.Optional;
public interface ITicketState extends ITicketAction{
   public TicketState getTheObject();
   public Optional<Ticket> getTicket() throws PersistenceException;
}

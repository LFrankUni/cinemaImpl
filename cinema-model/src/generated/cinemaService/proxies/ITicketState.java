/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketState;
import generated.cinemaService.Ticket;
import java.util.Set;
public interface ITicketState extends ITicketAction{
   public TicketState getTheObject();
   public Integer getId();
   public Set<Ticket> getTicket() throws PersistenceException;
   public TicketState book();
   public TicketState reserve();
   public TicketState unreserve();
}

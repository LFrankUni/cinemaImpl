/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.TicketState;
public interface ITicketAction extends Identifiable{
   public TicketAction getTheObject();
   public abstract TicketState book();
   public abstract TicketState reserve();
   public abstract TicketState unreserve();
}

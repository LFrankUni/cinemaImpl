/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.Ticket;
import generated.cinemaService.User;
import generated.cinemaService.ModelException;
public interface ITicketAction extends Identifiable{
   public TicketAction getTheObject();
   public abstract Ticket reserve(User user)throws ModelException;
   public abstract Ticket book()throws ModelException;
   public abstract Ticket unreserve()throws ModelException;
}

/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.Ticket;
import generated.cinemaService.ModelException;
import generated.cinemaService.User;
public interface ITicketAction extends Identifiable{
   public TicketAction getTheObject();
   public abstract Ticket unreserve()throws ModelException;
   public abstract Ticket book()throws ModelException;
   public abstract Ticket reserve(User user)throws ModelException;
}

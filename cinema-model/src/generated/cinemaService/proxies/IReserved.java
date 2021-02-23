/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Reserved;
import generated.cinemaService.Ticket;
import generated.cinemaService.User;
import generated.cinemaService.ModelException;
public interface IReserved extends ITicketState{
   public Reserved getTheObject();
   public Integer getId();
   public Ticket reserve(User user)throws ModelException;
   public Ticket book()throws ModelException;
   public Ticket unreserve()throws ModelException;
}

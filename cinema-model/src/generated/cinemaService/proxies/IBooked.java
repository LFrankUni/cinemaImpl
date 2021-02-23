/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Booked;
import generated.cinemaService.Ticket;
import generated.cinemaService.User;
import generated.cinemaService.ModelException;
public interface IBooked extends ITicketState{
   public Booked getTheObject();
   public Integer getId();
   public Ticket reserve(User user)throws ModelException;
   public Ticket book()throws ModelException;
   public Ticket unreserve()throws ModelException;
}

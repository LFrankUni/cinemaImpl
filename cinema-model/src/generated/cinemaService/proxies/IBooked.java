/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Booked;
import generated.cinemaService.Ticket;
import generated.cinemaService.ModelException;
import generated.cinemaService.User;
public interface IBooked extends ITicketState{
   public Booked getTheObject();
   public Integer getId();
   public Ticket unreserve()throws ModelException;
   public Ticket book()throws ModelException;
   public Ticket reserve(User user)throws ModelException;
}

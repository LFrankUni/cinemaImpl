/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.Ticket;
import generated.cinemaService.User;
import generated.cinemaService.ModelException;
public abstract class TicketActionProxy implements ITicketAction{
   public abstract TicketAction getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ITicketAction)) return false;
      return ((ITicketAction)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public abstract Ticket reserve(User user)throws ModelException;
   public abstract Ticket book()throws ModelException;
   public abstract Ticket unreserve()throws ModelException;
}

/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.Ticket;
import generated.cinemaService.ModelException;
import generated.cinemaService.User;
public abstract class TicketActionProxy implements ITicketAction{
   public abstract TicketAction getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ITicketAction)) return false;
      return ((ITicketAction)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public abstract Ticket unreserve()throws ModelException;
   public abstract Ticket book()throws ModelException;
   public abstract Ticket reserve(User user)throws ModelException;
}

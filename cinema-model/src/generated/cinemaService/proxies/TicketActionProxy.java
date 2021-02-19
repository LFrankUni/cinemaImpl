/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
import generated.cinemaService.TicketState;
public abstract class TicketActionProxy implements ITicketAction{
   public abstract TicketAction getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ITicketAction)) return false;
      return ((ITicketAction)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public abstract TicketState book();
   public abstract TicketState reserve();
   public abstract TicketState unreserve();
}

/**--- Generated at Sun Mar 07 13:57:14 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.TicketAction;
public abstract class TicketActionProxy implements ITicketAction{
   public abstract TicketAction getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ITicketAction)) return false;
      return ((ITicketAction)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
}

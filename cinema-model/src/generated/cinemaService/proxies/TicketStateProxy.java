/**--- Generated at Sun Mar 14 13:03:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.TicketState;
import generated.cinemaService.Ticket;
public abstract class TicketStateProxy extends TicketActionProxy implements ITicketState{
   public abstract TicketState getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ITicketState)) return false;
      return ((ITicketState)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Ticket getTicket() throws PersistenceException{
      return this.getTheObject().getTicket();
   }
}

/**--- Generated at Wed Mar 03 18:19:11 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.TicketState;
import generated.cinemaService.Ticket;
public interface ITicketState extends ITicketAction{
   public TicketState getTheObject();
   public Ticket getTicket() throws PersistenceException;
}

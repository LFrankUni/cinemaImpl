/**--- Generated at Fri Mar 12 16:48:52 CET 2021 
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

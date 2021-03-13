/**--- Generated at Sat Mar 13 12:12:32 CET 2021 
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

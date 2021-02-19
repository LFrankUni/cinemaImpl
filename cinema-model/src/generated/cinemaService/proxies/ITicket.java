/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Ticket;
import generated.cinemaService.TicketState;
import generated.cinemaService.Seat;
import generated.cinemaService.MovieShow;
import generated.cinemaService.User;
public interface ITicket extends ITicketAction{
   public Ticket getTheObject();
   public Integer getId();
   public TicketState getState() throws PersistenceException;
   public void setState(TicketState newState)throws PersistenceException;
   public Seat getSeat() throws PersistenceException;
   public void setSeat(Seat newSeat)throws PersistenceException;
   public MovieShow getMovieShow() throws PersistenceException;
   public User getBy() throws PersistenceException;
   public Integer getPrice();
   public TicketState book();
   public TicketState reserve();
   public TicketState unreserve();
}

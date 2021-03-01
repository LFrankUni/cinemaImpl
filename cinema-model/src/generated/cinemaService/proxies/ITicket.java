/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Ticket;
import generated.cinemaService.Seat;
import generated.cinemaService.TicketState;
import exceptions.ConstraintViolation;
import java.util.Optional;
import generated.cinemaService.MovieShow;
import generated.cinemaService.User;
public interface ITicket extends ITicketAction{
   public Ticket getTheObject();
   public Integer getId();
   public Seat getSeat() throws PersistenceException;
   public void setSeat(Seat newSeat)throws PersistenceException;
   public Optional<TicketState> getState() throws PersistenceException;
   public void setState(TicketState newState)throws ConstraintViolation, PersistenceException;
   public MovieShow getMovieShow() throws PersistenceException;
   public User getUser() throws PersistenceException;
}

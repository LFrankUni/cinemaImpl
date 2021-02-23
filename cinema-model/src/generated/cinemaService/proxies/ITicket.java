/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
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
import generated.cinemaService.ModelException;
public interface ITicket extends ITicketAction{
   public Ticket getTheObject();
   public Integer getId();
   public Seat getSeat() throws PersistenceException;
   public void setSeat(Seat newSeat)throws PersistenceException;
   public Optional<TicketState> getState() throws PersistenceException;
   public void setState(TicketState newState)throws ConstraintViolation, PersistenceException;
   public MovieShow getMovieShow() throws PersistenceException;
   public User getUser() throws PersistenceException;
   public Seat getTheSeat()throws ModelException;
   public Integer getPrice()throws ModelException;
   public Ticket reserve(User user)throws ModelException;
   public Ticket book()throws ModelException;
   public Ticket unreserve()throws ModelException;
}

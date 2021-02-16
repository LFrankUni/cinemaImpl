/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.MovieShow;
import generated.cinemaService.Movie;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
import generated.cinemaService.User;
import generated.cinemaService.SeatAlreadyBookedException;
import generated.cinemaService.SeatAlreadyReservedException;
public interface IMovieShow extends Identifiable{
   public MovieShow getTheObject();
   public Integer getId();
   public Movie getShownMovie() throws PersistenceException;
   public void setShownMovie(Movie newShownMovie)throws PersistenceException;
   public Set<Ticket> getTickets() throws PersistenceException;
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public String getStart() ;
   public void setStart(String newStart) throws PersistenceException;
   public String getEnd() ;
   public void setEnd(String newEnd) throws PersistenceException;
   public Integer getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
   public Room getRoom() throws PersistenceException;
   public Ticket book(Integer seat, Integer row, User by)throws SeatAlreadyBookedException;
   public Ticket reserve(Integer seat, Integer row, User by)throws SeatAlreadyReservedException;
}

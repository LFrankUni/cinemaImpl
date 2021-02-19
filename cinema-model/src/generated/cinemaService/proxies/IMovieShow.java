/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.MovieShow;
import generated.cinemaService.Movie;
import java.util.List;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
import generated.cinemaService.Seat;
import generated.cinemaService.User;
import generated.cinemaService.SeatAlreadyReservedException;
public interface IMovieShow extends IHasIncome{
   public MovieShow getTheObject();
   public Integer getId();
   public List<Movie> getMovie() throws PersistenceException;
   public void addToMovie(Movie arg) throws PersistenceException;
   public boolean removeFromMovie(Movie arg) throws PersistenceException;
   public Set<Ticket> getTickets() throws PersistenceException;
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public String getStart() ;
   public void setStart(String newStart) throws PersistenceException;
   public String getEnd() ;
   public void setEnd(String newEnd) throws PersistenceException;
   public Integer getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
   public Boolean getThreeD() ;
   public void setThreeD(Boolean newThreeD) throws PersistenceException;
   public Room getRoom() throws PersistenceException;
   public Ticket reserve(Seat seat, User by)throws SeatAlreadyReservedException;
   public Integer income();
}

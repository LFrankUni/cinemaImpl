/**--- Generated at Sun Mar 07 13:57:14 CET 2021 
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
public interface IMovieShow extends IHasIncome{
   public MovieShow getTheObject();
   public Integer getId();
   public Movie getMovie() throws PersistenceException;
   public void setMovie(Movie newMovie)throws PersistenceException;
   public Set<Ticket> getTickets() throws PersistenceException;
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public String getStart() ;
   public void setStart(String newStart) throws PersistenceException;
   public String getEnd() ;
   public void setEnd(String newEnd) throws PersistenceException;
   public Boolean getThreeDimensional() ;
   public void setThreeDimensional(Boolean newThreeDimensional) throws PersistenceException;
   public Integer getPriceInCent() ;
   public void setPriceInCent(Integer newPriceInCent) throws PersistenceException;
   public Room getRoom() throws PersistenceException;
}

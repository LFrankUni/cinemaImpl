/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.MovieShow;
import generated.cinemaService.Movie;
import exceptions.ConstraintViolation;
import java.util.Optional;
import generated.cinemaService.Ticket;
import java.util.Set;
import generated.cinemaService.Room;
import generated.cinemaService.ModelException;
import java.util.Collection;
public interface IMovieShow extends IHasIncome{
   public MovieShow getTheObject();
   public Integer getId();
   public Optional<Movie> getMovie() throws PersistenceException;
   public void setMovie(Movie newMovie)throws ConstraintViolation, PersistenceException;
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
   public Movie getTheMovie()throws ModelException;
   public Collection<Ticket> getAllTickets()throws ModelException;
   public Integer income()throws ModelException;
}

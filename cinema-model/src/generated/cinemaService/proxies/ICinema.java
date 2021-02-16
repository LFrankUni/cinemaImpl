/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Cinema;
import generated.cinemaService.Room;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Movie;
public interface ICinema extends Identifiable{
   public Cinema getTheObject();
   public Integer getId();
   public Set<Room> getRoomes() throws PersistenceException;
   public void addToRoomes(Room arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromRoomes(Room arg) throws ConstraintViolation, PersistenceException;
   public Set<Movie> getMovies() throws PersistenceException;
   public void addToMovies(Movie arg) throws PersistenceException;
   public boolean removeFromMovies(Movie arg) throws PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}

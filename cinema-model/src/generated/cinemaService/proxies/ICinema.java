/**--- Generated at Sun Mar 14 22:23:08 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Cinema;
import generated.cinemaService.Movie;
import java.util.Set;
import generated.cinemaService.Room;
import exceptions.ConstraintViolation;
public interface ICinema extends IHasIncome{
   public Cinema getTheObject();
   public Integer getId();
   public Set<Movie> getMovies() throws PersistenceException;
   public void addToMovies(Movie arg) throws PersistenceException;
   public boolean removeFromMovies(Movie arg) throws PersistenceException;
   public Set<Room> getRoomes() throws PersistenceException;
   public void addToRoomes(Room arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromRoomes(Room arg) throws ConstraintViolation, PersistenceException;
   public String getNameOfCinema() ;
   public void setNameOfCinema(String newNameOfCinema) throws PersistenceException;
}

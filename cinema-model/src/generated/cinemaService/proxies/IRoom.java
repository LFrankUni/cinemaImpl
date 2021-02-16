/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Room;
import generated.cinemaService.MovieShow;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Cinema;
import generated.cinemaService.ScheduleError;
public interface IRoom extends Identifiable{
   public Room getTheObject();
   public Integer getId();
   public Set<MovieShow> getShows() throws PersistenceException;
   public void addToShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
   public Cinema getCinema() throws PersistenceException;
   public void scheduleShow(MovieShow show)throws ScheduleError;
}

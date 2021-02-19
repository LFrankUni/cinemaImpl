/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Room;
import generated.cinemaService.MovieShow;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Cinema;
import generated.cinemaService.ScheduleError;
public interface IRoom extends IHasIncome{
   public Room getTheObject();
   public Integer getId();
   public Set<MovieShow> getMovieShows() throws PersistenceException;
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public Set<AbstractRow> getRows() throws PersistenceException;
   public void addToRows(AbstractRow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromRows(AbstractRow arg) throws ConstraintViolation, PersistenceException;
   public String getRoomName() ;
   public void setRoomName(String newRoomName) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
   public Cinema getCinema() throws PersistenceException;
   public void open();
   public void scheduleShow(MovieShow show)throws ScheduleError;
   public void close();
   public Integer income();
}

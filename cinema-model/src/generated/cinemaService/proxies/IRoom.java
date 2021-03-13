/**--- Generated at Sat Mar 13 11:01:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Room;
import generated.cinemaService.MovieShow;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.RoomRow;
import generated.cinemaService.Cinema;
import java.util.Collection;
import generated.cinemaService.Movie;
import generated.cinemaService.ModelException;
public interface IRoom extends IHasIncome{
   public Room getTheObject();
   public Integer getId();
   public Set<MovieShow> getMovieShows() throws PersistenceException;
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public Set<RoomRow> getRows() throws PersistenceException;
   public void addToRows(RoomRow arg) throws PersistenceException;
   public boolean removeFromRows(RoomRow arg) throws PersistenceException;
   public String getNameOfRoom() ;
   public void setNameOfRoom(String newNameOfRoom) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
   public Cinema getCinema() throws PersistenceException;
   public Collection<MovieShow> checkSchedule(Movie movie, String start, Integer days)throws ModelException;
}

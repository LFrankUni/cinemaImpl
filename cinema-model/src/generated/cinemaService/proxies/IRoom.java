/**--- Generated at Sun Mar 14 00:09:50 CET 2021 
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
}

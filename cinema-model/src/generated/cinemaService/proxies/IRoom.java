/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
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
import generated.cinemaService.Movie;
import generated.cinemaService.ModelException;
import java.util.Collection;
public interface IRoom extends IHasIncome{
   public Room getTheObject();
   public Integer getId();
   public Set<MovieShow> getMovieShows() throws PersistenceException;
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException;
   public Set<AbstractRow> getRows() throws PersistenceException;
   public void addToRows(AbstractRow arg) throws PersistenceException;
   public boolean removeFromRows(AbstractRow arg) throws PersistenceException;
   public String getNameOfRoom() ;
   public void setNameOfRoom(String newNameOfRoom) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
   public MovieShow scheduleMovieShow(Movie movie, String start, String end, Boolean threeDimensional, Integer price)throws ModelException;
   public void addRow(AbstractRow row)throws ModelException;
   public void close()throws ModelException;
   public void open()throws ModelException;
   public Collection<Room> getAllRows()throws ModelException;
   public Integer income()throws ModelException;
}

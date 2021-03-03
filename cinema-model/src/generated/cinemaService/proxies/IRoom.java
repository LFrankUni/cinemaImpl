/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
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
import generated.cinemaService.RowCategory;
import generated.cinemaService.Movie;
import generated.cinemaService.ModelException;
import java.util.Collection;
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
   public MovieShow scheduleMovieShow(Movie movie, String start, String end, String begin, Boolean threeDimensional, Integer price)throws ModelException;
   public RoomRow addRow(String name, RowCategory category)throws ModelException;
   public Collection<RoomRow> getAllRows()throws ModelException;
   public void open()throws ModelException;
   public void close()throws ModelException;
   public Integer income()throws ModelException;
}

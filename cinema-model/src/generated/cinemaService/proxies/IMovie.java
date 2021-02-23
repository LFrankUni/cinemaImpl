/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Movie;
import generated.cinemaService.MovieShow;
import java.util.Collection;
import generated.cinemaService.ModelException;
public interface IMovie extends IHasIncome{
   public Movie getTheObject();
   public Integer getId();
   public String getTitle() ;
   public void setTitle(String newTitle) throws PersistenceException;
   public String getDescription() ;
   public void setDescription(String newDescription) throws PersistenceException;
   public Integer getMinutes() ;
   public void setMinutes(Integer newMinutes) throws PersistenceException;
   public MovieShow getMovieShow() throws PersistenceException;
   public Collection<MovieShow> getAllMovieShows(String from, String to)throws ModelException;
   public Integer income()throws ModelException;
}

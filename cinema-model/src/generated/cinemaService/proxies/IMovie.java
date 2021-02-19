/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Movie;
import generated.cinemaService.MovieShow;
import java.util.Set;
public interface IMovie extends IHasIncome{
   public Movie getTheObject();
   public Integer getId();
   public String getTitel() ;
   public void setTitel(String newTitel) throws PersistenceException;
   public String getDescription() ;
   public void setDescription(String newDescription) throws PersistenceException;
   public Integer getMinutes() ;
   public void setMinutes(Integer newMinutes) throws PersistenceException;
   public Set<MovieShow> getShow() throws PersistenceException;
   public Integer income();
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Movie;
public interface IMovie extends Identifiable{
   public Movie getTheObject();
   public Integer getId();
   public String getTitel() ;
   public void setTitel(String newTitel) throws PersistenceException;
   public String getDescription() ;
   public void setDescription(String newDescription) throws PersistenceException;
   public Integer getMinutes() ;
   public void setMinutes(Integer newMinutes) throws PersistenceException;
}

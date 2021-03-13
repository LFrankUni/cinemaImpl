/**--- Generated at Sat Mar 13 12:12:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.RowCategory;
public interface IRowCategory extends Identifiable{
   public RowCategory getTheObject();
   public Integer getId();
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public Integer getPriceInCents() ;
   public void setPriceInCents(Integer newPriceInCents) throws PersistenceException;
}

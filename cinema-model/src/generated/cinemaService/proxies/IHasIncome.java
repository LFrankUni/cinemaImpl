/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.HasIncome;
import generated.cinemaService.ModelException;
public interface IHasIncome extends Identifiable{
   public HasIncome getTheObject();
   public abstract Integer income()throws ModelException;
}

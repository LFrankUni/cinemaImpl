/**--- Generated at Sat Mar 13 11:01:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.HasIncome;
public abstract class HasIncomeProxy implements IHasIncome{
   public abstract HasIncome getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IHasIncome)) return false;
      return ((IHasIncome)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
}

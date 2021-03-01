/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Seat;
import generated.cinemaService.AbstractRow;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public Integer getNumber() ;
   public void setNumber(Integer newNumber) throws PersistenceException;
   public AbstractRow getRow() throws PersistenceException;
}

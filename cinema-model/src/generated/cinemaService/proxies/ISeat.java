/**--- Generated at Wed Mar 03 19:05:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Seat;
import generated.cinemaService.RoomRow;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public Integer getNumber() ;
   public void setNumber(Integer newNumber) throws PersistenceException;
   public RoomRow getRow() throws PersistenceException;
}

/**--- Generated at Sat Mar 13 12:12:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.RoomRow;
import generated.cinemaService.RowCategory;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
public interface IRoomRow extends Identifiable{
   public RoomRow getTheObject();
   public Integer getId();
   public RowCategory getCategory() throws PersistenceException;
   public void setCategory(RowCategory newCategory)throws PersistenceException;
   public Set<Seat> getSeats() throws PersistenceException;
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}

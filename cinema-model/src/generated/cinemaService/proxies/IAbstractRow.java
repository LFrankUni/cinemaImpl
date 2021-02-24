/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
public interface IAbstractRow extends Identifiable{
   public AbstractRow getTheObject();
   public Set<Seat> getSeats() throws PersistenceException;
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public Integer getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
   public Integer getNumber() ;
   public void setNumber(Integer newNumber) throws PersistenceException;
   public Room getRoom() throws PersistenceException;
}
/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
public interface IAbstractRow extends Identifiable{
   public AbstractRow getTheObject();
   public Set<Seat> getSeats() throws PersistenceException;
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public Integer getPriceInCent() ;
   public void setPriceInCent(Integer newPriceInCent) throws PersistenceException;
}

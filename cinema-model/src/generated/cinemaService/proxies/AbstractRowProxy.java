/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
public abstract class AbstractRowProxy implements IAbstractRow{
   public abstract AbstractRow getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IAbstractRow)) return false;
      return ((IAbstractRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Seat> getSeats() throws PersistenceException{
      return this.getTheObject().getSeats();
   }
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToSeats(arg);
   }
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromSeats(arg);
   }
   public Integer getPrice() {
      return this.getTheObject().getPrice();
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.getTheObject().setPrice(newPrice);
   }
   public Integer getNumber() {
      return this.getTheObject().getNumber();
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.getTheObject().setNumber(newNumber);
   }
   public Room getRoom() throws PersistenceException{
      return this.getTheObject().getRoom();
   }
}

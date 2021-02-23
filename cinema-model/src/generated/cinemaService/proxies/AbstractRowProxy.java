/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.ModelException;
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
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public Integer getPriceInCent() {
      return this.getTheObject().getPriceInCent();
   }
   public void setPriceInCent(Integer newPriceInCent) throws PersistenceException{
      this.getTheObject().setPriceInCent(newPriceInCent);
   }
   public void addSeat(Seat seat)throws ModelException{
      this.getTheObject().addSeat(seat);
   }
}

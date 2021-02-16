/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import observation.Observable;
import generated.cinemaService.proxies.IAbstractRow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
import db.executer.PersistenceExecuterFactory;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class AbstractRow extends Observable implements java.io.Serializable, IAbstractRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer price;
   private Integer number;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public AbstractRow(Integer id, Integer price, Integer number, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.price = price;
      this.number = number;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public AbstractRow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IAbstractRow)) return false;
      return ((IAbstractRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Seat> getSeats() throws PersistenceException{
      Set<Seat> result = new HashSet<>();
      for (ISeat i : seatsSupervisor.getInstance().getSeats(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      seatsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      return seatsSupervisor.getInstance().remove(this, arg);
   }
   public Integer getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = newPrice;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("AbstractRow", "price", newPrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getNumber() {
      return this.number;
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.number = newNumber;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("AbstractRow", "number", newNumber.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

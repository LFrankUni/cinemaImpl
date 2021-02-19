/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.ISeat;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Seat extends Observable implements java.io.Serializable, ISeat
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer number;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Seat(Integer id, Integer number, AbstractRow row, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      this.number = number;
      if(objectOnly) return;
      try{seatsOfRowSupervisor.getInstance().add(row,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Seat createAlreadyPersistent(Integer id, Integer number, AbstractRow row)throws PersistenceException{
      return new Seat(id, number, row, true);
   }
   public static Seat createFresh(Integer number, AbstractRow row)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Seat", "id, typeKey, number", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Seat").toString() + ", " + number.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Seat me = new Seat(id, number, row, false);
      generated.cinemaService.proxies.SeatProxy p = new generated.cinemaService.proxies.SeatProxy(me);
      CinemaService.getInstance().addSeatProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Seat getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Integer getNumber() {
      return this.number;
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.number = newNumber;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Seat", "number", newNumber.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public AbstractRow getRow() throws PersistenceException{
      return seatsOfRowSupervisor.getInstance().getRow(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Price of this seat. Depends on row.
 */
   public Integer price(){
      // TODO: Implement Operation price
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

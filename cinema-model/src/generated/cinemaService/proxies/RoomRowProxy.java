/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.RoomRow;
import java.sql.ResultSet;
import generated.cinemaService.RowCategory;
import generated.cinemaService.relationControl.rowToCategorySupervisor;
import generated.cinemaService.Seat;
import java.util.Set;
import exceptions.ConstraintViolation;
public class RoomRowProxy implements IRoomRow{
   private Integer id;
   private Optional<RoomRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public RoomRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public RoomRowProxy(RoomRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public RoomRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "RoomRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoomRow)) return false;
      return ((IRoomRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private RoomRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("RoomRow", this.id);
         RowCategory category = rowToCategorySupervisor.getInstance().getCategory(this).getTheObject();
         String name = rs.getString("name");
         return RoomRow.createAlreadyPersistent(this, category, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public RowCategory getCategory() throws PersistenceException{
      return this.getTheObject().getCategory();
   }
   public void setCategory(RowCategory newCategory)throws PersistenceException{
      this.getTheObject().setCategory(newCategory);
   }
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
}

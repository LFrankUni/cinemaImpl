/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.BackRow;
import java.sql.ResultSet;
import generated.cinemaService.Room;
import generated.cinemaService.relationControl.rowsOfRoomSupervisor;
public class BackRowProxy extends AbstractRowProxy implements IBackRow{
   private Integer id;
   private Optional<BackRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BackRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BackRowProxy(BackRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public BackRow getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "BackRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBackRow)) return false;
      return ((IBackRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private BackRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("AbstractRow", this.id);
         Integer price = rs.getInt("price");
         Integer number = rs.getInt("number");
         Room room = rowsOfRoomSupervisor.getInstance().getRoom(this).getTheObject();
         return BackRow.createAlreadyPersistent(id, price, number, room);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

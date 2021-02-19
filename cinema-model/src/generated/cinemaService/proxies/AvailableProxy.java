/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Available;
import java.sql.ResultSet;
public class AvailableProxy implements IAvailable{
   private Integer id;
   private Optional<Available> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public AvailableProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public AvailableProxy(Available theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Available getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Available";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IAvailable)) return false;
      return ((IAvailable)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Available load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Available", this.id);
         return Available.createAlreadyPersistent(id);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

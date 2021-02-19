/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Reserved;
import java.sql.ResultSet;
public class ReservedProxy implements IReserved{
   private Integer id;
   private Optional<Reserved> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservedProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservedProxy(Reserved theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Reserved getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reserved";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReserved)) return false;
      return ((IReserved)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reserved load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reserved", this.id);
         return Reserved.createAlreadyPersistent(id);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

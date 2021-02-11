/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.test.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.test.Class_2;
import java.sql.ResultSet;
public class Class_2Proxy implements IClass_2{
   private Integer id;
   private Optional<Class_2> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public Class_2Proxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public Class_2Proxy(Class_2 theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Class_2 getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Class_2";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IClass_2)) return false;
      return ((IClass_2)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Class_2 load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Class_2", this.id);
         return Class_2.createAlreadyPersistent(id);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

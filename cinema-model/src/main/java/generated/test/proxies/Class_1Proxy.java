/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.test.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.test.Class_1;
import java.sql.ResultSet;
import generated.test.Class_2;
import generated.test.relationControl.class_1_has_class_2Supervisor;
public class Class_1Proxy implements IClass_1{
   private Integer id;
   private Optional<Class_1> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public Class_1Proxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public Class_1Proxy(Class_1 theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Class_1 getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Class_1";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IClass_1)) return false;
      return ((IClass_1)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Class_1 load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Class_1", this.id);
         Class_2 c2 = class_1_has_class_2Supervisor.getInstance().getC2(this).getTheObject();
         Boolean a1 = rs.getBoolean("a1");
         return Class_1.createAlreadyPersistent(id, c2, a1);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Class_2 getC2() throws PersistenceException{
      return this.getTheObject().getC2();
   }
   public void setC2(Class_2 newC2)throws PersistenceException{
      this.getTheObject().setC2(newC2);
   }
   public Boolean getA1() {
      return this.getTheObject().getA1();
   }
   public void setA1(Boolean newA1) throws PersistenceException{
      this.getTheObject().setA1(newA1);
   }
}

/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.test;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.test.proxies.IClass_1;
import generated.test.relationControl.*;
import generated.test.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Class_1 extends Observable implements java.io.Serializable, IClass_1
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Boolean a1;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Class_1(Integer id, Class_2 c2, Boolean a1, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      class_1_has_class_2Supervisor.getInstance().set(this, c2);
      this.a1 = a1;
      if(objectOnly) return;
   }
   public static Class_1 createAlreadyPersistent(Integer id, Class_2 c2, Boolean a1)throws PersistenceException{
      return new Class_1(id, c2, a1, true);
   }
   public static Class_1 createFresh(Class_2 c2, Boolean a1)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Class_1", "id, typeKey, a1", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("Test", "Class_1").toString() + ", " + a1.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Class_1 me = new Class_1(id, c2, a1, false);
      generated.test.proxies.Class_1Proxy p = new generated.test.proxies.Class_1Proxy(me);
      Test.getInstance().addClass_1Proxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Class_1 getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IClass_1)) return false;
      return ((IClass_1)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Class_2 getC2() throws PersistenceException{
      return class_1_has_class_2Supervisor.getInstance().getC2(this).getTheObject();
   }
   public void setC2(Class_2 newC2)throws PersistenceException{
      class_1_has_class_2Supervisor.getInstance().change(this, this.getC2(), newC2);
   }
   public Boolean getA1() {
      return this.a1;
   }
   public void setA1(Boolean newA1) throws PersistenceException{
      this.a1 = newA1;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Class_1", "a1", newA1.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

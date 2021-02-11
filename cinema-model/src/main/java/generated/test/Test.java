/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.test;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.test.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.test.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.DBDMLExecuter;
import db.connection.TypeKeyManager;
import db.connection.DBConnectionManager;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class Test extends Observable{
   DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,Class_1Proxy> class_1Cache;
   private Map<Integer,Class_2Proxy> class_2Cache;
   private static Test theInstance = new Test();
   private Test(){
      try{DBConnectionManager.getTheInstance().openDBConnection(new DBConnectionData("jdbc:mysql://localhost:3306", "Test", "root" , ""));
         TypeKeyManager.getTheInstance().initializeFor("Test");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static Test getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.class_1Cache = new InitialProxyLoader<Class_1Proxy>("generated", "Test", "test", "Class_1", "Class_1").perform();
      this.class_2Cache = new InitialProxyLoader<Class_2Proxy>("generated", "Test", "test", "Class_2", "Class_2").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("class_1_has_class_2").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Class_1", "Test");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Class_2", "Test");
         try{this.addclass_1_has_class_2Element(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addclass_1_has_class_2Element(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IClass_1 proxy1 = null; IClass_2 proxy2 = null; 
      if(className1.equals("Class_1"))  proxy1 = this.class_1Cache.get(id1);
      if(className2.equals("Class_2"))  proxy2 = this.class_2Cache.get(id2);
      class_1_has_class_2Supervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Class_1 getClass_1(Integer id){
      return this.class_1Cache.get(id).getTheObject();
   }
   public void addClass_1Proxy(Class_1Proxy p) throws PersistenceException{
      this.class_1Cache.put(p.getId(), p);
   }
   public Map<Integer,Class_1Proxy> getClass_1Cache(){
      return this.class_1Cache;
   }
   public Class_2 getClass_2(Integer id){
      return this.class_2Cache.get(id).getTheObject();
   }
   public void addClass_2Proxy(Class_2Proxy p) throws PersistenceException{
      this.class_2Cache.put(p.getId(), p);
   }
   public Map<Integer,Class_2Proxy> getClass_2Cache(){
      return this.class_2Cache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

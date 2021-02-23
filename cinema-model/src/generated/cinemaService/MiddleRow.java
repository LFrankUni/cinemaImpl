/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MiddleRowProxy;
import generated.cinemaService.proxies.IMiddleRow;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class MiddleRow extends AbstractRow implements java.io.Serializable, IMiddleRow
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private MiddleRow(Integer id, String name, Integer priceInCent, boolean objectOnly)
   throws PersistenceException{
      super(id, name, priceInCent, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static MiddleRow createAlreadyPersistent(MiddleRowProxy proxy, String name, Integer priceInCent)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new MiddleRow(proxy.getId(), name, priceInCent, true);
   }
   public static MiddleRow createFresh(String name, Integer priceInCent)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, name, priceInCent", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "MiddleRow").toString() + ", " + "'" + name + "'" + ", " + priceInCent.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MiddleRow me = new MiddleRow(id, name, priceInCent, false);
      CinemaService.getInstance().addMiddleRowProxy(new MiddleRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public MiddleRow getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

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
import generated.cinemaService.proxies.BackRowProxy;
import generated.cinemaService.proxies.IBackRow;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class BackRow extends AbstractRow implements java.io.Serializable, IBackRow
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private BackRow(Integer id, String name, Integer priceInCent, boolean objectOnly)
   throws PersistenceException{
      super(id, name, priceInCent, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static BackRow createAlreadyPersistent(BackRowProxy proxy, String name, Integer priceInCent)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new BackRow(proxy.getId(), name, priceInCent, true);
   }
   public static BackRow createFresh(String name, Integer priceInCent)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, name, priceInCent", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "BackRow").toString() + ", " + "'" + name + "'" + ", " + priceInCent.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      BackRow me = new BackRow(id, name, priceInCent, false);
      CinemaService.getInstance().addBackRowProxy(new BackRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public BackRow getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

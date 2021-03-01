/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.ParquetRowProxy;
import generated.cinemaService.proxies.IParquetRow;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class ParquetRow extends AbstractRow implements java.io.Serializable, IParquetRow
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private ParquetRow(Integer id, String name, Integer priceInCent, boolean objectOnly)
   throws PersistenceException{
      super(id, name, priceInCent, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static ParquetRow createAlreadyPersistent(ParquetRowProxy proxy, String name, Integer priceInCent)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new ParquetRow(proxy.getId(), name, priceInCent, true);
   }
   public static ParquetRow createFresh(String name, Integer priceInCent)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, name, priceInCent", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "ParquetRow").toString() + ", " + "'" + name + "'" + ", " + priceInCent.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      ParquetRow me = new ParquetRow(id, name, priceInCent, false);
      CinemaService.getInstance().addParquetRowProxy(new ParquetRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public ParquetRow getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

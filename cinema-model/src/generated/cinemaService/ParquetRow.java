/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
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
   private ParquetRow(Integer id, Integer price, Integer number, boolean objectOnly)
   throws PersistenceException{
      super(id, price, number, objectOnly);
      if(objectOnly) return;
   }
   public static ParquetRow createAlreadyPersistent(Integer id, Integer price, Integer number)throws PersistenceException{
      return new ParquetRow(id, price, number, true);
   }
   public static ParquetRow createFresh(Integer price, Integer number)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, price, number", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "ParquetRow").toString() + ", " + price.toString() + ", " + number.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      ParquetRow me = new ParquetRow(id, price, number, false);
      generated.cinemaService.proxies.ParquetRowProxy p = new generated.cinemaService.proxies.ParquetRowProxy(me);
      CinemaService.getInstance().addParquetRowProxy(p);
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

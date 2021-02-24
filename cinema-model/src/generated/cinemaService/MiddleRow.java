/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
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
   private MiddleRow(Integer id, Integer price, Integer number, Room room, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, price, number, room, objectOnly);
      if(objectOnly) return;
   }
   public static MiddleRow createAlreadyPersistent(Integer id, Integer price, Integer number, Room room)throws PersistenceException, ConstraintViolation{
      return new MiddleRow(id, price, number, room, true);
   }
   public static MiddleRow createFresh(Integer price, Integer number, Room room)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, price, number", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "MiddleRow").toString() + ", " + price.toString() + ", " + number.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MiddleRow me = new MiddleRow(id, price, number, room, false);
      generated.cinemaService.proxies.MiddleRowProxy p = new generated.cinemaService.proxies.MiddleRowProxy(me);
      CinemaService.getInstance().addMiddleRowProxy(p);
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
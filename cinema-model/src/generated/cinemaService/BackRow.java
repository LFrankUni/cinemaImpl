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
   private BackRow(Integer id, Integer price, Integer number, Room room, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, price, number, room, objectOnly);
      if(objectOnly) return;
   }
   public static BackRow createAlreadyPersistent(Integer id, Integer price, Integer number, Room room)throws PersistenceException, ConstraintViolation{
      return new BackRow(id, price, number, room, true);
   }
   public static BackRow createFresh(Integer price, Integer number, Room room)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("AbstractRow", "id, typeKey, price, number", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "BackRow").toString() + ", " + price.toString() + ", " + number.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      BackRow me = new BackRow(id, price, number, room, false);
      generated.cinemaService.proxies.BackRowProxy p = new generated.cinemaService.proxies.BackRowProxy(me);
      CinemaService.getInstance().addBackRowProxy(p);
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
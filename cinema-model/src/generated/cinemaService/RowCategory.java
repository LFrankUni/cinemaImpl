/**--- Generated at Thu Mar 11 18:42:40 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.RowCategoryProxy;
import observation.Observable;
import generated.cinemaService.proxies.IRowCategory;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class RowCategory extends Observable implements java.io.Serializable, IRowCategory
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private Integer priceInCents;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private RowCategory(Integer id, String name, Integer priceInCents, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      this.priceInCents = priceInCents;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static RowCategory createAlreadyPersistent(RowCategoryProxy proxy, String name, Integer priceInCents){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new RowCategory(proxy.getId(), name, priceInCents, true);
   }
   public static RowCategory createFresh(String name, Integer priceInCents)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("RowCategory", "id, typeKey, name, priceInCents", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "RowCategory").toString() + ", " + "'" + name + "'" + ", " + priceInCents.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      RowCategory me = new RowCategory(id, name, priceInCents, false);
      CinemaService.getInstance().addRowCategoryProxy(new RowCategoryProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public RowCategory getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRowCategory)) return false;
      return ((IRowCategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("RowCategory", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getPriceInCents() {
      return this.priceInCents;
   }
   public void setPriceInCents(Integer newPriceInCents) throws PersistenceException{
      this.priceInCents = newPriceInCents;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("RowCategory", "priceInCents", newPriceInCents.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Tue Mar 09 10:12:33 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.RowCategory;
import java.sql.ResultSet;
public class RowCategoryProxy implements IRowCategory{
   private Integer id;
   private Optional<RowCategory> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public RowCategoryProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public RowCategoryProxy(RowCategory theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public RowCategory getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "RowCategory";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRowCategory)) return false;
      return ((IRowCategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private RowCategory load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("RowCategory", this.id);
         String name = rs.getString("name");
         Integer priceInCents = rs.getInt("priceInCents");
         return RowCategory.createAlreadyPersistent(this, name, priceInCents);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public Integer getPriceInCents() {
      return this.getTheObject().getPriceInCents();
   }
   public void setPriceInCents(Integer newPriceInCents) throws PersistenceException{
      this.getTheObject().setPriceInCents(newPriceInCents);
   }
}

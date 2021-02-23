/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.BackRow;
import java.sql.ResultSet;
public class BackRowProxy extends AbstractRowProxy implements IBackRow{
   private Integer id;
   private Optional<BackRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BackRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BackRowProxy(BackRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public BackRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "BackRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBackRow)) return false;
      return ((IBackRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private BackRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("AbstractRow", this.id);
         String name = rs.getString("name");
         Integer priceInCent = rs.getInt("priceInCent");
         return BackRow.createAlreadyPersistent(this, name, priceInCent);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

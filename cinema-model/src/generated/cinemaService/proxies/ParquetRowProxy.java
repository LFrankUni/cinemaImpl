/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.ParquetRow;
import java.sql.ResultSet;
public class ParquetRowProxy extends AbstractRowProxy implements IParquetRow{
   private Integer id;
   private Optional<ParquetRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ParquetRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ParquetRowProxy(ParquetRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public ParquetRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "ParquetRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IParquetRow)) return false;
      return ((IParquetRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private ParquetRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("AbstractRow", this.id);
         String name = rs.getString("name");
         Integer priceInCent = rs.getInt("priceInCent");
         return ParquetRow.createAlreadyPersistent(this, name, priceInCent);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

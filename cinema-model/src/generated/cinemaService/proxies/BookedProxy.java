/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Booked;
import java.sql.ResultSet;
public class BookedProxy implements IBooked{
   private Integer id;
   private Optional<Booked> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BookedProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BookedProxy(Booked theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Booked getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Booked";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooked)) return false;
      return ((IBooked)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Booked load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Booked", this.id);
         return Booked.createAlreadyPersistent(id);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

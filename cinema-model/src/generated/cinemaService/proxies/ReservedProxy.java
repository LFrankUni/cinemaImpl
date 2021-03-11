/**--- Generated at Thu Mar 11 18:42:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Reserved;
import java.sql.ResultSet;
import generated.cinemaService.Ticket;
import generated.cinemaService.relationControl.TicketToStateSupervisor;
public class ReservedProxy extends TicketStateProxy implements IReserved{
   private Integer id;
   private Optional<Reserved> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservedProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservedProxy(Reserved theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reserved getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reserved";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReserved)) return false;
      return ((IReserved)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reserved load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("TicketAction", this.id);
         Ticket ticket = TicketToStateSupervisor.getInstance().getTicket(this).getTheObject();
         return Reserved.createAlreadyPersistent(this, ticket);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

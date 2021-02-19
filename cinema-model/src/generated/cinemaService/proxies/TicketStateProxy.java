/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.TicketState;
import java.sql.ResultSet;
import generated.cinemaService.Ticket;
import java.util.Set;
public class TicketStateProxy extends TicketActionProxy implements ITicketState{
   private Integer id;
   private Optional<TicketState> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public TicketStateProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public TicketStateProxy(TicketState theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public TicketState getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "TicketState";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITicketState)) return false;
      return ((ITicketState)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private TicketState load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("TicketAction", this.id);
         return TicketState.createAlreadyPersistent(id);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Ticket> getTicket() throws PersistenceException{
      return this.getTheObject().getTicket();
   }
   public TicketState book(){
      return this.getTheObject().book();
   }
   public TicketState reserve(){
      return this.getTheObject().reserve();
   }
   public TicketState unreserve(){
      return this.getTheObject().unreserve();
   }
}

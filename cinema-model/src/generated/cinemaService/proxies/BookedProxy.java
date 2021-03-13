/**--- Generated at Sat Mar 13 11:01:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Booked;
import java.sql.ResultSet;
import generated.cinemaService.Ticket;
import generated.cinemaService.relationControl.TicketToStateSupervisor;
public class BookedProxy extends TicketStateProxy implements IBooked{
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
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Booked getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Booked";}
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
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("TicketAction", this.id);
         Ticket ticket = TicketToStateSupervisor.getInstance().getTicket(this).getTheObject();
         return Booked.createAlreadyPersistent(this, ticket);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}

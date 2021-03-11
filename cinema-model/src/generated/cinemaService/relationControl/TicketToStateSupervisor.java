/**--- Generated at Thu Mar 11 18:42:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class TicketToStateSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static TicketToStateSupervisor theInstance = new TicketToStateSupervisor();
   private Relation<ITicket,ITicketState> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private TicketToStateSupervisor(){
      this.elements = new Relation<>("TicketToState");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static TicketToStateSupervisor getInstance(){return theInstance;}
   public Optional<ITicketState> getState(ITicket owner){
      return (this.elements.getRelatedTargets(owner).size() == 0) ? Optional.empty() : Optional.of(this.elements.getRelatedTargets(owner).get(0));
   }
   public void set(ITicket owner, ITicketState target) throws ConstraintViolation, PersistenceException{
      ITicketState targetOld = this.getState(owner).isPresent() ? this.getState(owner).get() : null; ITicketState targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITicket owner, ITicketState target) throws ConstraintViolation{
      ITicketState targetOld = null; ITicketState targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITicket owner, ITicketState targetOld, ITicketState targetNew) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   public ITicket getTicket(ITicketState target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

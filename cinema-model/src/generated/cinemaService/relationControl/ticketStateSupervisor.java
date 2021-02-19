/**--- Generated at Sun Feb 21 20:25:26 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class ticketStateSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static ticketStateSupervisor theInstance = new ticketStateSupervisor();
   private Relation<ITicket,ITicketState> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public ticketStateSupervisor(){
      this.elements = new Relation<>("ticketState");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static ticketStateSupervisor getInstance(){return theInstance;}
   public ITicketState getState(ITicket owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ITicket owner, ITicketState target) throws PersistenceException{
      ITicketState targetOld = this.getState(owner); ITicketState targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITicket owner, ITicketState target) {
      ITicketState targetOld = null; ITicketState targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITicket owner, ITicketState targetOld, ITicketState targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<ITicket> getTicket(ITicketState target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

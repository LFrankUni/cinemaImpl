/**--- Generated at Tue Mar 09 10:12:33 CET 2021 
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
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class TicketsOfUserSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static TicketsOfUserSupervisor theInstance = new TicketsOfUserSupervisor();
   private Relation<ITicket,IUser> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private TicketsOfUserSupervisor(){
      this.elements = new Relation<>("TicketsOfUser");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static TicketsOfUserSupervisor getInstance(){return theInstance;}
   public Optional<IUser> getUser(ITicket owner){
      return (this.elements.getRelatedTargets(owner).size() == 0) ? Optional.empty() : Optional.of(this.elements.getRelatedTargets(owner).get(0));
   }
   public void set(ITicket owner, IUser target) throws PersistenceException{
      IUser targetOld = this.getUser(owner).isPresent() ? this.getUser(owner).get() : null; IUser targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITicket owner, IUser target) {
      IUser targetOld = null; IUser targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITicket owner, IUser targetOld, IUser targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<ITicket> getTickets(IUser target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

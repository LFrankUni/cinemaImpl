/**--- Generated at Tue Feb 16 11:57:42 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class ticketSeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static ticketSeatSupervisor theInstance = new ticketSeatSupervisor();
   private Relation<ITicket,ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public ticketSeatSupervisor(){
      this.elements = new Relation<>("ticketSeat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static ticketSeatSupervisor getInstance(){return theInstance;}
   public ISeat getSeat(ITicket owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ITicket owner, ISeat target) throws PersistenceException{
      ISeat targetOld = this.getSeat(owner); ISeat targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITicket owner, ISeat target) {
      ISeat targetOld = null; ISeat targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITicket owner, ISeat targetOld, ISeat targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

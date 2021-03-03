/**--- Generated at Wed Mar 03 18:19:11 CET 2021 
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
public class rowToCategorySupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static rowToCategorySupervisor theInstance = new rowToCategorySupervisor();
   private Relation<IRoomRow,IRowCategory> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private rowToCategorySupervisor(){
      this.elements = new Relation<>("rowToCategory");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static rowToCategorySupervisor getInstance(){return theInstance;}
   public IRowCategory getCategory(IRoomRow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IRoomRow owner, IRowCategory target) throws PersistenceException{
      IRowCategory targetOld = this.getCategory(owner); IRowCategory targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IRoomRow owner, IRowCategory target) {
      IRowCategory targetOld = null; IRowCategory targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IRoomRow owner, IRowCategory targetOld, IRowCategory targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

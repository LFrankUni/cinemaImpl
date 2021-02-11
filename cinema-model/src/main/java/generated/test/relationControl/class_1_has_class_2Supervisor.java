/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.test.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.test.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class class_1_has_class_2Supervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static class_1_has_class_2Supervisor theInstance = new class_1_has_class_2Supervisor();
   private Relation<IClass_1,IClass_2> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public class_1_has_class_2Supervisor(){
      this.elements = new Relation<>("class_1_has_class_2");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static class_1_has_class_2Supervisor getInstance(){return theInstance;}
   public IClass_2 getC2(IClass_1 owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IClass_1 owner, IClass_2 target) throws PersistenceException{
      IClass_2 targetOld = this.getC2(owner); IClass_2 targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IClass_1 owner, IClass_2 target) {
      IClass_2 targetOld = null; IClass_2 targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IClass_1 owner, IClass_2 targetOld, IClass_2 targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

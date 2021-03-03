/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class roomesSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static roomesSupervisor theInstance = new roomesSupervisor();
   private Relation<ICinema,IRoom> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private roomesSupervisor(){
      this.elements = new Relation<>("roomes");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static roomesSupervisor getInstance(){return theInstance;}
   public Set<IRoom> getRoomes(ICinema owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(ICinema owner, IRoom target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinema owner, IRoom target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinema owner, IRoom target) throws PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(ICinema owner, IRoom target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

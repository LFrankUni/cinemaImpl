/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
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
public class rowsOfRoomSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static rowsOfRoomSupervisor theInstance = new rowsOfRoomSupervisor();
   private Relation<IRoom,IRoomRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private rowsOfRoomSupervisor(){
      this.elements = new Relation<>("rowsOfRoom");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static rowsOfRoomSupervisor getInstance(){return theInstance;}
   public Set<IRoomRow> getRows(IRoom owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(IRoom owner, IRoomRow target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IRoom owner, IRoomRow target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IRoom owner, IRoomRow target) throws PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(IRoom owner, IRoomRow target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Sun Mar 14 00:09:51 CET 2021 
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
public class movieShowsOfRoomSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static movieShowsOfRoomSupervisor theInstance = new movieShowsOfRoomSupervisor();
   private Relation<IRoom,IMovieShow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private movieShowsOfRoomSupervisor(){
      this.elements = new Relation<>("movieShowsOfRoom");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static movieShowsOfRoomSupervisor getInstance(){return theInstance;}
   public Set<IMovieShow> getMovieShows(IRoom owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(IRoom owner, IMovieShow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IRoom owner, IMovieShow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IRoom owner, IMovieShow target) throws ConstraintViolation, PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(IRoom owner, IMovieShow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public IRoom getRoom(IMovieShow target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

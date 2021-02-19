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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class movieShowsOfMovieSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static movieShowsOfMovieSupervisor theInstance = new movieShowsOfMovieSupervisor();
   private Relation<IMovieShow,IMovie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public movieShowsOfMovieSupervisor(){
      this.elements = new Relation<>("movieShowsOfMovie");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static movieShowsOfMovieSupervisor getInstance(){return theInstance;}
   public List<IMovie> getMovie(IMovieShow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IMovieShow owner, IMovie target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IMovieShow owner, IMovie target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IMovieShow owner, IMovie target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   public Set<IMovieShow> getShow(IMovie target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

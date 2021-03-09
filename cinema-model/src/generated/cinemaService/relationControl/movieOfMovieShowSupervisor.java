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
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class movieOfMovieShowSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static movieOfMovieShowSupervisor theInstance = new movieOfMovieShowSupervisor();
   private Relation<IMovieShow,IMovie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private movieOfMovieShowSupervisor(){
      this.elements = new Relation<>("movieOfMovieShow");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static movieOfMovieShowSupervisor getInstance(){return theInstance;}
   public IMovie getMovie(IMovieShow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IMovieShow owner, IMovie target) throws PersistenceException{
      IMovie targetOld = this.getMovie(owner); IMovie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IMovieShow owner, IMovie target) {
      IMovie targetOld = null; IMovie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IMovieShow owner, IMovie targetOld, IMovie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IMovieShow> getMovieShows(IMovie target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

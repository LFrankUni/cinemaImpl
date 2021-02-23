/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
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
   public Optional<IMovie> getMovie(IMovieShow owner){
      return (this.elements.getRelatedTargets(owner).size() == 0) ? Optional.empty() : Optional.of(this.elements.getRelatedTargets(owner).get(0));
   }
   public void set(IMovieShow owner, IMovie target) throws ConstraintViolation, PersistenceException{
      IMovie targetOld = this.getMovie(owner).isPresent() ? this.getMovie(owner).get() : null; IMovie targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IMovieShow owner, IMovie target) throws ConstraintViolation{
      IMovie targetOld = null; IMovie targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IMovieShow owner, IMovie targetOld, IMovie targetNew) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   public IMovieShow getMovieShow(IMovie target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
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
public class shownMovieSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static shownMovieSupervisor theInstance = new shownMovieSupervisor();
   private Relation<IMovieShow,IMovie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public shownMovieSupervisor(){
      this.elements = new Relation<>("shownMovie");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static shownMovieSupervisor getInstance(){return theInstance;}
   public IMovie getShownMovie(IMovieShow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IMovieShow owner, IMovie target) throws PersistenceException{
      IMovie targetOld = this.getShownMovie(owner); IMovie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IMovieShow owner, IMovie target) {
      IMovie targetOld = null; IMovie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IMovieShow owner, IMovie targetOld, IMovie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Sat Mar 13 11:01:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Movie;
import java.sql.ResultSet;
import generated.cinemaService.MovieShow;
import java.util.Set;
public class MovieProxy extends HasIncomeProxy implements IMovie{
   private Integer id;
   private Optional<Movie> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MovieProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MovieProxy(Movie theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Movie getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Movie";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovie)) return false;
      return ((IMovie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Movie load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("HasIncome", this.id);
         String title = rs.getString("title");
         String description = rs.getString("description");
         Integer minutes = rs.getInt("minutes");
         return Movie.createAlreadyPersistent(this, title, description, minutes);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getTitle() {
      return this.getTheObject().getTitle();
   }
   public void setTitle(String newTitle) throws PersistenceException{
      this.getTheObject().setTitle(newTitle);
   }
   public String getDescription() {
      return this.getTheObject().getDescription();
   }
   public void setDescription(String newDescription) throws PersistenceException{
      this.getTheObject().setDescription(newDescription);
   }
   public Integer getMinutes() {
      return this.getTheObject().getMinutes();
   }
   public void setMinutes(Integer newMinutes) throws PersistenceException{
      this.getTheObject().setMinutes(newMinutes);
   }
   public Set<MovieShow> getMovieShows() throws PersistenceException{
      return this.getTheObject().getMovieShows();
   }
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Movie;
import java.sql.ResultSet;
public class MovieProxy implements IMovie{
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
   public Movie getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Movie";}
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
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Movie", this.id);
         String titel = rs.getString("titel");
         String description = rs.getString("description");
         Integer minutes = rs.getInt("minutes");
         return Movie.createAlreadyPersistent(id, titel, description, minutes);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getTitel() {
      return this.getTheObject().getTitel();
   }
   public void setTitel(String newTitel) throws PersistenceException{
      this.getTheObject().setTitel(newTitel);
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
}

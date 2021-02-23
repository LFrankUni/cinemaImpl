/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MovieProxy;
import generated.cinemaService.proxies.IMovie;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import exceptions.ConstraintViolation;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Movie extends HasIncome implements java.io.Serializable, IMovie
{
   //30 ===== GENERATED:      Attribute Section ======
   private String title;
   private String description;
   private Integer minutes;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Movie(Integer id, String title, String description, Integer minutes, MovieShow movieShow, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, objectOnly);
      this.title = title;
      this.description = description;
      this.minutes = minutes;
      if(objectOnly) return;
      if(movieShow.getMovie().isPresent()) throw new ConstraintViolation("Object cannot be instantiated, because " + movieShow+ " is full");
      try{movieOfMovieShowSupervisor.getInstance().set(movieShow,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Movie createAlreadyPersistent(MovieProxy proxy, String title, String description, Integer minutes, MovieShow movieShow)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Movie(proxy.getId(), title, description, minutes, movieShow, true);
   }
   public static Movie createFresh(String title, String description, Integer minutes, MovieShow movieShow)throws ConstraintViolation, PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, title, description, minutes", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Movie").toString() + ", " + "'" + title + "'" + ", " + "'" + description + "'" + ", " + minutes.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Movie me = new Movie(id, title, description, minutes, movieShow, false);
      CinemaService.getInstance().addMovieProxy(new MovieProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Movie getTheObject(){
      return this;
   }
   public String getTitle() {
      return this.title;
   }
   public void setTitle(String newTitle) throws PersistenceException{
      this.title = newTitle;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "title", "'" + newTitle + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getDescription() {
      return this.description;
   }
   public void setDescription(String newDescription) throws PersistenceException{
      this.description = newDescription;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "description", "'" + newDescription + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getMinutes() {
      return this.minutes;
   }
   public void setMinutes(Integer newMinutes) throws PersistenceException{
      this.minutes = newMinutes;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "minutes", newMinutes.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return movieOfMovieShowSupervisor.getInstance().getMovieShow(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Returns all movieshows this movie is played in between from and to (inclusive).
 */
   public Collection<MovieShow> getAllMovieShows(String from, String to)throws ModelException{
      // TODO: Implement Operation getAllMovieShows
      return null;
   }
/**
 * Returns the income that the elements currently has.
 */
   public Integer income()throws ModelException{
      // TODO: Implement Operation income
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

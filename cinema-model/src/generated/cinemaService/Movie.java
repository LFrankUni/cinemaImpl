/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IMovie;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaService.proxies.IMovieShow;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Movie extends HasIncome implements java.io.Serializable, IMovie
{
   //30 ===== GENERATED:      Attribute Section ======
   private String titel;
   private String description;
   private Integer minutes;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Movie(Integer id, String titel, String description, Integer minutes, boolean objectOnly)
   {
      super(id, objectOnly);
      this.titel = titel;
      this.description = description;
      this.minutes = minutes;
      if(objectOnly) return;
   }
   public static Movie createAlreadyPersistent(Integer id, String titel, String description, Integer minutes){
      return new Movie(id, titel, description, minutes, true);
   }
   public static Movie createFresh(String titel, String description, Integer minutes)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, titel, description, minutes", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Movie").toString() + ", " + "'" + titel + "'" + ", " + "'" + description + "'" + ", " + minutes.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Movie me = new Movie(id, titel, description, minutes, false);
      generated.cinemaService.proxies.MovieProxy p = new generated.cinemaService.proxies.MovieProxy(me);
      CinemaService.getInstance().addMovieProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Movie getTheObject(){
      return this;
   }
   public String getTitel() {
      return this.titel;
   }
   public void setTitel(String newTitel) throws PersistenceException{
      this.titel = newTitel;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "titel", "'" + newTitel + "'", this.getId());
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
   public Set<MovieShow> getShow() throws PersistenceException{
      Set<MovieShow> result = new HashSet<>();
      for (IMovieShow i : movieShowsOfMovieSupervisor.getInstance().getShow(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Calculates an income
 */
   public Integer income(){
      // TODO: Implement Operation income
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.IMovie;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Movie extends Observable implements java.io.Serializable, IMovie
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String titel;
   private String description;
   private Integer minutes;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Movie(Integer id, String titel, String description, Integer minutes, boolean objectOnly)
   {
      super();
      this.setId(id);
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
         dmlExecuter.insertInto("Movie", "id, typeKey, titel, description, minutes", 
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
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovie)) return false;
      return ((IMovie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getTitel() {
      return this.titel;
   }
   public void setTitel(String newTitel) throws PersistenceException{
      this.titel = newTitel;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Movie", "titel", "'" + newTitel + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getDescription() {
      return this.description;
   }
   public void setDescription(String newDescription) throws PersistenceException{
      this.description = newDescription;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Movie", "description", "'" + newDescription + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getMinutes() {
      return this.minutes;
   }
   public void setMinutes(Integer newMinutes) throws PersistenceException{
      this.minutes = newMinutes;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Movie", "minutes", newMinutes.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

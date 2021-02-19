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
import generated.cinemaService.proxies.ICinema;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinema extends HasIncome implements java.io.Serializable, ICinema
{
   //30 ===== GENERATED:      Attribute Section ======
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinema(Integer id, String name, boolean objectOnly)
   throws PersistenceException{
      super(id, objectOnly);
      this.name = name;
      if(objectOnly) return;
   }
   public static Cinema createAlreadyPersistent(Integer id, String name)throws PersistenceException{
      return new Cinema(id, name, true);
   }
   public static Cinema createFresh(String name)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, name", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Cinema").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Cinema me = new Cinema(id, name, false);
      generated.cinemaService.proxies.CinemaProxy p = new generated.cinemaService.proxies.CinemaProxy(me);
      CinemaService.getInstance().addCinemaProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Cinema getTheObject(){
      return this;
   }
   public Set<Room> getRoomes() throws PersistenceException{
      Set<Room> result = new HashSet<>();
      for (IRoom i : roomesSupervisor.getInstance().getRoomes(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToRoomes(Room arg) throws ConstraintViolation, PersistenceException{
      roomesSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromRoomes(Room arg) throws ConstraintViolation, PersistenceException{
      return roomesSupervisor.getInstance().remove(this, arg);
   }
   public Set<Movie> getMovies() throws PersistenceException{
      Set<Movie> result = new HashSet<>();
      for (IMovie i : moviesSupervisor.getInstance().getMovies(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMovies(Movie arg) throws PersistenceException{
      moviesSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMovies(Movie arg) throws PersistenceException{
      return moviesSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
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

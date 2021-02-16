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
import generated.cinemaService.proxies.IRoom;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Room extends Observable implements java.io.Serializable, IRoom
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private Boolean open;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Room(Integer id, String name, Boolean open, Cinema cinema, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      this.name = name;
      this.open = open;
      if(objectOnly) return;
      try{roomesSupervisor.getInstance().add(cinema,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Room createAlreadyPersistent(Integer id, String name, Boolean open, Cinema cinema)throws PersistenceException{
      return new Room(id, name, open, cinema, true);
   }
   public static Room createFresh(String name, Boolean open, Cinema cinema)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Room", "id, typeKey, name, open", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Room").toString() + ", " + "'" + name + "'" + ", " + open.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Room me = new Room(id, name, open, cinema, false);
      generated.cinemaService.proxies.RoomProxy p = new generated.cinemaService.proxies.RoomProxy(me);
      CinemaService.getInstance().addRoomProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Room getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoom)) return false;
      return ((IRoom)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<MovieShow> getShows() throws PersistenceException{
      Set<MovieShow> result = new HashSet<>();
      for (IMovieShow i : showsSupervisor.getInstance().getShows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      showsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      return showsSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Room", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getOpen() {
      return this.open;
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.open = newOpen;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Room", "open", newOpen.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Cinema getCinema() throws PersistenceException{
      return roomesSupervisor.getInstance().getCinema(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Tries to schedule a new show. Throwns an excepion if start does not fit in existing schedule.
 */
   public void scheduleShow(MovieShow show)throws ScheduleError{
      // TODO: Implement Operation scheduleShow
      return;
   }
//90 ===== GENERATED: End of Your Operations ======
}

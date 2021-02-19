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
import generated.cinemaService.proxies.IRoom;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Room extends HasIncome implements java.io.Serializable, IRoom
{
   //30 ===== GENERATED:      Attribute Section ======
   private String roomName;
   private Boolean open;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Room(Integer id, String roomName, Boolean open, Cinema cinema, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, objectOnly);
      this.roomName = roomName;
      this.open = open;
      if(objectOnly) return;
      try{roomesSupervisor.getInstance().add(cinema,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Room createAlreadyPersistent(Integer id, String roomName, Boolean open, Cinema cinema)throws PersistenceException, ConstraintViolation{
      return new Room(id, roomName, open, cinema, true);
   }
   public static Room createFresh(String roomName, Boolean open, Cinema cinema)throws PersistenceException, ConstraintViolation{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, roomName, open", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Room").toString() + ", " + "'" + roomName + "'" + ", " + open.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Room me = new Room(id, roomName, open, cinema, false);
      generated.cinemaService.proxies.RoomProxy p = new generated.cinemaService.proxies.RoomProxy(me);
      CinemaService.getInstance().addRoomProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Room getTheObject(){
      return this;
   }
   public Set<MovieShow> getMovieShows() throws PersistenceException{
      Set<MovieShow> result = new HashSet<>();
      for (IMovieShow i : movieShowsOfRoomSupervisor.getInstance().getMovieShows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      movieShowsOfRoomSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      return movieShowsOfRoomSupervisor.getInstance().remove(this, arg);
   }
   public Set<AbstractRow> getRows() throws PersistenceException{
      Set<AbstractRow> result = new HashSet<>();
      for (IAbstractRow i : rowsOfRoomSupervisor.getInstance().getRows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToRows(AbstractRow arg) throws ConstraintViolation, PersistenceException{
      rowsOfRoomSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromRows(AbstractRow arg) throws ConstraintViolation, PersistenceException{
      return rowsOfRoomSupervisor.getInstance().remove(this, arg);
   }
   public String getRoomName() {
      return this.roomName;
   }
   public void setRoomName(String newRoomName) throws PersistenceException{
      this.roomName = newRoomName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "roomName", "'" + newRoomName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getOpen() {
      return this.open;
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.open = newOpen;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "open", newOpen.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Cinema getCinema() throws PersistenceException{
      return roomesSupervisor.getInstance().getCinema(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Opens the room => Movie Shows are allowed to be scheduled
 */
   public void open(){
      // TODO: Implement Operation open
      return;
   }
/**
 * Tries to schedule a new show. Throwns an excepion if start does not fit in existing schedule.
 */
   public void scheduleShow(MovieShow show)throws ScheduleError{
      // TODO: Implement Operation scheduleShow
      return;
   }
/**
 * Opens the room => Movie Shows are not allowed to be scheduled
 */
   public void close(){
      // TODO: Implement Operation close
      return;
   }
/**
 * Calculates an income
 */
   public Integer income(){
      // TODO: Implement Operation income
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

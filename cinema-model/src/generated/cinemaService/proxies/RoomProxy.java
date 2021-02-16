/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Room;
import java.sql.ResultSet;
import generated.cinemaService.MovieShow;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Cinema;
import generated.cinemaService.relationControl.roomesSupervisor;
import generated.cinemaService.ScheduleError;
public class RoomProxy implements IRoom{
   private Integer id;
   private Optional<Room> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public RoomProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public RoomProxy(Room theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Room getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Room";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoom)) return false;
      return ((IRoom)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Room load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Room", this.id);
         String name = rs.getString("name");
         Boolean open = rs.getBoolean("open");
         Cinema cinema = roomesSupervisor.getInstance().getCinema(this).getTheObject();
         return Room.createAlreadyPersistent(id, name, open, cinema);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<MovieShow> getShows() throws PersistenceException{
      return this.getTheObject().getShows();
   }
   public void addToShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToShows(arg);
   }
   public boolean removeFromShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromShows(arg);
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public Boolean getOpen() {
      return this.getTheObject().getOpen();
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.getTheObject().setOpen(newOpen);
   }
   public Cinema getCinema() throws PersistenceException{
      return this.getTheObject().getCinema();
   }
   public void scheduleShow(MovieShow show)throws ScheduleError{
      this.getTheObject().scheduleShow(show);
   }
}

/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
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
import generated.cinemaService.RoomRow;
import generated.cinemaService.Cinema;
import generated.cinemaService.relationControl.roomesSupervisor;
public class RoomProxy extends HasIncomeProxy implements IRoom{
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
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Room getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Room";}
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
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("HasIncome", this.id);
         String nameOfRoom = rs.getString("nameOfRoom");
         Boolean open = rs.getBoolean("open");
         Cinema cinema = roomesSupervisor.getInstance().getCinema(this).getTheObject();
         return Room.createAlreadyPersistent(this, nameOfRoom, open, cinema);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<MovieShow> getMovieShows() throws PersistenceException{
      return this.getTheObject().getMovieShows();
   }
   public void addToMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToMovieShows(arg);
   }
   public boolean removeFromMovieShows(MovieShow arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromMovieShows(arg);
   }
   public Set<RoomRow> getRows() throws PersistenceException{
      return this.getTheObject().getRows();
   }
   public void addToRows(RoomRow arg) throws PersistenceException{
      this.getTheObject().addToRows(arg);
   }
   public boolean removeFromRows(RoomRow arg) throws PersistenceException{
      return this.getTheObject().removeFromRows(arg);
   }
   public String getNameOfRoom() {
      return this.getTheObject().getNameOfRoom();
   }
   public void setNameOfRoom(String newNameOfRoom) throws PersistenceException{
      this.getTheObject().setNameOfRoom(newNameOfRoom);
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
}

/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
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
import generated.cinemaService.AbstractRow;
import generated.cinemaService.Movie;
import generated.cinemaService.ModelException;
import java.util.Collection;
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
         return Room.createAlreadyPersistent(this, nameOfRoom, open);
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
   public Set<AbstractRow> getRows() throws PersistenceException{
      return this.getTheObject().getRows();
   }
   public void addToRows(AbstractRow arg) throws PersistenceException{
      this.getTheObject().addToRows(arg);
   }
   public boolean removeFromRows(AbstractRow arg) throws PersistenceException{
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
   public MovieShow scheduleMovieShow(Movie movie, String start, String end, Boolean threeDimensional, Integer price)throws ModelException{
      return this.getTheObject().scheduleMovieShow(movie, start, end, threeDimensional, price);
   }
   public void addRow(AbstractRow row)throws ModelException{
      this.getTheObject().addRow(row);
   }
   public void close()throws ModelException{
      this.getTheObject().close();
   }
   public void open()throws ModelException{
      this.getTheObject().open();
   }
   public Collection<Room> getAllRows()throws ModelException{
      return this.getTheObject().getAllRows();
   }
   public Integer income()throws ModelException{
      return this.getTheObject().income();
   }
}

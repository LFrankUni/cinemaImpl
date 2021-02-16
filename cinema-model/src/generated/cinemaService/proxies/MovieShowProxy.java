/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.MovieShow;
import java.sql.ResultSet;
import generated.cinemaService.Movie;
import generated.cinemaService.relationControl.shownMovieSupervisor;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
import generated.cinemaService.relationControl.showsSupervisor;
import generated.cinemaService.User;
import generated.cinemaService.SeatAlreadyBookedException;
import generated.cinemaService.SeatAlreadyReservedException;
public class MovieShowProxy implements IMovieShow{
   private Integer id;
   private Optional<MovieShow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MovieShowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MovieShowProxy(MovieShow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public MovieShow getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "MovieShow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovieShow)) return false;
      return ((IMovieShow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private MovieShow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("MovieShow", this.id);
         Movie shownMovie = shownMovieSupervisor.getInstance().getShownMovie(this).getTheObject();
         String start = rs.getString("start");
         String end = rs.getString("end");
         Integer price = rs.getInt("price");
         Room room = showsSupervisor.getInstance().getRoom(this).getTheObject();
         return MovieShow.createAlreadyPersistent(id, shownMovie, start, end, price, room);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Movie getShownMovie() throws PersistenceException{
      return this.getTheObject().getShownMovie();
   }
   public void setShownMovie(Movie newShownMovie)throws PersistenceException{
      this.getTheObject().setShownMovie(newShownMovie);
   }
   public Set<Ticket> getTickets() throws PersistenceException{
      return this.getTheObject().getTickets();
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToTickets(arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromTickets(arg);
   }
   public String getStart() {
      return this.getTheObject().getStart();
   }
   public void setStart(String newStart) throws PersistenceException{
      this.getTheObject().setStart(newStart);
   }
   public String getEnd() {
      return this.getTheObject().getEnd();
   }
   public void setEnd(String newEnd) throws PersistenceException{
      this.getTheObject().setEnd(newEnd);
   }
   public Integer getPrice() {
      return this.getTheObject().getPrice();
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.getTheObject().setPrice(newPrice);
   }
   public Room getRoom() throws PersistenceException{
      return this.getTheObject().getRoom();
   }
   public Ticket book(Integer seat, Integer row, User by)throws SeatAlreadyBookedException{
      return this.getTheObject().book(seat, row, by);
   }
   public Ticket reserve(Integer seat, Integer row, User by)throws SeatAlreadyReservedException{
      return this.getTheObject().reserve(seat, row, by);
   }
}

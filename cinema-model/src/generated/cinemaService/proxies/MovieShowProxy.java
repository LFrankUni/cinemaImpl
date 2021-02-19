/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.MovieShow;
import java.sql.ResultSet;
import generated.cinemaService.Movie;
import java.util.List;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
import generated.cinemaService.relationControl.movieShowsOfRoomSupervisor;
import generated.cinemaService.Seat;
import generated.cinemaService.User;
import generated.cinemaService.SeatAlreadyReservedException;
public class MovieShowProxy extends HasIncomeProxy implements IMovieShow{
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
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("HasIncome", this.id);
         String start = rs.getString("start");
         String end = rs.getString("end");
         Integer price = rs.getInt("price");
         Boolean threeD = rs.getBoolean("threeD");
         Room room = movieShowsOfRoomSupervisor.getInstance().getRoom(this).getTheObject();
         return MovieShow.createAlreadyPersistent(id, start, end, price, threeD, room);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Movie> getMovie() throws PersistenceException{
      return this.getTheObject().getMovie();
   }
   public void addToMovie(Movie arg) throws PersistenceException{
      this.getTheObject().addToMovie(arg);
   }
   public boolean removeFromMovie(Movie arg) throws PersistenceException{
      return this.getTheObject().removeFromMovie(arg);
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
   public Boolean getThreeD() {
      return this.getTheObject().getThreeD();
   }
   public void setThreeD(Boolean newThreeD) throws PersistenceException{
      this.getTheObject().setThreeD(newThreeD);
   }
   public Room getRoom() throws PersistenceException{
      return this.getTheObject().getRoom();
   }
   public Ticket reserve(Seat seat, User by)throws SeatAlreadyReservedException{
      return this.getTheObject().reserve(seat, by);
   }
   public Integer income(){
      return this.getTheObject().income();
   }
}

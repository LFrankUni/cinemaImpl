/**--- Generated at Sun Mar 14 22:23:08 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.MovieShow;
import java.sql.ResultSet;
import generated.cinemaService.Movie;
import generated.cinemaService.relationControl.movieOfMovieShowSupervisor;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import generated.cinemaService.Room;
import generated.cinemaService.relationControl.movieShowsOfRoomSupervisor;
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
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public MovieShow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "MovieShow";}
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
         Movie movie = movieOfMovieShowSupervisor.getInstance().getMovie(this).getTheObject();
         String start = rs.getString("start");
         String end = rs.getString("end");
         Boolean threeDimensional = rs.getBoolean("threeDimensional");
         Integer priceInCent = rs.getInt("priceInCent");
         Room room = movieShowsOfRoomSupervisor.getInstance().getRoom(this).getTheObject();
         return MovieShow.createAlreadyPersistent(this, movie, start, end, threeDimensional, priceInCent, room);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Movie getMovie() throws PersistenceException{
      return this.getTheObject().getMovie();
   }
   public void setMovie(Movie newMovie)throws PersistenceException{
      this.getTheObject().setMovie(newMovie);
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
   public Boolean getThreeDimensional() {
      return this.getTheObject().getThreeDimensional();
   }
   public void setThreeDimensional(Boolean newThreeDimensional) throws PersistenceException{
      this.getTheObject().setThreeDimensional(newThreeDimensional);
   }
   public Integer getPriceInCent() {
      return this.getTheObject().getPriceInCent();
   }
   public void setPriceInCent(Integer newPriceInCent) throws PersistenceException{
      this.getTheObject().setPriceInCent(newPriceInCent);
   }
   public Room getRoom() throws PersistenceException{
      return this.getTheObject().getRoom();
   }
}

/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Cinema;
import java.sql.ResultSet;
import generated.cinemaService.Movie;
import java.util.Set;
import generated.cinemaService.Room;
import exceptions.ConstraintViolation;
public class CinemaProxy extends HasIncomeProxy implements ICinema{
   private Integer id;
   private Optional<Cinema> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public CinemaProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public CinemaProxy(Cinema theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Cinema getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Cinema";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinema)) return false;
      return ((ICinema)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Cinema load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("HasIncome", this.id);
         String nameOfCinema = rs.getString("nameOfCinema");
         return Cinema.createAlreadyPersistent(this, nameOfCinema);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Movie> getMovies() throws PersistenceException{
      return this.getTheObject().getMovies();
   }
   public void addToMovies(Movie arg) throws PersistenceException{
      this.getTheObject().addToMovies(arg);
   }
   public boolean removeFromMovies(Movie arg) throws PersistenceException{
      return this.getTheObject().removeFromMovies(arg);
   }
   public Set<Room> getRoomes() throws PersistenceException{
      return this.getTheObject().getRoomes();
   }
   public void addToRoomes(Room arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToRoomes(arg);
   }
   public boolean removeFromRoomes(Room arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromRoomes(arg);
   }
   public String getNameOfCinema() {
      return this.getTheObject().getNameOfCinema();
   }
   public void setNameOfCinema(String newNameOfCinema) throws PersistenceException{
      this.getTheObject().setNameOfCinema(newNameOfCinema);
   }
}

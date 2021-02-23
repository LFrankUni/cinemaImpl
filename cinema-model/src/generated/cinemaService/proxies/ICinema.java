/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Cinema;
import generated.cinemaService.Room;
import java.util.Set;
import generated.cinemaService.Movie;
import java.util.Collection;
import generated.cinemaService.ModelException;
import generated.cinemaService.MovieShow;
public interface ICinema extends IHasIncome{
   public Cinema getTheObject();
   public Integer getId();
   public Set<Room> getRoomes() throws PersistenceException;
   public void addToRoomes(Room arg) throws PersistenceException;
   public boolean removeFromRoomes(Room arg) throws PersistenceException;
   public Set<Movie> getMovies() throws PersistenceException;
   public void addToMovies(Movie arg) throws PersistenceException;
   public boolean removeFromMovies(Movie arg) throws PersistenceException;
   public String getNameOfCinema() ;
   public void setNameOfCinema(String newNameOfCinema) throws PersistenceException;
   public Collection<Room> getAllRooms()throws ModelException;
   public Collection<MovieShow> getScheduledMovieShows(String from, String to)throws ModelException;
   public Collection<Movie> getAllMovies()throws ModelException;
   public void addMovie(Movie movie)throws ModelException;
   public Integer income()throws ModelException;
}

/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MovieProxy;
import generated.cinemaService.proxies.IMovie;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import utilities.TimeConverter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Iterator;

import generated.cinemaService.proxies.IMovieShow;
import exceptions.ConstraintViolation;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Movie extends HasIncome implements java.io.Serializable, IMovie
{
   //30 ===== GENERATED:      Attribute Section ======
   private String title;
   private String description;
   private Integer minutes;
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private Movie(Integer id, String title, String description, Integer minutes, boolean objectOnly)
   {
      super(id, objectOnly);
      this.title = title;
      this.description = description;
      this.minutes = minutes;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Movie createAlreadyPersistent(MovieProxy proxy, String title, String description, Integer minutes){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Movie(proxy.getId(), title, description, minutes, true);
   }
   public static Movie createFresh(String title, String description, Integer minutes)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("HasIncome", "id, typeKey, title, description, minutes", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Movie").toString() + ", " + "'" + title + "'" + ", " + "'" + description + "'" + ", " + minutes.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Movie me = new Movie(id, title, description, minutes, false);
      CinemaService.getInstance().addMovieProxy(new MovieProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public Movie getTheObject(){
      return this;
   }
   public String getTitle() {
      return this.title;
   }
   public void setTitle(String newTitle) throws PersistenceException{
      this.title = newTitle;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "title", "'" + newTitle + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getDescription() {
      return this.description;
   }
   public void setDescription(String newDescription) throws PersistenceException{
      this.description = newDescription;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "description", "'" + newDescription + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Integer getMinutes() {
      return this.minutes;
   }
   public void setMinutes(Integer newMinutes) throws PersistenceException{
      this.minutes = newMinutes;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("HasIncome", "minutes", newMinutes.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<MovieShow> getMovieShows() throws PersistenceException{
      Set<MovieShow> result = new HashSet<>();
      for (IMovieShow i : movieOfMovieShowSupervisor.getInstance().getMovieShows(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============

	/**
	 * Returns the income that the elements currently has.
	 */
	public Integer income() throws ModelException {
		Integer sum = 0;
		for (Iterator<MovieShow> iterator = this.getMovieShows().iterator(); iterator.hasNext();) {
			sum += iterator.next().income();
		}
		return sum;
	}

	/**
	 * Returns all movieshows where start of show is in between from and to.
	 */
	public Collection<MovieShow> getAllMovieShows(String from, String to, Cinema cinema) throws ModelException {
		final Instant _from = TimeConverter.toInstant(from).minus(1,ChronoUnit.MILLIS);
		final Instant _to = TimeConverter.toInstant(to).plus(1,ChronoUnit.MILLIS);
		return this.getMovieShows().stream().filter(show -> {
			try {
				return show.getRoom().getCinema().equals(cinema);
			} catch (PersistenceException e) {
			}
			return false;
		}).filter(show -> TimeConverter.toInstant(show.getStart()).isAfter(_from)
				&& TimeConverter.toInstant(show.getStart()).isBefore(_to)).collect(Collectors.toSet());
	}
//90 ===== GENERATED: End of Your Operations ======
}

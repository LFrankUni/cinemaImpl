/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Movie_constructor_Command extends ServiceCommand<Movie>{
   private static final long serialVersionUID = -1826023746L;
   private String  title;
   private String  description;
   private Integer  minutes;
   private MovieShow  movieShow;
   public Movie_constructor_Command(String  title, String  description, Integer  minutes, MovieShow  movieShow){
      super();
      this.title = title;
      this.description = description;
      this.minutes = minutes;
      this.movieShow = movieShow;
   }
   public void execute(){
      try{this.result = Movie.createFresh(title, description, minutes, movieShow);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

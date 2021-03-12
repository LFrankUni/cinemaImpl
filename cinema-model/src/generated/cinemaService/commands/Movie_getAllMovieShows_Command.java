/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Movie_getAllMovieShows_Command extends ObjectCommand<Movie, Collection<MovieShow>>{
   private static final long serialVersionUID = -1813091596L;
   private String from;
   private String to;
   private Cinema cinema;
   public Movie_getAllMovieShows_Command(Movie receiver, String from, String to, Cinema cinema){
      super(receiver);
      this.from = from;
      this.to = to;
      this.cinema = cinema;
   }
   public void execute(){
      try{this.result = this.receiver.getAllMovieShows(from, to, cinema);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

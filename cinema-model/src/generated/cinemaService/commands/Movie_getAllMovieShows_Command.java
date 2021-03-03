/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Movie_getAllMovieShows_Command extends ObjectCommand<Movie, Collection<MovieShow>>{
   private static final long serialVersionUID = -856581049L;
   private String from;
   private String to;
   public Movie_getAllMovieShows_Command(Movie receiver, String from, String to){
      super(receiver);
      this.from = from;
      this.to = to;
   }
   public void execute(){
      try{this.result = this.receiver.getAllMovieShows(from, to);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

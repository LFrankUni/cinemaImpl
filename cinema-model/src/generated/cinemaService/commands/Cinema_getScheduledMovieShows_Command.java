/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Cinema_getScheduledMovieShows_Command extends ObjectCommand<Cinema, Collection<MovieShow>>{
   private static final long serialVersionUID = -568948877L;
   private String from;
   private String to;
   public Cinema_getScheduledMovieShows_Command(Cinema receiver, String from, String to){
      super(receiver);
      this.from = from;
      this.to = to;
   }
   public void execute(){
      try{this.result = this.receiver.getScheduledMovieShows(from, to);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

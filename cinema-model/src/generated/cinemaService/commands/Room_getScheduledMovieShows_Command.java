/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Room_getScheduledMovieShows_Command extends ObjectCommand<Room, Collection<MovieShow>>{
   private static final long serialVersionUID = 823674937L;
   private String from;
   private String to;
   public Room_getScheduledMovieShows_Command(Room receiver, String from, String to){
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

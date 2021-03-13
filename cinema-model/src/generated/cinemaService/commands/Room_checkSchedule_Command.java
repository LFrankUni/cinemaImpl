/**--- Generated at Sat Mar 13 11:01:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Room_checkSchedule_Command extends ObjectCommand<Room, Collection<MovieShow>>{
   private static final long serialVersionUID = 2012015298L;
   private Movie movie;
   private String start;
   private Integer days;
   public Room_checkSchedule_Command(Room receiver, Movie movie, String start, Integer days){
      super(receiver);
      this.movie = movie;
      this.start = start;
      this.days = days;
   }
   public void execute(){
      try{this.result = this.receiver.checkSchedule(movie, start, days);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

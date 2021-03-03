/**--- Generated at Wed Mar 03 18:19:11 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_scheduleMovieShow_Command extends ObjectCommand<Room, MovieShow>{
   private static final long serialVersionUID = -67277490L;
   private Movie movie;
   private String start;
   private String end;
   private Boolean threeDimensional;
   private Integer price;
   public Room_scheduleMovieShow_Command(Room receiver, Movie movie, String start, String end, Boolean threeDimensional, Integer price){
      super(receiver);
      this.movie = movie;
      this.start = start;
      this.end = end;
      this.threeDimensional = threeDimensional;
      this.price = price;
   }
   public void execute(){
      try{this.result = this.receiver.scheduleMovieShow(movie, start, end, threeDimensional, price);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

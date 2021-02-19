/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_reserve_Command extends ObjectCommand<MovieShow, Ticket>{
   private static final long serialVersionUID = -1837128293L;
   private Seat seat;
   private User by;
   public MovieShow_reserve_Command(MovieShow receiver, Seat seat, User by){
      super(receiver);
      this.seat = seat;
      this.by = by;
   }
   public void execute(){
      try{this.result = this.receiver.reserve(seat, by);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

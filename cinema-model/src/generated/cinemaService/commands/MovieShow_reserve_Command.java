/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_reserve_Command extends ObjectCommand<MovieShow, Ticket>{
   private static final long serialVersionUID = -1968755690L;
   private Integer seat;
   private Integer row;
   private User by;
   public MovieShow_reserve_Command(MovieShow receiver, Integer seat, Integer row, User by){
      super(receiver);
      this.seat = seat;
      this.row = row;
      this.by = by;
   }
   public void execute(){
      try{this.result = this.receiver.reserve(seat, row, by);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

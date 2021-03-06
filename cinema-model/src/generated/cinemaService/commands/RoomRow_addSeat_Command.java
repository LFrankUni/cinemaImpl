/**--- Generated at Sat Mar 06 15:37:57 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RoomRow_addSeat_Command extends ObjectCommand<RoomRow, Seat>{
   private static final long serialVersionUID = -2129154883L;
   private Seat seat;
   public RoomRow_addSeat_Command(RoomRow receiver, Seat seat){
      super(receiver);
      this.seat = seat;
   }
   public void execute(){
      try{this.result = this.receiver.addSeat(seat);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RoomRow_addSeat_Command extends ObjectCommand<RoomRow, Void>{
   private static final long serialVersionUID = 656719625L;
   private Seat seat;
   public RoomRow_addSeat_Command(RoomRow receiver, Seat seat){
      super(receiver);
      this.seat = seat;
   }
   public void execute(){
      try{this.receiver.addSeat(seat);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

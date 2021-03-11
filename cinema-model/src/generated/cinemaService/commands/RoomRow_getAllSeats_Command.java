/**--- Generated at Thu Mar 11 18:42:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class RoomRow_getAllSeats_Command extends ObjectCommand<RoomRow, Collection<Seat>>{
   private static final long serialVersionUID = -1065130171L;
   public RoomRow_getAllSeats_Command(RoomRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllSeats();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Tue Mar 09 10:12:33 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class RoomRow_addSeats_Command extends ObjectCommand<RoomRow, Collection<Seat>>{
   private static final long serialVersionUID = 1621701308L;
   private Integer number;
   public RoomRow_addSeats_Command(RoomRow receiver, Integer number){
      super(receiver);
      this.number = number;
   }
   public void execute(){
      try{this.result = this.receiver.addSeats(number);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

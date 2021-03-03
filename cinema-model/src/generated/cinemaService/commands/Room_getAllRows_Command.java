/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Room_getAllRows_Command extends ObjectCommand<Room, Collection<RoomRow>>{
   private static final long serialVersionUID = -1895729526L;
   public Room_getAllRows_Command(Room receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllRows();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Room_getAllRows_Command extends ObjectCommand<Room, Collection<Room>>{
   private static final long serialVersionUID = 329702068L;
   public Room_getAllRows_Command(Room receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllRows();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

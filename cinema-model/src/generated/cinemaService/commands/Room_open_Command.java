/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_open_Command extends ObjectCommand<Room, Void>{
   private static final long serialVersionUID = 1048616560L;
   public Room_open_Command(Room receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.open();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

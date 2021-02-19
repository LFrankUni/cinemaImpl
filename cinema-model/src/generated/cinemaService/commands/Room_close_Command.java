/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_close_Command extends ObjectCommand<Room, Void>{
   private static final long serialVersionUID = 1700397172L;
   public Room_close_Command(Room receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.close();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

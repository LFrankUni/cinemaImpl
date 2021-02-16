/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_scheduleShow_Command extends ObjectCommand<Room, Void>{
   private static final long serialVersionUID = -328677953L;
   private MovieShow show;
   public Room_scheduleShow_Command(Room receiver, MovieShow show){
      super(receiver);
      this.show = show;
   }
   public void execute(){
      try{this.receiver.scheduleShow(show);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

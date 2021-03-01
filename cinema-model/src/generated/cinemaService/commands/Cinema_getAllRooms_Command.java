/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Cinema_getAllRooms_Command extends ObjectCommand<Cinema, Collection<Room>>{
   private static final long serialVersionUID = -262374056L;
   public Cinema_getAllRooms_Command(Cinema receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllRooms();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Cinema_getAllRooms_Command extends ObjectCommand<Cinema, Collection<Room>>{
   private static final long serialVersionUID = -821428686L;
   public Cinema_getAllRooms_Command(Cinema receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllRooms();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Sat Mar 06 15:37:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Cinema_addRoom_Command extends ObjectCommand<Cinema, Room>{
   private static final long serialVersionUID = 2000992047L;
   private String name;
   public Cinema_addRoom_Command(Cinema receiver, String name){
      super(receiver);
      this.name = name;
   }
   public void execute(){
      try{this.result = this.receiver.addRoom(name);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

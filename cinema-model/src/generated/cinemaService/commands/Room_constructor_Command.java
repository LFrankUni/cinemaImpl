/**--- Generated at Wed Mar 03 19:05:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_constructor_Command extends ServiceCommand<Room>{
   private static final long serialVersionUID = 1612302488L;
   private String  nameOfRoom;
   private Boolean  open;
   public Room_constructor_Command(String  nameOfRoom, Boolean  open){
      super();
      this.nameOfRoom = nameOfRoom;
      this.open = open;
   }
   public void execute(){
      try{this.result = Room.createFresh(nameOfRoom, open);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

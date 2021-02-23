/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_constructor_Command extends ServiceCommand<Room>{
   private static final long serialVersionUID = 325548423L;
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

/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_constructor_Command extends ServiceCommand<Room>{
   private static final long serialVersionUID = -1480372675L;
   private String  roomName;
   private Boolean  open;
   private Cinema  cinema;
   public Room_constructor_Command(String  roomName, Boolean  open, Cinema  cinema){
      super();
      this.roomName = roomName;
      this.open = open;
      this.cinema = cinema;
   }
   public void execute(){
      try{this.result = Room.createFresh(roomName, open, cinema);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

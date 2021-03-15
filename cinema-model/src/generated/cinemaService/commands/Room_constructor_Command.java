/**--- Generated at Sun Mar 14 22:23:08 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_constructor_Command extends ServiceCommand<Room>{
   private static final long serialVersionUID = 1793711558L;
   private String  nameOfRoom;
   private Boolean  open;
   private Cinema  cinema;
   public Room_constructor_Command(String  nameOfRoom, Boolean  open, Cinema  cinema){
      super();
      this.nameOfRoom = nameOfRoom;
      this.open = open;
      this.cinema = cinema;
   }
   public void execute(){
      try{this.result = Room.createFresh(nameOfRoom, open, cinema);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_constructor_Command extends ServiceCommand<Room>{
   private static final long serialVersionUID = 667389674L;
   private String  name;
   private Boolean  open;
   private Cinema  cinema;
   public Room_constructor_Command(String  name, Boolean  open, Cinema  cinema){
      super();
      this.name = name;
      this.open = open;
      this.cinema = cinema;
   }
   public void execute(){
      try{this.result = Room.createFresh(name, open, cinema);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

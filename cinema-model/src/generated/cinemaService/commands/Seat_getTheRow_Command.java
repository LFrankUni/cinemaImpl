/**--- Generated at Sun Mar 14 00:05:38 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_getTheRow_Command extends ObjectCommand<Seat, RoomRow>{
   private static final long serialVersionUID = -858978933L;
   public Seat_getTheRow_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class AbstractRow_addSeat_Command extends ObjectCommand<AbstractRow, Void>{
   private static final long serialVersionUID = 606957888L;
   private Seat seat;
   public AbstractRow_addSeat_Command(AbstractRow receiver, Seat seat){
      super(receiver);
      this.seat = seat;
   }
   public void execute(){
      try{this.receiver.addSeat(seat);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

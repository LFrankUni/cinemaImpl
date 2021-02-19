/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_price_Command extends ObjectCommand<Seat, Integer>{
   private static final long serialVersionUID = -1198967536L;
   public Seat_price_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.price();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

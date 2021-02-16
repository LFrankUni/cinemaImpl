/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_price_Command extends ObjectCommand<Seat, Integer>{
   private static final long serialVersionUID = -8145698L;
   public Seat_price_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.price();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

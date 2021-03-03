/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_getTheSeat_Command extends ObjectCommand<Ticket, Seat>{
   private static final long serialVersionUID = -174454874L;
   public Ticket_getTheSeat_Command(Ticket receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheSeat();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

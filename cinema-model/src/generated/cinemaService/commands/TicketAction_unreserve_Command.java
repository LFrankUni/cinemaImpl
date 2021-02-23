/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketAction_unreserve_Command extends ObjectCommand<TicketAction, Ticket>{
   private static final long serialVersionUID = 698070230L;
   public TicketAction_unreserve_Command(TicketAction receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.unreserve();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

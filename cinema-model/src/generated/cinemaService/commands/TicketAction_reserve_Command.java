/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketAction_reserve_Command extends ObjectCommand<TicketAction, TicketState>{
   private static final long serialVersionUID = 1013483351L;
   public TicketAction_reserve_Command(TicketAction receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.reserve();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

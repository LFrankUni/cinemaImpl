/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketAction_reserve_Command extends ObjectCommand<TicketAction, Ticket>{
   private static final long serialVersionUID = -890664157L;
   private User user;
   public TicketAction_reserve_Command(TicketAction receiver, User user){
      super(receiver);
      this.user = user;
   }
   public void execute(){
      try{this.result = this.receiver.reserve(user);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

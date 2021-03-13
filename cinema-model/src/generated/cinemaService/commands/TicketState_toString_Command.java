/**--- Generated at Sun Mar 14 00:09:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketState_toString_Command extends ObjectCommand<TicketState, String>{
   private static final long serialVersionUID = 1854851422L;
   public TicketState_toString_Command(TicketState receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.toString();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

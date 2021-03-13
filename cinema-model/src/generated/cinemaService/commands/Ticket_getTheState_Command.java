/**--- Generated at Sun Mar 14 00:07:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_getTheState_Command extends ObjectCommand<Ticket, String>{
   private static final long serialVersionUID = 248960018L;
   public Ticket_getTheState_Command(Ticket receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheState();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

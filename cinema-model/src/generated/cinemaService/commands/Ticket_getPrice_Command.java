/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_getPrice_Command extends ObjectCommand<Ticket, Integer>{
   private static final long serialVersionUID = 573712397L;
   public Ticket_getPrice_Command(Ticket receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPrice();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

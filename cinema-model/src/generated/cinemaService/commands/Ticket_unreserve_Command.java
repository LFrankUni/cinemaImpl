/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_unreserve_Command extends ObjectCommand<Ticket, Ticket>{
   private static final long serialVersionUID = 1914236819L;
   public Ticket_unreserve_Command(Ticket receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.unreserve();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketAction_book_Command extends ObjectCommand<TicketAction, TicketState>{
   private static final long serialVersionUID = 2069851087L;
   public TicketAction_book_Command(TicketAction receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.book();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class User_getAllTickets_Command extends ObjectCommand<User, Collection<Ticket>>{
   private static final long serialVersionUID = -1233246377L;
   public User_getAllTickets_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllTickets();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

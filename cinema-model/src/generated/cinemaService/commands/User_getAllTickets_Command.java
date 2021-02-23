/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class User_getAllTickets_Command extends ObjectCommand<User, Collection<Ticket>>{
   private static final long serialVersionUID = 1180364769L;
   public User_getAllTickets_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllTickets();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

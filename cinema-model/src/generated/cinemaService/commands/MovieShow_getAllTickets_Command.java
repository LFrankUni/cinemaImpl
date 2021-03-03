/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class MovieShow_getAllTickets_Command extends ObjectCommand<MovieShow, Collection<Ticket>>{
   private static final long serialVersionUID = 2074626338L;
   public MovieShow_getAllTickets_Command(MovieShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllTickets();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

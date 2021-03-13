/**--- Generated at Sun Mar 14 00:09:50 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Available_constructor_Command extends ServiceCommand<Available>{
   private static final long serialVersionUID = 935620440L;
   private Ticket ticket;
   public Available_constructor_Command(Ticket ticket){
      super();
      this.ticket = ticket;
   }
   public void execute(){
      try{this.result = Available.createFresh(ticket);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

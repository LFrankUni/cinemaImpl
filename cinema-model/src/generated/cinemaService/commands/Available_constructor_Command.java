/**--- Generated at Fri Mar 12 16:48:52 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Available_constructor_Command extends ServiceCommand<Available>{
   private static final long serialVersionUID = -900129930L;
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

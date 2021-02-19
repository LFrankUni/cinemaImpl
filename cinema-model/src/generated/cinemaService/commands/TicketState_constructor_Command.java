/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class TicketState_constructor_Command extends ServiceCommand<TicketState>{
   private static final long serialVersionUID = -1643050675L;
   public TicketState_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = TicketState.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

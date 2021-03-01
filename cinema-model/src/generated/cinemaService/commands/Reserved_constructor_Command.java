/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reserved_constructor_Command extends ServiceCommand<Reserved>{
   private static final long serialVersionUID = -1282531565L;
   private Ticket ticket;
   public Reserved_constructor_Command(Ticket ticket){
      super();
      this.ticket = ticket;
   }
   public void execute(){
      try{this.result = Reserved.createFresh(ticket);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

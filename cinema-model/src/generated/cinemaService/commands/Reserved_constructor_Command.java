/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reserved_constructor_Command extends ServiceCommand<Reserved>{
   private static final long serialVersionUID = 1505282020L;
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

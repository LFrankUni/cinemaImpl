/**--- Generated at Sun Mar 14 13:03:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reserved_constructor_Command extends ServiceCommand<Reserved>{
   private static final long serialVersionUID = -599052676L;
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

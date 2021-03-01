/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booked_constructor_Command extends ServiceCommand<Booked>{
   private static final long serialVersionUID = -686542954L;
   private Ticket ticket;
   public Booked_constructor_Command(Ticket ticket){
      super();
      this.ticket = ticket;
   }
   public void execute(){
      try{this.result = Booked.createFresh(ticket);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

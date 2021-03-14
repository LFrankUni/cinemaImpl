/**--- Generated at Sun Mar 14 13:03:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_getTheUser_Command extends ObjectCommand<Ticket, User>{
   private static final long serialVersionUID = 2121494091L;
   public Ticket_getTheUser_Command(Ticket receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheUser();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

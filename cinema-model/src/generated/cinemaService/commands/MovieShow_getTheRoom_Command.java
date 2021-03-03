/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_getTheRoom_Command extends ObjectCommand<MovieShow, Room>{
   private static final long serialVersionUID = -1027542132L;
   public MovieShow_getTheRoom_Command(MovieShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheRoom();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_getTheMovie_Command extends ObjectCommand<MovieShow, Movie>{
   private static final long serialVersionUID = -625218867L;
   public MovieShow_getTheMovie_Command(MovieShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheMovie();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

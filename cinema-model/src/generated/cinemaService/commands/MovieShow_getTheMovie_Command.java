/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_getTheMovie_Command extends ObjectCommand<MovieShow, Movie>{
   private static final long serialVersionUID = 1069834887L;
   public MovieShow_getTheMovie_Command(MovieShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getTheMovie();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

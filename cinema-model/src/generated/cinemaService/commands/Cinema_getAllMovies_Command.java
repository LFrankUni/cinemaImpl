/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Cinema_getAllMovies_Command extends ObjectCommand<Cinema, Collection<Movie>>{
   private static final long serialVersionUID = -1654820935L;
   public Cinema_getAllMovies_Command(Cinema receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllMovies();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

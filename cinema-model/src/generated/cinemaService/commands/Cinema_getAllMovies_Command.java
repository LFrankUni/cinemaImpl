/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Cinema_getAllMovies_Command extends ObjectCommand<Cinema, Collection<Movie>>{
   private static final long serialVersionUID = 1491404393L;
   public Cinema_getAllMovies_Command(Cinema receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getAllMovies();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

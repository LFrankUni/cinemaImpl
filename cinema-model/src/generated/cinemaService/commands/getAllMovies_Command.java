/**--- Generated at Thu Mar 11 18:35:14 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getAllMovies_Command extends ServiceCommand<Collection<Movie>>{
   private static final long serialVersionUID = -1433319360L;
   public getAllMovies_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getAllMovies();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sat Mar 06 15:37:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Cinema_addMovie_Command extends ObjectCommand<Cinema, Movie>{
   private static final long serialVersionUID = -356557159L;
   private Movie movie;
   public Cinema_addMovie_Command(Cinema receiver, Movie movie){
      super(receiver);
      this.movie = movie;
   }
   public void execute(){
      try{this.result = this.receiver.addMovie(movie);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Cinema_addMovie_Command extends ObjectCommand<Cinema, Void>{
   private static final long serialVersionUID = -981652448L;
   private Movie movie;
   public Cinema_addMovie_Command(Cinema receiver, Movie movie){
      super(receiver);
      this.movie = movie;
   }
   public void execute(){
      try{this.receiver.addMovie(movie);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

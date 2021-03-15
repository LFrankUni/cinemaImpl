/**--- Generated at Sun Mar 14 22:23:08 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Movie_constructor_Command extends ServiceCommand<Movie>{
   private static final long serialVersionUID = -1001439977L;
   private String  title;
   private String  description;
   private Integer  minutes;
   public Movie_constructor_Command(String  title, String  description, Integer  minutes){
      super();
      this.title = title;
      this.description = description;
      this.minutes = minutes;
   }
   public void execute(){
      try{this.result = Movie.createFresh(title, description, minutes);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

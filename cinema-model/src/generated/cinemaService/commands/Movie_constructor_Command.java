/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Movie_constructor_Command extends ServiceCommand<Movie>{
   private static final long serialVersionUID = 1401514659L;
   private String  titel;
   private String  description;
   private Integer  minutes;
   public Movie_constructor_Command(String  titel, String  description, Integer  minutes){
      super();
      this.titel = titel;
      this.description = description;
      this.minutes = minutes;
   }
   public void execute(){
      try{this.result = Movie.createFresh(titel, description, minutes);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

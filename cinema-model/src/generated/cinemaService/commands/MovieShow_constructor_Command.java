/**--- Generated at Sun Mar 07 13:57:14 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_constructor_Command extends ServiceCommand<MovieShow>{
   private static final long serialVersionUID = -1428467638L;
   private Movie movie;
   private String  start;
   private String  end;
   private Boolean  threeDimensional;
   private Integer  priceInCent;
   private Room  room;
   public MovieShow_constructor_Command(Movie movie, String  start, String  end, Boolean  threeDimensional, Integer  priceInCent, Room  room){
      super();
      this.movie = movie;
      this.start = start;
      this.end = end;
      this.threeDimensional = threeDimensional;
      this.priceInCent = priceInCent;
      this.room = room;
   }
   public void execute(){
      try{this.result = MovieShow.createFresh(movie, start, end, threeDimensional, priceInCent, room);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

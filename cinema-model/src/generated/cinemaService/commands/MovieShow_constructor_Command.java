/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_constructor_Command extends ServiceCommand<MovieShow>{
   private static final long serialVersionUID = 1674191265L;
   private Movie shownMovie;
   private String  start;
   private String  end;
   private Integer  price;
   private Room  room;
   public MovieShow_constructor_Command(Movie shownMovie, String  start, String  end, Integer  price, Room  room){
      super();
      this.shownMovie = shownMovie;
      this.start = start;
      this.end = end;
      this.price = price;
      this.room = room;
   }
   public void execute(){
      try{this.result = MovieShow.createFresh(shownMovie, start, end, price, room);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

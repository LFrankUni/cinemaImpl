/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_constructor_Command extends ServiceCommand<MovieShow>{
   private static final long serialVersionUID = -2085361687L;
   private String  start;
   private String  end;
   private Integer  price;
   private Boolean  threeD;
   private Room  room;
   public MovieShow_constructor_Command(String  start, String  end, Integer  price, Boolean  threeD, Room  room){
      super();
      this.start = start;
      this.end = end;
      this.price = price;
      this.threeD = threeD;
      this.room = room;
   }
   public void execute(){
      try{this.result = MovieShow.createFresh(start, end, price, threeD, room);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

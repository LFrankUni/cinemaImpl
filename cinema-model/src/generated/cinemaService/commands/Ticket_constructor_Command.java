/**--- Generated at Sun Mar 07 13:57:14 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_constructor_Command extends ServiceCommand<Ticket>{
   private static final long serialVersionUID = -1835411675L;
   private Seat seat;
   private MovieShow  movieShow;
   public Ticket_constructor_Command(Seat seat, MovieShow  movieShow){
      super();
      this.seat = seat;
      this.movieShow = movieShow;
   }
   public void execute(){
      try{this.result = Ticket.createFresh(seat, movieShow);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_constructor_Command extends ServiceCommand<Ticket>{
   private static final long serialVersionUID = -730335758L;
   private TicketState state;
   private Seat seat;
   private MovieShow  movieShow;
   private User  by;
   public Ticket_constructor_Command(TicketState state, Seat seat, MovieShow  movieShow, User  by){
      super();
      this.state = state;
      this.seat = seat;
      this.movieShow = movieShow;
      this.by = by;
   }
   public void execute(){
      try{this.result = Ticket.createFresh(state, seat, movieShow, by);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

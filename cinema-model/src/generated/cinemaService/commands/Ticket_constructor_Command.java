/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_constructor_Command extends ServiceCommand<Ticket>{
   private static final long serialVersionUID = 2076105219L;
   private Seat seat;
   private String  state;
   private MovieShow  movieShow;
   private User  user;
   public Ticket_constructor_Command(Seat seat, String  state, MovieShow  movieShow, User  user){
      super();
      this.seat = seat;
      this.state = state;
      this.movieShow = movieShow;
      this.user = user;
   }
   public void execute(){
      try{this.result = Ticket.createFresh(seat, state, movieShow, user);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Ticket_constructor_Command extends ServiceCommand<Ticket>{
   private static final long serialVersionUID = 1022502176L;
   private Seat seat;
   private MovieShow  movieShow;
   private User  user;
   public Ticket_constructor_Command(Seat seat, MovieShow  movieShow, User  user){
      super();
      this.seat = seat;
      this.movieShow = movieShow;
      this.user = user;
   }
   public void execute(){
      try{this.result = Ticket.createFresh(seat, movieShow, user);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MovieShow_book_Command extends ObjectCommand<MovieShow, Ticket>{
   private static final long serialVersionUID = -575186393L;
   private Integer seat;
   private Integer row;
   private User by;
   public MovieShow_book_Command(MovieShow receiver, Integer seat, Integer row, User by){
      super(receiver);
      this.seat = seat;
      this.row = row;
      this.by = by;
   }
   public void execute(){
      try{this.result = this.receiver.book(seat, row, by);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

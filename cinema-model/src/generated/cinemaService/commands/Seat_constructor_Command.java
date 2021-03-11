/**--- Generated at Thu Mar 11 18:42:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = -541602996L;
   private Integer  number;
   private RoomRow  row;
   public Seat_constructor_Command(Integer  number, RoomRow  row){
      super();
      this.number = number;
      this.row = row;
   }
   public void execute(){
      try{this.result = Seat.createFresh(number, row);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MiddleRow_constructor_Command extends ServiceCommand<MiddleRow>{
   private static final long serialVersionUID = -1487106215L;
   private Integer  price;
   private Integer  number;
   private Room room;
   public MiddleRow_constructor_Command(Integer  price, Integer  number, Room room){
      super();
      this.price = price;
      this.number = number;
      this.room = room;
   }
   public void execute(){
      try{this.result = MiddleRow.createFresh(price, number, room);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

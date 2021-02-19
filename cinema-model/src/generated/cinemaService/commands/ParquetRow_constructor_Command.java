/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class ParquetRow_constructor_Command extends ServiceCommand<ParquetRow>{
   private static final long serialVersionUID = -388414914L;
   private Integer  price;
   private Integer  number;
   private Room room;
   public ParquetRow_constructor_Command(Integer  price, Integer  number, Room room){
      super();
      this.price = price;
      this.number = number;
      this.room = room;
   }
   public void execute(){
      try{this.result = ParquetRow.createFresh(price, number, room);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

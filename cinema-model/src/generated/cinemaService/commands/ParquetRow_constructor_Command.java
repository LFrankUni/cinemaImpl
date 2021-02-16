/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class ParquetRow_constructor_Command extends ServiceCommand<ParquetRow>{
   private static final long serialVersionUID = -644389166L;
   private Integer  price;
   private Integer  number;
   public ParquetRow_constructor_Command(Integer  price, Integer  number){
      super();
      this.price = price;
      this.number = number;
   }
   public void execute(){
      try{this.result = ParquetRow.createFresh(price, number);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

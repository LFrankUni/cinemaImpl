/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MiddleRow_constructor_Command extends ServiceCommand<MiddleRow>{
   private static final long serialVersionUID = 1536256012L;
   private Integer  price;
   private Integer  number;
   public MiddleRow_constructor_Command(Integer  price, Integer  number){
      super();
      this.price = price;
      this.number = number;
   }
   public void execute(){
      try{this.result = MiddleRow.createFresh(price, number);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

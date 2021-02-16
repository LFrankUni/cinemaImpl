/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class BackRow_constructor_Command extends ServiceCommand<BackRow>{
   private static final long serialVersionUID = -1757435308L;
   private Integer  price;
   private Integer  number;
   public BackRow_constructor_Command(Integer  price, Integer  number){
      super();
      this.price = price;
      this.number = number;
   }
   public void execute(){
      try{this.result = BackRow.createFresh(price, number);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

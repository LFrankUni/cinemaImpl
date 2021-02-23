/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class MiddleRow_constructor_Command extends ServiceCommand<MiddleRow>{
   private static final long serialVersionUID = -325014587L;
   private String  name;
   private Integer  priceInCent;
   public MiddleRow_constructor_Command(String  name, Integer  priceInCent){
      super();
      this.name = name;
      this.priceInCent = priceInCent;
   }
   public void execute(){
      try{this.result = MiddleRow.createFresh(name, priceInCent);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

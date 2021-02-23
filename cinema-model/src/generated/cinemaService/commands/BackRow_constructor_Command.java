/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class BackRow_constructor_Command extends ServiceCommand<BackRow>{
   private static final long serialVersionUID = -147393691L;
   private String  name;
   private Integer  priceInCent;
   public BackRow_constructor_Command(String  name, Integer  priceInCent){
      super();
      this.name = name;
      this.priceInCent = priceInCent;
   }
   public void execute(){
      try{this.result = BackRow.createFresh(name, priceInCent);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class BackRow_constructor_Command extends ServiceCommand<BackRow>{
   private static final long serialVersionUID = -230668708L;
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

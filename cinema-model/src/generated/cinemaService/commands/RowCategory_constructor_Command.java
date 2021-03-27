/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RowCategory_constructor_Command extends ServiceCommand<RowCategory>{
   private static final long serialVersionUID = -542018761L;
   private String  name;
   private Integer  priceInCents;
   public RowCategory_constructor_Command(String  name, Integer  priceInCents){
      super();
      this.name = name;
      this.priceInCents = priceInCents;
   }
   public void execute(){
      try{this.result = RowCategory.createFresh(name, priceInCents);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

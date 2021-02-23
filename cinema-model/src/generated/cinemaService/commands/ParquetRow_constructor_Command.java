/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class ParquetRow_constructor_Command extends ServiceCommand<ParquetRow>{
   private static final long serialVersionUID = -1911384246L;
   private String  name;
   private Integer  priceInCent;
   public ParquetRow_constructor_Command(String  name, Integer  priceInCent){
      super();
      this.name = name;
      this.priceInCent = priceInCent;
   }
   public void execute(){
      try{this.result = ParquetRow.createFresh(name, priceInCent);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

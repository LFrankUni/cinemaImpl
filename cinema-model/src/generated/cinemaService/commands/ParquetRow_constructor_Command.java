/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class ParquetRow_constructor_Command extends ServiceCommand<ParquetRow>{
   private static final long serialVersionUID = -1388981359L;
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

/**--- Generated at Sun Mar 14 22:23:09 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Available_constructor_Command extends ServiceCommand<Available>{
   private static final long serialVersionUID = -1500569166L;
   public Available_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Available.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

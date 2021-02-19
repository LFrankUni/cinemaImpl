/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class income_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = -240628171L;
   public income_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().income();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

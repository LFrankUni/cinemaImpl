/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class income_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = 1422571834L;
   public income_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().income();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

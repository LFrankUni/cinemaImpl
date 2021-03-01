/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class income_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = 1828916120L;
   public income_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().income();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

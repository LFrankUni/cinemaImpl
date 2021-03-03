/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getAllCinemas_Command extends ServiceCommand<Collection<Cinema>>{
   private static final long serialVersionUID = 1745069688L;
   public getAllCinemas_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getAllCinemas();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sun Mar 14 22:23:09 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booked_constructor_Command extends ServiceCommand<Booked>{
   private static final long serialVersionUID = 2034001460L;
   public Booked_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Booked.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

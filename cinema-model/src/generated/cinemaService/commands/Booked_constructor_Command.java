/**--- Generated at Sat Mar 27 13:48:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booked_constructor_Command extends ServiceCommand<Booked>{
   private static final long serialVersionUID = -1471704742L;
   public Booked_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Booked.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Sun Mar 14 22:23:09 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reserved_constructor_Command extends ServiceCommand<Reserved>{
   private static final long serialVersionUID = -1812902403L;
   public Reserved_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Reserved.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

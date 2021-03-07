/**--- Generated at Sun Mar 07 13:57:14 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getAllRowCategories_Command extends ServiceCommand<Collection<RowCategory>>{
   private static final long serialVersionUID = 637064637L;
   public getAllRowCategories_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getAllRowCategories();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

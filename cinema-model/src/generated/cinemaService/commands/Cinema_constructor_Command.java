/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Cinema_constructor_Command extends ServiceCommand<Cinema>{
   private static final long serialVersionUID = 2132646341L;
   private String  name;
   public Cinema_constructor_Command(String  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Cinema.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

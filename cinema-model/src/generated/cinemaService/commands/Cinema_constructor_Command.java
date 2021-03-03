/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Cinema_constructor_Command extends ServiceCommand<Cinema>{
   private static final long serialVersionUID = -1272945482L;
   private String  nameOfCinema;
   public Cinema_constructor_Command(String  nameOfCinema){
      super();
      this.nameOfCinema = nameOfCinema;
   }
   public void execute(){
      try{this.result = Cinema.createFresh(nameOfCinema);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

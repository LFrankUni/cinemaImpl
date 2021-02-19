/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class User_constructor_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = -1988363660L;
   private String  firstName;
   private String  lastName;
   public User_constructor_Command(String  firstName, String  lastName){
      super();
      this.firstName = firstName;
      this.lastName = lastName;
   }
   public void execute(){
      try{this.result = User.createFresh(firstName, lastName);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

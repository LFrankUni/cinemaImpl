/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class User_constructor_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1850595035L;
   private String  firstName;
   private String  lastName;
   private String  role;
   public User_constructor_Command(String  firstName, String  lastName, String  role){
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.role = role;
   }
   public void execute(){
      try{this.result = User.createFresh(firstName, lastName, role);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

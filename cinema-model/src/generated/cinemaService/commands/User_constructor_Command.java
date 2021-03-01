/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class User_constructor_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 57993799L;
   private String  firstName;
   private String  lastName;
   private String  email;
   private String  password;
   public User_constructor_Command(String  firstName, String  lastName, String  email, String  password){
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
   }
   public void execute(){
      try{this.result = User.createFresh(firstName, lastName, email, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class signUp_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = -2026199990L;
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   public signUp_Command(String firstName, String lastName, String email, String password){
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().signUp(firstName, lastName, email, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

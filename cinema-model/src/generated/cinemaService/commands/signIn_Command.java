/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class signIn_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = -680037517L;
   private String email;
   private String password;
   public signIn_Command(String email, String password){
      super();
      this.email = email;
      this.password = password;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().signIn(email, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}

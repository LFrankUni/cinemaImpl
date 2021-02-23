/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class signIn_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1672418925L;
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

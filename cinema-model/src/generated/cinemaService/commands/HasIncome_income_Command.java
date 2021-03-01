/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class HasIncome_income_Command extends ObjectCommand<HasIncome, Integer>{
   private static final long serialVersionUID = 2034029036L;
   public HasIncome_income_Command(HasIncome receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.income();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

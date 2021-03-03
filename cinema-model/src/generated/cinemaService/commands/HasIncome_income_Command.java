/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class HasIncome_income_Command extends ObjectCommand<HasIncome, Integer>{
   private static final long serialVersionUID = 1353252954L;
   public HasIncome_income_Command(HasIncome receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.income();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

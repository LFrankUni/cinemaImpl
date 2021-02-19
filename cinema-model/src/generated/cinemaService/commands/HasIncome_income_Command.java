/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class HasIncome_income_Command extends ObjectCommand<HasIncome, Integer>{
   private static final long serialVersionUID = 1396021358L;
   public HasIncome_income_Command(HasIncome receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.income();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

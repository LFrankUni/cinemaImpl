/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.test.commands;
import generated.test.*;
import commands.*;
public class Class_2_constructor_Command extends ServiceCommand<Class_2>{
   private static final long serialVersionUID = 449270954L;
   public Class_2_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Class_2.createFresh();
      }catch(Exception e){this.e = e;
      }finally{Test.getInstance().notifyObservers(this);}
   }
}

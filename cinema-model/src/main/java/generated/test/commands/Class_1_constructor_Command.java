/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.test.commands;
import generated.test.*;
import commands.*;
public class Class_1_constructor_Command extends ServiceCommand<Class_1>{
   private static final long serialVersionUID = 278136060L;
   private Class_2 c2;
   private Boolean  a1;
   public Class_1_constructor_Command(Class_2 c2, Boolean  a1){
      super();
      this.c2 = c2;
      this.a1 = a1;
   }
   public void execute(){
      try{this.result = Class_1.createFresh(c2, a1);
      }catch(Exception e){this.e = e;
      }finally{Test.getInstance().notifyObservers(this);}
   }
}

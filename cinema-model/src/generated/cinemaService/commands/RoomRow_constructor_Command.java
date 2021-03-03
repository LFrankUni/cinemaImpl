/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RoomRow_constructor_Command extends ServiceCommand<RoomRow>{
   private static final long serialVersionUID = -2079823719L;
   private RowCategory category;
   private String  name;
   public RoomRow_constructor_Command(RowCategory category, String  name){
      super();
      this.category = category;
      this.name = name;
   }
   public void execute(){
      try{this.result = RoomRow.createFresh(category, name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
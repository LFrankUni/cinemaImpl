/**--- Generated at Sat Mar 13 12:12:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RoomRow_constructor_Command extends ServiceCommand<RoomRow>{
   private static final long serialVersionUID = -1251084336L;
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

/**--- Generated at Fri Mar 12 16:48:51 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class RoomRow_constructor_Command extends ServiceCommand<RoomRow>{
   private static final long serialVersionUID = 807865468L;
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

/**--- Generated at Wed Mar 03 11:50:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_addRow_Command extends ObjectCommand<Room, RoomRow>{
   private static final long serialVersionUID = 302667331L;
   private String name;
   private RowCategory type;
   public Room_addRow_Command(Room receiver, String name, RowCategory type){
      super(receiver);
      this.name = name;
      this.type = type;
   }
   public void execute(){
      try{this.result = this.receiver.addRow(name, type);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

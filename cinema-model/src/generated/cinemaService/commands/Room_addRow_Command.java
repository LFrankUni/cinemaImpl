/**--- Generated at Mon Mar 01 13:44:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_addRow_Command extends ObjectCommand<Room, Void>{
   private static final long serialVersionUID = 1118043620L;
   private AbstractRow row;
   public Room_addRow_Command(Room receiver, AbstractRow row){
      super(receiver);
      this.row = row;
   }
   public void execute(){
      try{this.receiver.addRow(row);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}

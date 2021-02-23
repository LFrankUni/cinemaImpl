/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Room_addRow_Command extends ObjectCommand<Room, Void>{
   private static final long serialVersionUID = 1685792292L;
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

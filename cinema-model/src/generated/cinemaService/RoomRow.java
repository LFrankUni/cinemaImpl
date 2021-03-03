/**--- Generated at Wed Mar 03 18:19:11 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.RoomRowProxy;
import observation.Observable;
import generated.cinemaService.proxies.IRoomRow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class RoomRow extends Observable implements java.io.Serializable, IRoomRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   //40 ===== Editable : Your Attribute Section ======

	//50 ===== GENERATED:      Constructor ============
   private RoomRow(Integer id, RowCategory category, String name, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      rowToCategorySupervisor.getInstance().set(this, category);
      this.name = name;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static RoomRow createAlreadyPersistent(RoomRowProxy proxy, RowCategory category, String name)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new RoomRow(proxy.getId(), category, name, true);
   }
   public static RoomRow createFresh(RowCategory category, String name)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("RoomRow", "id, typeKey, name", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "RoomRow").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      RoomRow me = new RoomRow(id, category, name, false);
      CinemaService.getInstance().addRoomRowProxy(new RoomRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========

	//70 ===== GENERATED:      Feature Access =========
   public RoomRow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoomRow)) return false;
      return ((IRoomRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public RowCategory getCategory() throws PersistenceException{
      return rowToCategorySupervisor.getInstance().getCategory(this).getTheObject();
   }
   public void setCategory(RowCategory newCategory)throws PersistenceException{
      rowToCategorySupervisor.getInstance().change(this, this.getCategory(), newCategory);
   }
   public Set<Seat> getSeats() throws PersistenceException{
      Set<Seat> result = new HashSet<>();
      for (ISeat i : rowToSeatsSupervisor.getInstance().getSeats(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      rowToSeatsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException{
      return rowToSeatsSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("RoomRow", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Adds a seat to the row.
	 */
	public void addSeat(Seat seat) throws ModelException {
		this.addToSeats(seat);
	}
//90 ===== GENERATED: End of Your Operations ======
}

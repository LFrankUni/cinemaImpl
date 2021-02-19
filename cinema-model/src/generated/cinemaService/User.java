/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.IUser;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User extends Observable implements java.io.Serializable, IUser
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String firstName;
   private String lastName;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User(Integer id, String firstName, String lastName, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.firstName = firstName;
      this.lastName = lastName;
      if(objectOnly) return;
   }
   public static User createAlreadyPersistent(Integer id, String firstName, String lastName){
      return new User(id, firstName, lastName, true);
   }
   public static User createFresh(String firstName, String lastName)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("User", "id, typeKey, firstName, lastName", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "User").toString() + ", " + "'" + firstName + "'" + ", " + "'" + lastName + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      User me = new User(id, firstName, lastName, false);
      generated.cinemaService.proxies.UserProxy p = new generated.cinemaService.proxies.UserProxy(me);
      CinemaService.getInstance().addUserProxy(p);
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public User getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Ticket> getTickets() throws PersistenceException{
      Set<Ticket> result = new HashSet<>();
      for (ITicket i : ticketsOfUserSupervisor.getInstance().getTickets(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      ticketsOfUserSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return ticketsOfUserSupervisor.getInstance().remove(this, arg);
   }
   public String getFirstName() {
      return this.firstName;
   }
   public void setFirstName(String newFirstName) throws PersistenceException{
      this.firstName = newFirstName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "firstName", "'" + newFirstName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getLastName() {
      return this.lastName;
   }
   public void setLastName(String newLastName) throws PersistenceException{
      this.lastName = newLastName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "lastName", "'" + newLastName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}

/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.UserProxy;
import observation.Observable;
import generated.cinemaService.proxies.IUser;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User extends Observable implements java.io.Serializable, IUser
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User(Integer id, String firstName, String lastName, String email, String password, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static User createAlreadyPersistent(UserProxy proxy, String firstName, String lastName, String email, String password){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new User(proxy.getId(), firstName, lastName, email, password, true);
   }
   public static User createFresh(String firstName, String lastName, String email, String password)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("User", "id, typeKey, firstName, lastName, email, password", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "User").toString() + ", " + "'" + firstName + "'" + ", " + "'" + lastName + "'" + ", " + "'" + email + "'" + ", " + "'" + password + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      User me = new User(id, firstName, lastName, email, password, false);
      CinemaService.getInstance().addUserProxy(new UserProxy(me));
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
      for (ITicket i : userToTicketSupervisor.getInstance().getTickets(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      userToTicketSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return userToTicketSupervisor.getInstance().remove(this, arg);
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
   public String getEmail() {
      return this.email;
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.email = newEmail;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "email", "'" + newEmail + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getPassword() {
      return this.password;
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.password = newPassword;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "password", "'" + newPassword + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * Returns all the Tickets of a user.
 */
   public Collection<Ticket> getAllTickets()throws ModelException{
      // TODO: Implement Operation getAllTickets
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}

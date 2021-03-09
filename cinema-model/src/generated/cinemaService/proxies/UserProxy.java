/**--- Generated at Tue Mar 09 10:12:33 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.User;
import java.sql.ResultSet;
import generated.cinemaService.Ticket;
import java.util.Set;
public class UserProxy implements IUser{
   private Integer id;
   private Optional<User> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public UserProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public UserProxy(User theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public User getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "User";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private User load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("User", this.id);
         String firstName = rs.getString("firstName");
         String lastName = rs.getString("lastName");
         String email = rs.getString("email");
         String password = rs.getString("password");
         return User.createAlreadyPersistent(this, firstName, lastName, email, password);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getFirstName() {
      return this.getTheObject().getFirstName();
   }
   public void setFirstName(String newFirstName) throws PersistenceException{
      this.getTheObject().setFirstName(newFirstName);
   }
   public String getLastName() {
      return this.getTheObject().getLastName();
   }
   public void setLastName(String newLastName) throws PersistenceException{
      this.getTheObject().setLastName(newLastName);
   }
   public String getEmail() {
      return this.getTheObject().getEmail();
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.getTheObject().setEmail(newEmail);
   }
   public String getPassword() {
      return this.getTheObject().getPassword();
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.getTheObject().setPassword(newPassword);
   }
   public Set<Ticket> getTickets() throws PersistenceException{
      return this.getTheObject().getTickets();
   }
}

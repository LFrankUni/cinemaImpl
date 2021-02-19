/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
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
import exceptions.ConstraintViolation;
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
   public User getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "User";}
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
         return User.createAlreadyPersistent(id, firstName, lastName);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Ticket> getTickets() throws PersistenceException{
      return this.getTheObject().getTickets();
   }
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToTickets(arg);
   }
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromTickets(arg);
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
}

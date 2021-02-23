/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.User;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
import java.util.Collection;
import generated.cinemaService.ModelException;
public interface IUser extends Identifiable{
   public User getTheObject();
   public Integer getId();
   public Set<Ticket> getTickets() throws PersistenceException;
   public void addToTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTickets(Ticket arg) throws ConstraintViolation, PersistenceException;
   public String getFirstName() ;
   public void setFirstName(String newFirstName) throws PersistenceException;
   public String getLastName() ;
   public void setLastName(String newLastName) throws PersistenceException;
   public String getEmail() ;
   public void setEmail(String newEmail) throws PersistenceException;
   public String getPassword() ;
   public void setPassword(String newPassword) throws PersistenceException;
   public Collection<Ticket> getAllTickets()throws ModelException;
}

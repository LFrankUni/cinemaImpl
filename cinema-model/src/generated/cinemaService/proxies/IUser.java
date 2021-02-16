/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.User;
import generated.cinemaService.Ticket;
import java.util.Set;
import exceptions.ConstraintViolation;
public interface IUser extends Identifiable{
   public User getTheObject();
   public Integer getId();
   public Set<Ticket> getTicket() throws PersistenceException;
   public void addToTicket(Ticket arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTicket(Ticket arg) throws ConstraintViolation, PersistenceException;
   public String getFirstName() ;
   public void setFirstName(String newFirstName) throws PersistenceException;
   public String getLastName() ;
   public void setLastName(String newLastName) throws PersistenceException;
   public String getRole() ;
   public void setRole(String newRole) throws PersistenceException;
}

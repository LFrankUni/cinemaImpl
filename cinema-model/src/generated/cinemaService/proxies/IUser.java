/**--- Generated at Wed Mar 03 11:50:32 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.User;
import generated.cinemaService.Ticket;
import java.util.Set;
import java.util.Collection;
import generated.cinemaService.ModelException;
public interface IUser extends Identifiable{
   public User getTheObject();
   public Integer getId();
   public String getFirstName() ;
   public void setFirstName(String newFirstName) throws PersistenceException;
   public String getLastName() ;
   public void setLastName(String newLastName) throws PersistenceException;
   public String getEmail() ;
   public void setEmail(String newEmail) throws PersistenceException;
   public String getPassword() ;
   public void setPassword(String newPassword) throws PersistenceException;
   public Set<Ticket> getTickets() throws PersistenceException;
   public Collection<Ticket> getAllTickets()throws ModelException;
}

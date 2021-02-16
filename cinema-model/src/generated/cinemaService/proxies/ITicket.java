/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Ticket;
import generated.cinemaService.Seat;
import generated.cinemaService.MovieShow;
import generated.cinemaService.User;
public interface ITicket extends Identifiable{
   public Ticket getTheObject();
   public Integer getId();
   public Seat getSeat() throws PersistenceException;
   public void setSeat(Seat newSeat)throws PersistenceException;
   public String getState() ;
   public void setState(String newState) throws PersistenceException;
   public MovieShow getMovieShow() throws PersistenceException;
   public User getUser() throws PersistenceException;
   public Integer getPrice();
}

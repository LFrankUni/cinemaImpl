/**--- Generated at Tue Feb 16 11:57:41 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Ticket;
import java.sql.ResultSet;
import generated.cinemaService.Seat;
import generated.cinemaService.relationControl.ticketSeatSupervisor;
import generated.cinemaService.MovieShow;
import generated.cinemaService.relationControl.ticketsOfMovieShowSupervisor;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.ticketsOfUserSupervisor;
public class TicketProxy implements ITicket{
   private Integer id;
   private Optional<Ticket> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public TicketProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public TicketProxy(Ticket theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public Ticket getTheObject()
   {
      try{if(!this.theObject.isPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Ticket";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITicket)) return false;
      return ((ITicket)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Ticket load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Ticket", this.id);
         Seat seat = ticketSeatSupervisor.getInstance().getSeat(this).getTheObject();
         String state = rs.getString("state");
         MovieShow movieShow = ticketsOfMovieShowSupervisor.getInstance().getMovieShow(this).getTheObject();
         User user = ticketsOfUserSupervisor.getInstance().getUser(this).getTheObject();
         return Ticket.createAlreadyPersistent(id, seat, state, movieShow, user);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Seat getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      this.getTheObject().setSeat(newSeat);
   }
   public String getState() {
      return this.getTheObject().getState();
   }
   public void setState(String newState) throws PersistenceException{
      this.getTheObject().setState(newState);
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return this.getTheObject().getMovieShow();
   }
   public User getUser() throws PersistenceException{
      return this.getTheObject().getUser();
   }
   public Integer getPrice(){
      return this.getTheObject().getPrice();
   }
}

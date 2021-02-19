/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Ticket;
import java.sql.ResultSet;
import generated.cinemaService.TicketState;
import generated.cinemaService.relationControl.ticketStateSupervisor;
import generated.cinemaService.Seat;
import generated.cinemaService.relationControl.ticketSeatSupervisor;
import generated.cinemaService.MovieShow;
import generated.cinemaService.relationControl.ticketsOfMovieShowSupervisor;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.ticketsOfUserSupervisor;
public class TicketProxy extends TicketActionProxy implements ITicket{
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
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("TicketAction", this.id);
         TicketState state = ticketStateSupervisor.getInstance().getState(this).getTheObject();
         Seat seat = ticketSeatSupervisor.getInstance().getSeat(this).getTheObject();
         MovieShow movieShow = ticketsOfMovieShowSupervisor.getInstance().getMovieShow(this).getTheObject();
         User by = ticketsOfUserSupervisor.getInstance().getBy(this).getTheObject();
         return Ticket.createAlreadyPersistent(id, state, seat, movieShow, by);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public TicketState getState() throws PersistenceException{
      return this.getTheObject().getState();
   }
   public void setState(TicketState newState)throws PersistenceException{
      this.getTheObject().setState(newState);
   }
   public Seat getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      this.getTheObject().setSeat(newSeat);
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return this.getTheObject().getMovieShow();
   }
   public User getBy() throws PersistenceException{
      return this.getTheObject().getBy();
   }
   public Integer getPrice(){
      return this.getTheObject().getPrice();
   }
   public TicketState book(){
      return this.getTheObject().book();
   }
   public TicketState reserve(){
      return this.getTheObject().reserve();
   }
   public TicketState unreserve(){
      return this.getTheObject().unreserve();
   }
}

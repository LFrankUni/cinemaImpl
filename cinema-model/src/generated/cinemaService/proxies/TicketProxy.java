/**--- Generated at Sun Feb 28 12:35:27 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Ticket;
import java.sql.ResultSet;
import generated.cinemaService.Seat;
import generated.cinemaService.relationControl.ticketToSeatSupervisor;
import generated.cinemaService.TicketState;
import exceptions.ConstraintViolation;
import generated.cinemaService.MovieShow;
import generated.cinemaService.relationControl.movieShowToTicketSupervisor;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.userToTicketSupervisor;
import generated.cinemaService.ModelException;
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
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Ticket getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Ticket";}
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
         Seat seat = ticketToSeatSupervisor.getInstance().getSeat(this).getTheObject();
         MovieShow movieShow = movieShowToTicketSupervisor.getInstance().getMovieShow(this).getTheObject();
         User user = userToTicketSupervisor.getInstance().getUser(this).getTheObject();
         return Ticket.createAlreadyPersistent(this, seat, movieShow, user);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Seat getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
   public void setSeat(Seat newSeat)throws PersistenceException{
      this.getTheObject().setSeat(newSeat);
   }
   public Optional<TicketState> getState() throws PersistenceException{
      return this.getTheObject().getState();
   }
   public void setState(TicketState newState)throws ConstraintViolation, PersistenceException{
      this.getTheObject().setState(newState);
   }
   public MovieShow getMovieShow() throws PersistenceException{
      return this.getTheObject().getMovieShow();
   }
   public User getUser() throws PersistenceException{
      return this.getTheObject().getUser();
   }
   public Seat getTheSeat()throws ModelException{
      return this.getTheObject().getTheSeat();
   }
   public Integer getPrice()throws ModelException{
      return this.getTheObject().getPrice();
   }
   public Ticket reserve(User user)throws ModelException{
      return this.getTheObject().reserve(user);
   }
   public Ticket book()throws ModelException{
      return this.getTheObject().book();
   }
   public Ticket unreserve()throws ModelException{
      return this.getTheObject().unreserve();
   }
}

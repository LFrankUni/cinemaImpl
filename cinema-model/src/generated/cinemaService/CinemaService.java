/**--- Generated at Sun Feb 21 20:25:25 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.cinemaService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.DBDMLExecuter;
import db.connection.TypeKeyManager;
import db.connection.DBConnectionManager;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class CinemaService extends Observable{
   DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,CinemaProxy> cinemaCache;
   private Map<Integer,RoomProxy> roomCache;
   private Map<Integer,ParquetRowProxy> parquetRowCache;
   private Map<Integer,MiddleRowProxy> middleRowCache;
   private Map<Integer,BackRowProxy> backRowCache;
   private Map<Integer,UserProxy> userCache;
   private Map<Integer,SeatProxy> seatCache;
   private Map<Integer,MovieProxy> movieCache;
   private Map<Integer,MovieShowProxy> movieShowCache;
   private Map<Integer,TicketProxy> ticketCache;
   private Map<Integer,TicketStateProxy> ticketStateCache;
   private Map<Integer,AvailableProxy> availableCache;
   private Map<Integer,BookedProxy> bookedCache;
   private Map<Integer,ReservedProxy> reservedCache;
   private static CinemaService theInstance = new CinemaService();
   private CinemaService(){
      try{DBConnectionManager.getTheInstance().openDBConnection(new DBConnectionData("jdbc:mysql://localhost:3306", "CinemaService", "root" , ""));
         TypeKeyManager.getTheInstance().initializeFor("CinemaService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static CinemaService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.cinemaCache = new InitialProxyLoader<CinemaProxy>("generated", "CinemaService", "cinemaService", "Cinema", "HasIncome").perform();
      this.roomCache = new InitialProxyLoader<RoomProxy>("generated", "CinemaService", "cinemaService", "Room", "HasIncome").perform();
      this.parquetRowCache = new InitialProxyLoader<ParquetRowProxy>("generated", "CinemaService", "cinemaService", "ParquetRow", "AbstractRow").perform();
      this.middleRowCache = new InitialProxyLoader<MiddleRowProxy>("generated", "CinemaService", "cinemaService", "MiddleRow", "AbstractRow").perform();
      this.backRowCache = new InitialProxyLoader<BackRowProxy>("generated", "CinemaService", "cinemaService", "BackRow", "AbstractRow").perform();
      this.userCache = new InitialProxyLoader<UserProxy>("generated", "CinemaService", "cinemaService", "User", "User").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "CinemaService", "cinemaService", "Seat", "Seat").perform();
      this.movieCache = new InitialProxyLoader<MovieProxy>("generated", "CinemaService", "cinemaService", "Movie", "HasIncome").perform();
      this.movieShowCache = new InitialProxyLoader<MovieShowProxy>("generated", "CinemaService", "cinemaService", "MovieShow", "HasIncome").perform();
      this.ticketCache = new InitialProxyLoader<TicketProxy>("generated", "CinemaService", "cinemaService", "Ticket", "TicketAction").perform();
      this.ticketStateCache = new InitialProxyLoader<TicketStateProxy>("generated", "CinemaService", "cinemaService", "TicketState", "TicketAction").perform();
      this.availableCache = new InitialProxyLoader<AvailableProxy>("generated", "CinemaService", "cinemaService", "Available", "Available").perform();
      this.bookedCache = new InitialProxyLoader<BookedProxy>("generated", "CinemaService", "cinemaService", "Booked", "Booked").perform();
      this.reservedCache = new InitialProxyLoader<ReservedProxy>("generated", "CinemaService", "cinemaService", "Reserved", "Reserved").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("roomes").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addroomesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movies").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmoviesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movieShowsOfRoom").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmovieShowsOfRoomElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rowsOfRoom").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "AbstractRow", "CinemaService");
         try{this.addrowsOfRoomElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("seatsOfRow").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "AbstractRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addseatsOfRowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movieShowsOfMovie").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmovieShowsOfMovieElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ticketState").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "TicketAction", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "TicketAction", "CinemaService");
         try{this.addticketStateElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ticketsOfMovieShow").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "TicketAction", "CinemaService");
         try{this.addticketsOfMovieShowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ticketsOfUser").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "User", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "TicketAction", "CinemaService");
         try{this.addticketsOfUserElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ticketSeat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "TicketAction", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addticketSeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addroomesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; IRoom proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = this.cinemaCache.get(id1);
      if(className2.equals("Room"))  proxy2 = this.roomCache.get(id2);
      roomesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addmoviesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; IMovie proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = this.cinemaCache.get(id1);
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      moviesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addmovieShowsOfRoomElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoom proxy1 = null; IMovieShow proxy2 = null; 
      if(className1.equals("Room"))  proxy1 = this.roomCache.get(id1);
      if(className2.equals("MovieShow"))  proxy2 = this.movieShowCache.get(id2);
      movieShowsOfRoomSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addrowsOfRoomElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoom proxy1 = null; IAbstractRow proxy2 = null; 
      if(className1.equals("Room"))  proxy1 = this.roomCache.get(id1);
      if(className2.equals("ParquetRow"))  proxy2 = this.parquetRowCache.get(id2);
      if(className2.equals("MiddleRow"))  proxy2 = this.middleRowCache.get(id2);
      if(className2.equals("BackRow"))  proxy2 = this.backRowCache.get(id2);
      rowsOfRoomSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addseatsOfRowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IAbstractRow proxy1 = null; ISeat proxy2 = null; 
      if(className1.equals("ParquetRow"))  proxy1 = this.parquetRowCache.get(id1);
      if(className1.equals("MiddleRow"))  proxy1 = this.middleRowCache.get(id1);
      if(className1.equals("BackRow"))  proxy1 = this.backRowCache.get(id1);
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      seatsOfRowSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addmovieShowsOfMovieElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IMovieShow proxy1 = null; IMovie proxy2 = null; 
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      if(className1.equals("MovieShow"))  proxy1 = this.movieShowCache.get(id1);
      movieShowsOfMovieSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addticketStateElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITicket proxy1 = null; ITicketState proxy2 = null; 
      if(className1.equals("Ticket"))  proxy1 = this.ticketCache.get(id1);
      if(className2.equals("TicketState"))  proxy2 = this.ticketStateCache.get(id2);
      ticketStateSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addticketsOfMovieShowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IMovieShow proxy1 = null; ITicket proxy2 = null; 
      if(className1.equals("MovieShow"))  proxy1 = this.movieShowCache.get(id1);
      if(className2.equals("Ticket"))  proxy2 = this.ticketCache.get(id2);
      ticketsOfMovieShowSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addticketsOfUserElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IUser proxy1 = null; ITicket proxy2 = null; 
      if(className1.equals("User"))  proxy1 = this.userCache.get(id1);
      if(className2.equals("Ticket"))  proxy2 = this.ticketCache.get(id2);
      ticketsOfUserSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addticketSeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITicket proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Ticket"))  proxy1 = this.ticketCache.get(id1);
      ticketSeatSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Cinema getCinema(Integer id){
      return this.cinemaCache.get(id).getTheObject();
   }
   public void addCinemaProxy(CinemaProxy p) throws PersistenceException{
      this.cinemaCache.put(p.getId(), p);
   }
   public Map<Integer,CinemaProxy> getCinemaCache(){
      return this.cinemaCache;
   }
   public Room getRoom(Integer id){
      return this.roomCache.get(id).getTheObject();
   }
   public void addRoomProxy(RoomProxy p) throws PersistenceException{
      this.roomCache.put(p.getId(), p);
   }
   public Map<Integer,RoomProxy> getRoomCache(){
      return this.roomCache;
   }
   public ParquetRow getParquetRow(Integer id){
      return this.parquetRowCache.get(id).getTheObject();
   }
   public void addParquetRowProxy(ParquetRowProxy p) throws PersistenceException{
      this.parquetRowCache.put(p.getId(), p);
   }
   public Map<Integer,ParquetRowProxy> getParquetRowCache(){
      return this.parquetRowCache;
   }
   public MiddleRow getMiddleRow(Integer id){
      return this.middleRowCache.get(id).getTheObject();
   }
   public void addMiddleRowProxy(MiddleRowProxy p) throws PersistenceException{
      this.middleRowCache.put(p.getId(), p);
   }
   public Map<Integer,MiddleRowProxy> getMiddleRowCache(){
      return this.middleRowCache;
   }
   public BackRow getBackRow(Integer id){
      return this.backRowCache.get(id).getTheObject();
   }
   public void addBackRowProxy(BackRowProxy p) throws PersistenceException{
      this.backRowCache.put(p.getId(), p);
   }
   public Map<Integer,BackRowProxy> getBackRowCache(){
      return this.backRowCache;
   }
   public User getUser(Integer id){
      return this.userCache.get(id).getTheObject();
   }
   public void addUserProxy(UserProxy p) throws PersistenceException{
      this.userCache.put(p.getId(), p);
   }
   public Map<Integer,UserProxy> getUserCache(){
      return this.userCache;
   }
   public Seat getSeat(Integer id){
      return this.seatCache.get(id).getTheObject();
   }
   public void addSeatProxy(SeatProxy p) throws PersistenceException{
      this.seatCache.put(p.getId(), p);
   }
   public Map<Integer,SeatProxy> getSeatCache(){
      return this.seatCache;
   }
   public Movie getMovie(Integer id){
      return this.movieCache.get(id).getTheObject();
   }
   public void addMovieProxy(MovieProxy p) throws PersistenceException{
      this.movieCache.put(p.getId(), p);
   }
   public Map<Integer,MovieProxy> getMovieCache(){
      return this.movieCache;
   }
   public MovieShow getMovieShow(Integer id){
      return this.movieShowCache.get(id).getTheObject();
   }
   public void addMovieShowProxy(MovieShowProxy p) throws PersistenceException{
      this.movieShowCache.put(p.getId(), p);
   }
   public Map<Integer,MovieShowProxy> getMovieShowCache(){
      return this.movieShowCache;
   }
   public Ticket getTicket(Integer id){
      return this.ticketCache.get(id).getTheObject();
   }
   public void addTicketProxy(TicketProxy p) throws PersistenceException{
      this.ticketCache.put(p.getId(), p);
   }
   public Map<Integer,TicketProxy> getTicketCache(){
      return this.ticketCache;
   }
   public TicketState getTicketState(Integer id){
      return this.ticketStateCache.get(id).getTheObject();
   }
   public void addTicketStateProxy(TicketStateProxy p) throws PersistenceException{
      this.ticketStateCache.put(p.getId(), p);
   }
   public Map<Integer,TicketStateProxy> getTicketStateCache(){
      return this.ticketStateCache;
   }
   public Available getAvailable(Integer id){
      return this.availableCache.get(id).getTheObject();
   }
   public void addAvailableProxy(AvailableProxy p) throws PersistenceException{
      this.availableCache.put(p.getId(), p);
   }
   public Map<Integer,AvailableProxy> getAvailableCache(){
      return this.availableCache;
   }
   public Booked getBooked(Integer id){
      return this.bookedCache.get(id).getTheObject();
   }
   public void addBookedProxy(BookedProxy p) throws PersistenceException{
      this.bookedCache.put(p.getId(), p);
   }
   public Map<Integer,BookedProxy> getBookedCache(){
      return this.bookedCache;
   }
   public Reserved getReserved(Integer id){
      return this.reservedCache.get(id).getTheObject();
   }
   public void addReservedProxy(ReservedProxy p) throws PersistenceException{
      this.reservedCache.put(p.getId(), p);
   }
   public Map<Integer,ReservedProxy> getReservedCache(){
      return this.reservedCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Calculates an income
 */
   public Integer income(){
      // TODO: Implement Operation income
      return 1;
   }
//90 ===== GENERATED: End of Your Operations ======
}

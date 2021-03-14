/**--- Generated at Sun Mar 14 13:03:40 CET 2021 
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
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Iterator;

//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class CinemaService extends Observable{
   DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,CinemaProxy> cinemaCache;
   private Map<Integer,RoomProxy> roomCache;
   private Map<Integer,MovieProxy> movieCache;
   private Map<Integer,MovieShowProxy> movieShowCache;
   private Map<Integer,RoomRowProxy> roomRowCache;
   private Map<Integer,RowCategoryProxy> rowCategoryCache;
   private Map<Integer,SeatProxy> seatCache;
   private Map<Integer,TicketProxy> ticketCache;
   private Map<Integer,UserProxy> userCache;
   private Map<Integer,AvailableProxy> availableCache;
   private Map<Integer,ReservedProxy> reservedCache;
   private Map<Integer,BookedProxy> bookedCache;
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
      this.movieCache = new InitialProxyLoader<MovieProxy>("generated", "CinemaService", "cinemaService", "Movie", "HasIncome").perform();
      this.movieShowCache = new InitialProxyLoader<MovieShowProxy>("generated", "CinemaService", "cinemaService", "MovieShow", "HasIncome").perform();
      this.roomRowCache = new InitialProxyLoader<RoomRowProxy>("generated", "CinemaService", "cinemaService", "RoomRow", "RoomRow").perform();
      this.rowCategoryCache = new InitialProxyLoader<RowCategoryProxy>("generated", "CinemaService", "cinemaService", "RowCategory", "RowCategory").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "CinemaService", "cinemaService", "Seat", "Seat").perform();
      this.ticketCache = new InitialProxyLoader<TicketProxy>("generated", "CinemaService", "cinemaService", "Ticket", "TicketAction").perform();
      this.userCache = new InitialProxyLoader<UserProxy>("generated", "CinemaService", "cinemaService", "User", "User").perform();
      this.availableCache = new InitialProxyLoader<AvailableProxy>("generated", "CinemaService", "cinemaService", "Available", "TicketAction").perform();
      this.reservedCache = new InitialProxyLoader<ReservedProxy>("generated", "CinemaService", "cinemaService", "Reserved", "TicketAction").perform();
      this.bookedCache = new InitialProxyLoader<BookedProxy>("generated", "CinemaService", "cinemaService", "Booked", "TicketAction").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("movies").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmoviesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("roomes").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addroomesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movieShowsOfRoom").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmovieShowsOfRoomElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rowsOfRoom").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "RoomRow", "CinemaService");
         try{this.addrowsOfRoomElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movieOfMovieShow").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "HasIncome", "CinemaService");
         try{this.addmovieOfMovieShowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("movieShowToTicket").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "HasIncome", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "TicketAction", "CinemaService");
         try{this.addmovieShowToTicketElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rowToCategory").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "RoomRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "RowCategory", "CinemaService");
         try{this.addrowToCategoryElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rowToSeats").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "RoomRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addrowToSeatsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("ticketToSeat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "TicketAction", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addticketToSeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("TicketsOfUser").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "TicketAction", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "User", "CinemaService");
         try{this.addTicketsOfUserElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("TicketToState").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "TicketAction", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "TicketAction", "CinemaService");
         try{this.addTicketToStateElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addmoviesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; IMovie proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = this.cinemaCache.get(id1);
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      moviesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addroomesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; IRoom proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = this.cinemaCache.get(id1);
      if(className2.equals("Room"))  proxy2 = this.roomCache.get(id2);
      roomesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addmovieShowsOfRoomElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoom proxy1 = null; IMovieShow proxy2 = null; 
      if(className1.equals("Room"))  proxy1 = this.roomCache.get(id1);
      if(className2.equals("MovieShow"))  proxy2 = this.movieShowCache.get(id2);
      movieShowsOfRoomSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addrowsOfRoomElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoom proxy1 = null; IRoomRow proxy2 = null; 
      if(className1.equals("Room"))  proxy1 = this.roomCache.get(id1);
      if(className2.equals("RoomRow"))  proxy2 = this.roomRowCache.get(id2);
      rowsOfRoomSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addmovieOfMovieShowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IMovieShow proxy1 = null; IMovie proxy2 = null; 
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      if(className1.equals("MovieShow"))  proxy1 = this.movieShowCache.get(id1);
      movieOfMovieShowSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addmovieShowToTicketElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IMovieShow proxy1 = null; ITicket proxy2 = null; 
      if(className1.equals("MovieShow"))  proxy1 = this.movieShowCache.get(id1);
      if(className2.equals("Ticket"))  proxy2 = this.ticketCache.get(id2);
      movieShowToTicketSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addrowToCategoryElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoomRow proxy1 = null; IRowCategory proxy2 = null; 
      if(className1.equals("RoomRow"))  proxy1 = this.roomRowCache.get(id1);
      if(className2.equals("RowCategory"))  proxy2 = this.rowCategoryCache.get(id2);
      rowToCategorySupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addrowToSeatsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoomRow proxy1 = null; ISeat proxy2 = null; 
      if(className1.equals("RoomRow"))  proxy1 = this.roomRowCache.get(id1);
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      rowToSeatsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addticketToSeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITicket proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Ticket"))  proxy1 = this.ticketCache.get(id1);
      ticketToSeatSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTicketsOfUserElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITicket proxy1 = null; IUser proxy2 = null; 
      if(className1.equals("Ticket"))  proxy1 = this.ticketCache.get(id1);
      if(className2.equals("User"))  proxy2 = this.userCache.get(id2);
      TicketsOfUserSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTicketToStateElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITicket proxy1 = null; ITicketState proxy2 = null; 
      if(className1.equals("Ticket"))  proxy1 = this.ticketCache.get(id1);
      if(className2.equals("Available"))  proxy2 = this.availableCache.get(id2);
      if(className2.equals("Reserved"))  proxy2 = this.reservedCache.get(id2);
      if(className2.equals("Booked"))  proxy2 = this.bookedCache.get(id2);
      TicketToStateSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
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
   public RoomRow getRoomRow(Integer id){
      return this.roomRowCache.get(id).getTheObject();
   }
   public void addRoomRowProxy(RoomRowProxy p) throws PersistenceException{
      this.roomRowCache.put(p.getId(), p);
   }
   public Map<Integer,RoomRowProxy> getRoomRowCache(){
      return this.roomRowCache;
   }
   public RowCategory getRowCategory(Integer id){
      return this.rowCategoryCache.get(id).getTheObject();
   }
   public void addRowCategoryProxy(RowCategoryProxy p) throws PersistenceException{
      this.rowCategoryCache.put(p.getId(), p);
   }
   public Map<Integer,RowCategoryProxy> getRowCategoryCache(){
      return this.rowCategoryCache;
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
   public Ticket getTicket(Integer id){
      return this.ticketCache.get(id).getTheObject();
   }
   public void addTicketProxy(TicketProxy p) throws PersistenceException{
      this.ticketCache.put(p.getId(), p);
   }
   public Map<Integer,TicketProxy> getTicketCache(){
      return this.ticketCache;
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
   public Available getAvailable(Integer id){
      return this.availableCache.get(id).getTheObject();
   }
   public void addAvailableProxy(AvailableProxy p) throws PersistenceException{
      this.availableCache.put(p.getId(), p);
   }
   public Map<Integer,AvailableProxy> getAvailableCache(){
      return this.availableCache;
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
   public Booked getBooked(Integer id){
      return this.bookedCache.get(id).getTheObject();
   }
   public void addBookedProxy(BookedProxy p) throws PersistenceException{
      this.bookedCache.put(p.getId(), p);
   }
   public Map<Integer,BookedProxy> getBookedCache(){
      return this.bookedCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
   //80 ===== Editable : Your Operations =============
	/**
	 * Sign Up.
	 */
	public User signIn(String email, String password) throws ModelException {
		try {
			return this.getUserCache().values().stream().filter(user -> user.getEmail().equals(email)).findAny().get()
					.getTheObject();
		} catch (NoSuchElementException e) {
			throw new ModelException(String.format("No User for %s", email));
		}
	}

	/**
	 * Sign Up.
	 * 
	 * @throws Exception
	 */
	public User signUp(String firstName, String lastName, String email, String password) throws ModelException {
		if (this.getUserCache().values().stream().filter(user -> user.getEmail().equals(email)).findAny().isPresent())
			throw new ModelException(String.format("Email %s not available!", email));
		else
			return User.createFresh(firstName, lastName, email, password);
	}

	/**
	 * Returns all cinemas.
	 */
	public Collection<Cinema> getAllCinemas() {
		return this.getCinemaCache().values().stream().map(proxy -> proxy.getTheObject()).collect(Collectors.toList());
	}

	public Integer income() throws ModelException {
		Integer sum = 0;
		for (Iterator<Cinema> iterator = this.getAllCinemas().iterator(); iterator.hasNext();) {
			sum += iterator.next().income();
		}
		return sum;
	}

	/**
	 * Returns all categories.
	 */
	public Collection<RowCategory> getAllRowCategories() throws ModelException {
		return this.getRowCategoryCache().values().stream().map(proxy -> proxy.getTheObject())
				.collect(Collectors.toList());
	}
/**
 * Get All Movies
 */
   public Collection<Movie> getAllMovies()throws ModelException{
      return this.getMovieCache().values().stream().map(proxy -> proxy.getTheObject()).collect(Collectors.toList());
   }
//90 ===== GENERATED: End of Your Operations ======
}

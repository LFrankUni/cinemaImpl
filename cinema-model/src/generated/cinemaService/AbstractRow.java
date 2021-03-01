/**--- Generated at Mon Mar 01 13:45:21 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;

//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import observation.Observable;
import generated.cinemaService.proxies.IAbstractRow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
import db.executer.PersistenceExecuterFactory;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class AbstractRow extends Observable implements java.io.Serializable, IAbstractRow {
	// 30 ===== GENERATED: Attribute Section ======
	private Integer id;
	private String name;
	private Integer priceInCent;
	// 40 ===== Editable : Your Attribute Section ======

	// 50 ===== GENERATED: Constructor ============
	public AbstractRow(Integer id, String name, Integer priceInCent, boolean objectOnly) {
		super();
		this.setId(id);
		this.name = name;
		this.priceInCent = priceInCent;
		if (objectOnly)
			return;
	}
	// 60 ===== Editable : Your Constructors ===========

	// 70 ===== GENERATED: Feature Access =========
	public AbstractRow getTheObject() {
		return this;
	}

	public Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Object o) {
		if (!(o instanceof IAbstractRow))
			return false;
		return ((IAbstractRow) o).getId().equals(this.getId());
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	public Set<Seat> getSeats() throws PersistenceException {
		Set<Seat> result = new HashSet<>();
		for (ISeat i : rowToSeatsSupervisor.getInstance().getSeats(this))
			result.add(i.getTheObject());
		return result;
	}

	public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException {
		rowToSeatsSupervisor.getInstance().add(this, arg);
	}

	public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException {
		return rowToSeatsSupervisor.getInstance().remove(this, arg);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) throws PersistenceException {
		this.name = newName;
		try {
			PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("AbstractRow", "name",
					"'" + newName + "'", this.getId());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public Integer getPriceInCent() {
		return this.priceInCent;
	}

	public void setPriceInCent(Integer newPriceInCent) throws PersistenceException {
		this.priceInCent = newPriceInCent;
		try {
			PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("AbstractRow", "priceInCent",
					newPriceInCent.toString(), this.getId());
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	// 80 ===== Editable : Your Operations =============
	/**
	 * Adds a seat to the row.
	 */
	public void addSeat(Seat seat) throws ModelException {
		this.addToSeats(seat);
	}
//90 ===== GENERATED: End of Your Operations ======
}

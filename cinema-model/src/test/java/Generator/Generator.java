package Generator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import db.executer.PersistenceException;
import generated.test.Class_1;
import generated.test.Class_2;

@TestInstance(Lifecycle.PER_CLASS)
public class Generator {

	@BeforeAll
	public void init() {
		generated.test.Test.getInstance();
	}

	@Test
	public void testConnection() {
		generated.test.Test.getInstance();
	}

	@Test
	public void testFreshCreate() throws PersistenceException {
		Class_1.createFresh(Class_2.createFresh(), true);
	}
	
}

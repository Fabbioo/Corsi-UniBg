import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCounterBeforeClass {

	// Il metodo targhettato con @BeforeClass viene eseguito una sola volta, perciò il contatore viene
	// creato una sola volta e tale contatore viene condiviso tra tutti i metodi. Viene da sè che, in questo
	// semplice caso, il campo n del contatore viene inizializzato una sola volta a 0, ovvero al momento
	// dell'istanziazione dell'oggetto Counter.
	
	static Counter c;
	
	@BeforeClass
	public static void setup() {
		c = new Counter();
	}
	
	@Test
	public void testInc() {
		c.inc();
		c.inc();
		
		assertEquals(1, c.getN());
	}
	
	@Test
	public void testDec() {
		c.dec();
		
		assertTrue(c.getN() == -1);
	}

}

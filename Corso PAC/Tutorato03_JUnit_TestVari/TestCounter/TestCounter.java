import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Suppongo di voler testare l'intera classe Counter.java

class TestCounter {

	@Test
	void testInc() {
		// Costruisco l'oggetto Counter:
		Counter c = new Counter();
		
		// Chiamo il metodo di incremento:
		c.inc();
		c.inc();
		
		// Controllo che l'incremento sia andato a buon fine:
		assertEquals(2, c.getN());
	}

	@Test
	void testDec() {
		// Costruisco l'oggetto Counter:
		Counter c = new Counter();
				
		// Chiamo il metodo di decremento:
		c.dec();
				
		// Controllo che il decremento sia andato a buon fine:
		assertTrue(c.getN() == -1);
	}
	
	@Test
	void testCostruttore() {
		// Costruisco l'oggetto Counter:
		Counter c = new Counter();
		
		// Controllo che quando costruisco un nuovo oggetto Counter, questo abbia il n settato a 0:
		assertEquals(0, c.getN());
		
	}
}

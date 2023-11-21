import static org.junit.Assert.*;

import org.junit.Test;

public class TestCoinBox {

	@Test
	public void testInit() {
		Coinbox cb = new Coinbox();
		assertEquals(0, cb.getMonete());
	}

	@Test
	public void testSingleVend() {
		Coinbox cb = new Coinbox();
		
		// Inserisco due monete:
		cb.addMoneta();
		cb.addMoneta();
		
		// Controllo che il caffè venga erogato:
		assertTrue(cb.erogaCaffe());
		
		// Opzionale: controllo che il credito residuo sia diminuito di 2 monete:
		assertEquals(0, cb.getMonete());
	}
	
	@Test
	public void testNotEnough() {
		Coinbox cb = new Coinbox();
		
		// Inserisco una sola moneta:
		cb.addMoneta();
		
		// Controllo che il caffè non venga erogato:
		assertFalse(cb.erogaCaffe());
		
		// Opzionale: controllo che il credito residuo sia di una sola moneta:
		assertEquals(1, cb.getMonete());
	}
}

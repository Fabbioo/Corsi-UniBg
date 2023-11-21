import static org.junit.Assert.*;

public class PrimoTest {

	@org.junit.Test
	public void test() {
		// Dentro questo metodo posso controllare qualcosa utilizzando dei metodi chiamati "assert".
		assertEquals(3*2, 7);
			// Dentro assertEquals bisogna specificare due valori:
			// 1) quello che si calcola;
			// 2) quello che ci si aspetta.
			// Il valore che ci si aspetta di trovare è anche chiamato "Oracolo" perchè permette di concludere
			// se il test sia andato a buon fine o meno.
	}

}

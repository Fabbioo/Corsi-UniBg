import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCounterParametrico {

	// I test parametrici sono test che vengono scritti una sola volta, ma che vengono eseguiti più volte
	// per un certo numero di valori.

	private int nRipetizioni;
	private int outputAtteso;
	
	public TestCounterParametrico(int nRipetizioni, int outputAtteso) {
		this.nRipetizioni = nRipetizioni;
		this.outputAtteso = outputAtteso;
	}
	
	@Parameters
	public static Collection generaParametri() {
		return Arrays.asList(new Object[][] {{1,1}, {3,3}});
			// La scrittura {{}} indica "coppie di valori".
			// Il primo numero indica il numero di ripetizioni che si voglio svolgere.
			// Il secondo numero indica l'output atteso.
	}
	
	// A questo punto posso sfruttare i due valori all'interno del metodo di sotto.
	
	@Test
	public void testInc() {
		Counter c = new Counter();
		
		for(int i = 0; i < nRipetizioni; i++)
			c.inc();
		
		assertEquals(outputAtteso, c.getN());
	}

}

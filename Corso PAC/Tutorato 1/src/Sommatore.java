
/**
 * The Class Sommatore.
 */
public class Sommatore {

	/** Primo numero */
	int a;
	
	/** Secondo numero */
	int b;
	
	/**
	 * Instantiates a new sommatore.
	 */
	Sommatore() {
		a = b = 0;
	}
	
	/**
	 * Instantiates a new sommatore.
	 *
	 * @param a il primo numero
	 * @param b il secondo numero
	 */
	Sommatore(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Sum numbers.
	 *
	 * @return the int representing the sum
	 */
	int sumNumbers() {
		return a + b;
	}
	
}

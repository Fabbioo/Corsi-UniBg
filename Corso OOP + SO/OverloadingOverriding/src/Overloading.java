
import prog.io.*;

public class Overloading {
	public static void main(String[] args) {
		ConsoleInputManager in = new ConsoleInputManager();
		ConsoleOutputManager out = new ConsoleOutputManager();

		double x = in.readDouble("Numero double: ");
		double z = valoreAssoluto(x); // Il metodo valoreAssoluto applicato ad un valore double restituisce un valore
										// double

		int y = in.readInt("Numero int: ");
		int w = valoreAssoluto(y); // Il metodo valoreAssoluto applicato ad un valore int restituisce un valore int

		out.println("Valore assoluto double: " + z);
		out.println("Valore assoluto int: " + w);
	}

	public static double valoreAssoluto(double x) {
		if (x > 0)
			return x;
		else
			return -x;
	}

	// Overloading: in base al tipo dell'argomento utilizzato nella chiamata, il
	// compilatore riconosce quale metodo dovrà essere eseguito
	public static int valoreAssoluto(int x) {
		if (x > 0)
			return x;
		else
			return -x;
	}
}

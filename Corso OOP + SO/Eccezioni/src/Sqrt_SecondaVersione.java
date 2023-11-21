// In questa seconda versione sfrutto il blocco try-catch a livello del metodo main.

import prog.io.*;

public class Sqrt_SecondaVersione {
	public static void main(String[] args) {
		ConsoleInputManager in = new ConsoleInputManager();
		ConsoleOutputManager out = new ConsoleOutputManager();

		int x = in.readInt("Numero: ");

		double y = 0;

		try {
			y = radiceQuadrata(x);
			out.println("\nRadice quadrata: " + y);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static double radiceQuadrata(int x) throws IllegalArgumentException {
		// Le eccezioni vengono lanciate con l'istruzione throw, la quale deve essere
		// posizionata
		// in un metodo che deve essere dichiarato con una clausola throws.
		if (x < 0)
			throw new IllegalArgumentException("Non puoi calcolare la radice quadrata di un numero negativo!");
		else
			return Math.sqrt(x);
	}
}
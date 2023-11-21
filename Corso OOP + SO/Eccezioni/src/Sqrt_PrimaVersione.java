// In questa prima versione sfrutto l'istruzione throws a livello del metodo main.

import prog.io.*;

public class Sqrt_PrimaVersione {
	public static void main(String[] args) throws IllegalArgumentException {
		ConsoleInputManager in = new ConsoleInputManager();
		ConsoleOutputManager out = new ConsoleOutputManager();

		int x = in.readInt("Numero: ");

		double y = radiceQuadrata(x);

		out.println("\nRadice quadrata: " + y);
	}

	// La specifica throws IllegalArgumentException fa sì che il metodo
	// radiceQuadrata deleghi al metodo chiamante, cioè
	// il metodo main, tutte le eccezioni del tipo IllegalArgumentException.
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
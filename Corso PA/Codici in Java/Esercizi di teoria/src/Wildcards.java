import java.util.*;

class FiguraGeometrica {
}

class Quadrato extends FiguraGeometrica {
}

public class Wildcards {

	// Questo primo caso va bene solo per le liste di figure.
	static float calcolaArea1(List<FiguraGeometrica> f) {
		// TODO
		return 0;
	}

	// Questo secondo caso va bene per tutti i tipi generici T che sono
	// FiguraGeometricache o che estendono tale classe.
	static <T extends FiguraGeometrica> float calcolaArea2(List<T> f) {
		// TODO
		return 0;
	}

	// Questo terzo caso va bene per tutti i tipi generici T che sono
	// FiguraGeometricache o che estendono tale classe.
	static float calcolaArea3(List<? extends FiguraGeometrica> f) {
		// TODO
		return 0;
	}

	public static void main(String[] args) {

		// SENZA WILDCARD:

		List<FiguraGeometrica> figuraList1 = new ArrayList<>();

		System.out.println(calcolaArea1(figuraList1));
		// Cerca un metodo calcolaArea che prende un figuraList. Dato che figuraList1 è
		// dichiarata come List<Figura> va bene.

		List<Quadrato> rettangoli;

		// System.out.println(calcolaArea1(rettangoli));
		// In questo caso ottengo errore perchè rettangoli è dichiarata come
		// List<Quadrato> e non lo si può passare laddove è previsto che si
		// riceva in input un List<FiguraGeometrica>.
		// Tra i tipi List<FiguraGeometrica> e List<Quadrato> non vi è alcuna
		// relazione di gerarchia anche se Quadrato è sottoclasse di FiguraGeometrica.
	}
}

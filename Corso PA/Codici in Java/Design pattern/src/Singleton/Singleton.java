package Singleton;

/*
 * Il design pattern Singleton si usa quando si vuole essere certi che di una classe venga creato
 * uno ed un solo oggetto. Una possibile motivazione che può far indurre al suo uso è il fatto che
 * la creazione di oggetti di una determinata classe talvolta può essere particolarmente onerosa.
 */

class Oggetto {

	// Variabile riferimento statica inizialmente settata a null:
	static private Oggetto unicoOggetto = null;

	// Costruttore privato:
	private Oggetto() {
	}

	// Metodo statico per la creazione dell'unico oggetto:
	static public Oggetto creaUnicoOggetto() {
		if (unicoOggetto == null)
			unicoOggetto = new Oggetto();
		return unicoOggetto;
	}

}

public class Singleton {

	public static void main(String[] args) {

		Oggetto l1 = Oggetto.creaUnicoOggetto();
		Oggetto l2 = Oggetto.creaUnicoOggetto();

		/*
		 * La riga 32 NON crea un'altra istanza dell'oggetto Oggetto: l2, in questo
		 * caso, si riferisce all'unico oggetto di classe Oggetto ammesso. In altre
		 * parole, l1 e l2 sono due variabili riferimento che puntano allo stesso
		 * oggetto della classe Oggetto.
		 */

		// Prova della veridicità:
		System.out.println(l1 == l2);
	}
}

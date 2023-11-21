
class Studente {
	
	int matricola;
	
	Studente(int m) {
		this.matricola = m;
	}
	
	// Overloading del metodo equals() di Object:
	public boolean equals(Studente s) { // Si parla di overloading perchè è stata cambiata la segnatura.
		return this.matricola == s.matricola;
	}
}

public class UsoEquals {

	public static void main(String[] args) {
		
		/*
		 * Nota a margine:
		 * _ l'operatore == restituisce TRUE solo se le due variabili riferimento puntano ad uno stesso oggetto.
		 * _ il metodo equals(..) restituisce TRUE se il contenuto delle variabili coinvolte nel confronto
		 * è il medesimo.
		 * 
		 * Ricapitolando:
		 * _ l'operatore == guarda ai riferimenti;
		 * _ il metodo equals(..) guarda al contenuto degli oggetti.
		 */
		
		Studente s1 = new Studente(007);
		Studente s2 = new Studente(007);
		
		System.out.println(s1.equals(s2));
		/*
		 * Comportamento in early binding (compile-time):
		 * si cerca un metodo equals(Studente) all'interno della classe Studente dato che s1 è un oggetto
		 * della classe Studente. Dato che è presente, viene selezionato.
		 * Attenzione. Gli oggetti della classe Studente dispongono di due metodi equals: uno proprio
		 * della classe Studente (overloading del metodo equals della classe Object) e uno ereditato
		 * dalla classe Object dato che Object è superclasse di qualunque classe. Dei due candidati
		 * viene selezionato quello derivante dall'overloading perchè tra i due è quello più specifico.
		 * 
		 * Comportamento in late binding (run-time): 
		 * s1 è una variabile riferimento che punta ad un oggetto di classe Studente, quindi si cerca in
		 * Studente un metodo equals(Studente) CHE ABBIA UNA SEGNATURA IDENTICA A QUELLA DEL METODO 
		 * SELEZIONATO IN EARLY BINDING. Il metodo è presente e viene effettivamente eseguito.
		 * 
		 * Stampa: TRUE perchè il metodo equals(Studente), per come è stato impostato, confronta i valori
		 * dei campi matricola e non a cosa puntano le variabili riferimento s1 e s2.
		 * 
		 * Se il metodo equals(Persona) avesse avuto una implementazione di questo tipo:
		 * 			public boolean equals(Studente s) { return this == s; }
		 * allora l'output sarebbe stato FALSE perchè il metodo equals(Studente), facendo uso dell'operatore
		 * == avrebbe confrontato i riferimenti delle variabili s1 ed s2. Dato che sono state eseguite
		 * due diverse new, allora in memoria è stata forzata la creazione di due oggetti diversi.
		 * Conseguenza di ciò è che le due variabili riferimento s1 ed s2 puntano a due oggetti differenti,
		 * anche se i due oggetti contengono gli stessi valori per il campo matricola.
		 */
		
		Object o = new Studente(007);
		System.out.println(s1.equals(o));
		/*
		 * Comportamento in early binding (compile-time):
		 * si cerca all'interno della classe Studente un metodo equals(Object). Il metodo è presente
		 * perchè la classe Studente lo eredita dalla classe Object, dunque viene selezionato (il discorso
		 * è sempre lo stesso: la classe Object è superclasse di qualunque classe e il metodo equals()
		 * definito nella classe Studente ne fa solo l'overloading).
		 * 
		 * Comportamento in late binding (run-time):
		 * s1 è una variabile riferimento che punta ad un oggetto di classe Studente, quindi si cerca in
		 * Studente un metodo equals(Object). Attenzione: il metodo che viene eseguito è un metodo che
		 * presenta la medesima segnatura di quello selezionato in early binding! è questo il motivo per cui
		 * in late binding si cerca un equals(Object) e non un equals(Studente), seppur la variabile
		 * riferimento o in late binding punti ad un oggetto di classe Studente!. Il metodo è ovviamente
		 * presente e viene eseguito.
		 * 
		 * Stampa: FALSE per il medesimo motivo riportato nella precedente risposta.
		 */
		
		Object o1 = new Studente(123);
		Object o2 = new Studente(123);
		System.out.println(o1.equals(o2));
		/*
		 * Commenti analoghi ai due precedenti.
		 */
		
		
	}
}

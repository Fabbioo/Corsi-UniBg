public class CodaGenerica<E>
{
	// Definisco la struttura di ciascun nodo della coda:
	class Nodo
	{
		// Ciascun nodo è caratterizzato da:
		E dato;		      // Un campo informativo di tipo E.
		Nodo next;        // Un puntatore al nodo successivo.
	}

	// Per evitare di scandire la coda ogni volta che bisogna aggiungere un nuovo nodo, considero due riferimenti:
	// il primo (che chiamo 'primo') che punta al primo elemento, mentre l'altro (che chiamo 'ultimo') che punta all'ultimo.
	private Nodo cima;
	private Nodo coda;

	// Il metodo aggiungi() si occupa dell'inserimento in coda di un nuovo elemento.
	public void aggiungi(E e) 		  // Il parametro e di tipo E contiene un riferimento all'oggetto da inserire nella coda.
	{
		Nodo t = new Nodo(); 		  // Creo un nuovo nodo da inserire in coda.
		t.dato = e;
		t.next = null;
		if(cima == null)	    	  // Se la coda è vuota, ambedue i campi primo e ultimo contengono null ...
			cima = coda = t;       	  // ... perciò l'inserimento avviene facendo puntare sia primo sia ultimo al nuovo nodo creato...
		else 						  // ... altrimenti...						
		{							  // ... non bisogna assegnare nulla al campo next del nuovo nodo t perchè il parametro e punta già a null.
			coda.next = t;
			coda = t;
		}
	}

	// Il metodo aggiungiTesta() si occupa di inserire in testa alla coda un nuovo elemento passatogli come parametro.
	public void aggiuntiTesta(E e)
	{
		Nodo t = new Nodo();
		t.dato = e;
		t.next = cima;		
		cima = t;
	}

	// Il metodo preleva() preleva (sgancia) il primo oggetto della coda (cioè l'oggetto in testa alla coda) restituendone il riferimento.
	public E preleva()
	{
		// Se la coda è vuota lancio un'eccezione.
		if(cima == null)
			throw new RuntimeException("La coda è vuota!");
		else
		{
			E risultato = cima.dato;	// Memorizzo in una variabile il valore del campo informativo contenuto nel primo nodo della coda.
			cima = cima.next;			// Elimino (sgancio) dalla coda il primo nodo.
			if(cima == null)			// Controllo se ora la coda è vuota.
				coda = null;
			return risultato;
		}
	}

	public boolean esiste(E e)
	{
		boolean risp = false;
		if(cima == null)
			throw new RuntimeException("La coda è vuota!");
		else
		{
			for(Nodo t = cima; t != null; t = t.next)
				if(t.dato.equals(e))
				{
					risp = true;
					break;
				}
		}
		return risp;
	}
	public String toString()
	{
		String s = "";
		for(Nodo t = cima; t != null; t = t.next)
		{
			if(s.length() > 0) // Condizione non verificata solo al primo giro di for, in quanto s = "" viene contato con lunghezza 0.
				s = s + ", ";
			s = s + t.dato;
		}
		return s;
	}

	public static void main(String[] args)
	{
		CodaGenerica<String> nomi = new CodaGenerica<>();

		nomi.aggiungi("A");
		nomi.aggiungi("B");
		nomi.aggiungi("C");
		nomi.aggiuntiTesta("E");
		nomi.aggiungi("M");
		nomi.aggiungi("V");
		nomi.aggiungi("P");
		nomi.aggiuntiTesta("E");
		nomi.preleva();

		System.out.println("Coda: " + nomi.toString());
		System.out.println("\nEsiste la B? -> " + nomi.esiste("B"));
		System.out.println("Esiste la D? -> " + nomi.esiste("D"));
		System.out.println("Esiste la Z? -> " + nomi.esiste("D"));
	}
}

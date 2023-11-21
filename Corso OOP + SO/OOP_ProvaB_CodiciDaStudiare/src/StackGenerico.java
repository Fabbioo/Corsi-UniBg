public class StackGenerico<E>
{
	// Definisco la struttura di ciascun nodo dello stack.
	class Nodo
	{
		// Ciascun nodo è caratterizzato da:
		E dato;	   // Un campo informativo (indico con E il tipo degli oggetti che voglio memorizzare nello stack).
		Nodo next; // Un puntatore al nodo successivo.
	}

	private Nodo cima;
	//private Nodo coda; // serve per l'inserimento in coda.

	// Il metodo inserisci() aggiunge in cima allo stack l'oggetto e di tipo E passatogli come parametro.
	public void inserisci(E e)
	{
		Nodo t = new Nodo(); 		   // Creo un nuovo nodo per l'oggetto da aggiungere in cima.
		t.dato = e;					   // Assegno il riferimento di e al campo dato del nuovo nodo t.
		// Per collegare il nuovo nodo allo stack si devono seguire due passi:
		t.next = cima;				   // 1) LEGGI BENE: Assegno al campo next del nuovo nodo t il riferimento puntato da cima.
		// [nel caso di aggiunta del primo nodo allo stack, cima punta a null, perciò il primo nuovo nodo punterà a null].
		cima = t;					   // 2) Assegno a cima il riferimento puntato da t.
	}
	
	// Il metodo preleva() restituisce il riferimento all'oggetto che si trova in cima allo stack, eliminandolo (sganciandolo) dallo stack.
	public E preleva()
	{
		if(cima == null) 			 // Se lo stack è vuoto il metodo preleva() deve sollevare l'eccezione EmptyStackException...
			throw new RuntimeException("Lo stack è vuoto");
		else 						 // ... in caso contrario si devono effettuare le seguenti operazioni:
		{
			E risultato = cima.dato; // 1) Memorizzo in una variabile di tipo E il riferimento contenuto nel primo elemento dello stack;
			cima = cima.next;		 // 2) Elimino (sgancio) dallo stack il primo nodo (il nodo in cima allo stack);
			return risultato;		 // 3) Restituire il riferimento.
		}
	}

	// Il metodo isEmpty() ritorna true se lo stack è vuoto, falso altrimenti.
	public boolean isEmpty()
	{
		return cima == null;
	}

	// Il metodo numNodi() restituisce il numero di nodi presenti nello stack.
	public int numNodi()
	{
		int cont = 0;
		for(Nodo t = cima; t != null; t = t.next)
			cont++;
		return cont;
	}

	public String print()
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
		StackGenerico<String> nomi = new StackGenerico<>();

		nomi.inserisci("A"); 
		nomi.inserisci("B");
		nomi.inserisci("C");
		//nomi.preleva();
		nomi.inserisci("P");
		nomi.inserisci("Q");
		nomi.inserisci("R");
		//nomi.preleva();
		//nomi.preleva();
		//nomi.inserisciCoda("Z");
		System.out.println("Stack: " + nomi.print());
		System.out.println("Numero di nodi presenti: " + nomi.numNodi());
	}
}


public class ListaNonGenerica // implementata per il tipo primitivo int
{
	// Definisco la struttura di ciascun nodo della lista:
	private class Nodo
	{
		// Ciascun nodo è caratterizzato da:
		int dato;		// Un campo informativo (indico con E il tipo degli oggetti che voglio memorizzare nello stack).
		Nodo next;  // Un puntatore al nodo successivo.
	}

	private Nodo inizio;

	// Costruttore privo di argomenti che costruisce una lista vuota: la cima deve puntare a null.
	public ListaNonGenerica()
	{
		inizio = null;
	}

	public int trova(int e)
	{
		Nodo nodo = inizio; // Riferimento ausiliario per scandire la lista.
		int posizione = 1;	// Contatore.
		while(nodo != null && nodo.dato < e) // Finchè non giungi alla fine della lista continua a cercare 
		{
			nodo = nodo.next;
			posizione ++;
		}
		if(nodo == null || nodo.dato > e) // Se hai raggiunto la fine della lista vuol dire che non hai trovato alcun elemento
			return 0;
		else
			return posizione;
	}

	public void inserisci(int e)
	{
		// Il metodo è composto di due parti fondamentali:
		// 1) ricerca della posizione in cui effettuare l'inserimento;
		// 2) creazione ed inserimento del nuovo nodo.

		// Prima fase:
		// Il nodo che deve essere inserito in lista si deve trovare in mezzo tra:
		Nodo nodo_post = inizio; // Puntatore al nodo successivo rispetto a quello che deve essere aggiunto.
		Nodo nodo_pre = null;	 // Puntatore al nodo precedente rispetto a quello che deve essere aggiunto.

		// Finchè non giungi alla fine della lista (cioè fino a quando nodo_post != null) continua a scansionarla.
		while(nodo_post != null && nodo_post.dato < e)
		{
			nodo_pre = nodo_post;		// Ad ogni passo della fase di ricerca, nodo_pre fa riferimento al nodo che precede il nodo riferito da nodo_post.
			nodo_post = nodo_post.next; // Assegno a nodo_post il nodo successivo.
		}

		// Seconda fase:
		Nodo nodo = new Nodo();   // Creo il nuovo nodo.
		nodo.dato = e;			  // Aggiorno il campo dato del nuovo nodo con le informazioni contenute nel parametro e.
		nodo.next = nodo_post;	  // Faccio in modo che il nuovo nodo punti a nodo_post.
		if(nodo_pre == null)	  // Se la lista è vuota...
			inizio = nodo;		  // ... l'inserimento avviene in cima alla lista...
		else					  // ... altrimenti ...
			nodo_pre.next = nodo; // ... avviene dopo nodo_pre.
	}

	public String toString()
	{
		String result = "";
		for (Nodo nodo = inizio; nodo != null; nodo = nodo.next)
		{
			if (result.length() > 0)
				result = result + ",";
			result = result + nodo.dato;
		}
		return result;
	}

	public static void main(String[] args) 
	{
		ListaNonGenerica nomi = new ListaNonGenerica();
		nomi.inserisci(5);
		nomi.inserisci(7);
		nomi.inserisci(1);
		nomi.inserisci(4);
		nomi.inserisci(9);
		System.out.println(nomi);
		System.out.println(nomi.trova(6));
		System.out.println(nomi.trova(8));
		System.out.println(nomi.trova(5));
		System.out.println(nomi.trova(7));
	}
}
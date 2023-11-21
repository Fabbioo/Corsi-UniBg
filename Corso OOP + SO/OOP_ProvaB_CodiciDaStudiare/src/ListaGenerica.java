public class ListaGenerica<E extends Comparable<? super E>>
{
	// Definisco la struttura di ciascun nodo della lista.
	private class Nodo
	{
		// Ciascun nodo è caratterizzato da:
		E dato;		// Un campo informativo di tipo E.
		Nodo next;  // Un puntatore al nodo successivo.
	}

	private Nodo cima;

	public void inserisci(E e)
	{
		// Il metodo consta di due fasi fondamentali:
		// 1) ricerca della posizione in cui effettuare l'inserimento;
		// 2) creazione ed inserimento del nuovo nodo.

		// Prima fase:
		// Il nodo che deve essere inserito in lista si deve trovare in mezzo tra:
		Nodo nodo_corrente = cima;   // Puntatore al primo nodo della lista.
		Nodo nodo_pre = null;	 	 // Puntatore al nodo PRECEDENTE rispetto a quello che deve essere aggiunto.

		while(nodo_corrente != null && nodo_corrente.dato.compareTo(e) < 0) // nodo_corrente.dato.compareTo(e) < 0 = il valore da inserire nella lista è maggiore rispetto a quello contenuto nel nodo corrente, perciò proseguo con la scansione della lista.
		{
			nodo_pre = nodo_corrente;			// Ad ogni passo della fase di ricerca, nodo_pre fa riferimento al nodo che precede quello che deve essere inserito nella lista.
			nodo_corrente = nodo_corrente.next; // Assegno a nodo_corrrente il nodo successivo.
		}
		// Concluso il ciclo while, il puntatore:
		// _ nodo_corrente punta al nodo SUCCESSIVO rispetto a quello che deve essere aggiunto;
		// _ nodo_pre      punta al nodo PRECEDENTE rispetto a quello che deve essere aggiunto.
		// In pratica il nuovo nodo deve essere aggiunto tra nodo_pre e nodo_corrente.

		// Seconda fase:
		Nodo nodo = new Nodo();   		// Creo il nuovo nodo.
		nodo.dato = e;			  		// Aggiorno il campo dato del nuovo nodo con le informazioni contenute nel parametro e.
		nodo.next = nodo_corrente;	  	// Faccio in modo che il nuovo nodo punti a nodo_corrente.
		if(nodo_pre == null)	  		// Se la lista è vuota...
			cima = nodo;		  		// ... l'inserimento avviene in cima...
		else					  		// ... altrimenti ...
			nodo_pre.next = nodo; 		// ... avviene dopo nodo_pre.
	}

	// Il metodo cancella() riceve come parametro un riferimento e ed elimina dalla lista la prima occorrenza di un oggetto uguale a quello riferito da e, se presente.
	public void cancella(E e)
	{
		// Passi da seguire:
		// 1) ricerca della posizione dove effettuare la cancellazione;
		// 2) rimozione dell'elemento.

		// Prima fase:
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;

		while(nodo_corrente != null && nodo_corrente.dato.compareTo(e) < 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}

		// Seconda fase:
		if(nodo_corrente != null && nodo_corrente.dato.equals(e))
			if(nodo_pre == null)
				cima = cima.next; // In questo caso, per sganciare il nodo dalla lista basta far puntare inizio al secondo nodo. 
			else
				nodo_pre.next = nodo_corrente.next; // Sgancio dalla lista il nodo riferito da nodo_corrente collegando nodo_pre al successivo nodo di nodo_corrente.
	}

	// Il metodo trova() restituisce l'intero indicante la posizione dell'elemento nella lista.
	public int trova(E e)
	{
		Nodo nodo = cima; // Riferimento ausiliario per scandire la lista.
		int posizione = 1;	// Contatore.
		// Viene scandita la lista contando il numero di nodi attraversati alla ricerca del nodo desiderato.
		// Poichè la lista è ordinata si può terminare la scansione quando si raggiunge:
		// _ la fine della lista;
		// _ un nodo contenente un valore maggiore o uguale a quello cercato.
		while(nodo != null && nodo.dato.compareTo(e) < 0)
		{
			nodo = nodo.next;
			posizione++;
		}
		if(nodo == null || nodo.dato.compareTo(e) > 0)
			return 0;
		else
			return posizione; // Caso in cui nodo.dato.compareTo(e) = 0, cioè è stato trovato un riscontro.
	}

	public String toString()
	{
		String result = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
		{
			if (result.length() > 0)
				result = result + ", ";
			result = result + nodo.dato;
		}
		return result;
	}

	// Il metodo numNodi() conta il numero di nodi presenti nella lista.
	public int numNodi()
	{
		int cont = 0;
		Nodo nodo = cima;
		while(nodo != null)
		{
			cont++;
			nodo = nodo.next;
		}	
		return cont;
	}

	public static void main(String[] args) 
	{
		ListaGenerica<String> nomi = new ListaGenerica<>();
		nomi.inserisci("A");
		nomi.inserisci("B");
		nomi.inserisci("C");
		nomi.inserisci("A");
		nomi.inserisci("M");
		nomi.inserisci("T");
		nomi.inserisci("A");
		nomi.cancella("A");
		nomi.cancella("A");
		System.out.println(nomi);
		System.out.println("\nPosizione di Z: " + nomi.trova("Z"));
		System.out.println("Posizione di A: " + nomi.trova("A"));
		System.out.println("Posizione di D: " + nomi.trova("D"));
		System.out.println("Posizione di T: " + nomi.trova("T"));
		System.out.println("Posizione di N: " + nomi.trova("N"));
	}
}
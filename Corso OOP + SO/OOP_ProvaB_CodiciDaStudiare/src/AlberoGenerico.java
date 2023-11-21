public class AlberoGenerico<E extends Comparable<? super E>> 
{
	// Definisco la struttura di ciascun nodo dell'albero:
	private class Nodo
	{
		E dato;		  		  // Campo destinato a contenere il riferimento all'oggetto da memorizzare nel nodo.
		AlberoGenerico<E> sx; // Riferimento al sottoalbero sinistro.
		AlberoGenerico<E> dx; // Riferimento al sottoalbero destro.
	}
	
	private Nodo root;  // Se root contiene null, l'albero rappresentato è quello vuoto.
						// Se root non contiene null, si riferisce alla radice dell'albero.
	
	// Il metodo inserisci() consente di aggiungere elementi all'albero in maniera ordinata.
	public void inserisci(E e)
	{
		if(root == null) 			    		// Se l'albero è vuoto, aggiungo semplicemente il primo elemento.
		{
			root = new Nodo();					// Creo un nuovo nodo.
			root.dato = e;						// Memorizzo nel campo dato di root il riferimento all'oggetto da inserire.
			root.sx = new AlberoGenerico<E>();	// Associo al nodo un sottoalbero sinistro vuoto.
			root.dx = new AlberoGenerico<E>();	// Associo al nodo un sottoalbero destro vuoto.
		}
		else									// Se l'albero non è vuoto occorre eseguire un inserimento ordinato.
		{
			if(root.dato.compareTo(e) < 0)		// Se il valore della radice è minore del valore da aggiungere all'albero...
				root.dx.inserisci(e);			// ... procedo all'inserimento del nuovo elemento nel sottoalberto di destra...
			else								// ... altrimenti...
				root.sx.inserisci(e);			// ... procedo all'inserimento del nuovo elemento nel sottoalbero di sinistra.
		}
	}

	// Il metodo cerca() cerca nell'albero l'elemento e passatogli come parametro e restituisce un booleano.
	public boolean cerca(E e)
	{
		if(root == null)	// Se l'albero è vuoto, qualunque elemento verrà cercato non verrà trovato.
			return false;
		int cmp = root.dato.compareTo(e);
			// Se il metodo compareTo restituisce:
				// 0 -> le istanze confrontate sono uguali;
				// 1 -> l'istanza sulla quale viene invocato il metodo (root.dato) è maggiore dell'argomento (e);
				// -1 -> l'istanza sulla quale viene invocato il metodo (root.dato) è minore dell'argomento (e).
		if(cmp == 0)
			return true;
		else if(cmp < 0)
			return root.dx.cerca(e);
		else
			return root.sx.cerca(e);
	}

	// Il metodo inserisci() scritto sopra effettua l'inserimento anche se l'oggetto è già presente nell'albero.
	// Il metodo cercaEInserisci() non inserisce un nodo nell'albero se l'oggetto è già presente.
	public void cercaEInserisci(E e)
	{
		boolean risp = cerca(e);											 // Cerco una eventuale corrispondenza di e nell'albero.
		if(risp == false)													 // Se l'elemento da inserire non è stato trovato...
		{
			inserisci(e);													 // ... lo inserisco nell'albero in maniera ordinata...
			System.out.println("Elemento " + e + " correttamente inserito"); // (scritta di debug)
		}
		else																 // ... altrimenti (cioè se risp = true) ...
			System.out.println("L'elemento " + e + " è già presente!"); 	 // ... non lo inserisco (scritta di debug).
	}

	// Metodo che restituisce una stringa che rappresenta il contenuto dell'albero.
	public String toString()
	{
		if(root == null)
			return "";
		String sinistra = root.sx.toString();
		String radice = root.dato.toString();
		String destra = root.dx.toString();
		return sinistra + " " + radice + " " + destra;
	}

	// Il metodo numNodi() conta il numero di nodi che costituiscono l'albero.
	public int numNodi()
	{
		if(root == null)
			return 0;
		else
		{
			int num_nodi_sx = root.sx.numNodi();
			int num_nodi_dx = root.dx.numNodi();
			return num_nodi_sx + num_nodi_dx + 1;
		}
	}

	public static void main(String[] args)
	{
		AlberoGenerico<Integer> vet = new AlberoGenerico<>();
		
		vet.inserisci(4);
		vet.inserisci(9);
		vet.inserisci(1);
		vet.inserisci(2);
		vet.inserisci(6);
		
		System.out.println("Albero: " + vet.toString());
		
		System.out.println("Numero di nodi presenti nell'albero: " + vet.numNodi());
		
		vet.cercaEInserisci(9);
		vet.cercaEInserisci(5);
		vet.cercaEInserisci(5);
		
		System.out.println("Albero: " + vet.toString());
		
		System.out.println("true = trovato; false = non trovato -> " + vet.cerca(3));
		System.out.println("true = trovato; false = non trovato -> " + vet.cerca(4));
		
		System.out.println("Numero di nodi presenti nell'albero: " + vet.numNodi());
	}
}

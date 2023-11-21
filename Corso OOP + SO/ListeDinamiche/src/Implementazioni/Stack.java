package Implementazioni;

public class Stack<E>
{
	class Nodo
	{
		E dato;
		Nodo next;
	}

	private Nodo cima;

	// Il metodo inserisci() aggiunge in cima allo stack l'oggetto e di tipo E passatogli come parametro.
	public void inserisci(E e)
	{
		Nodo t = new Nodo();
		t.dato = e;
		t.next = cima;
		cima = t;
	}
	
	// Il metodo preleva() restituisce il riferimento all'oggetto che si trova in cima allo stack, eliminandolo (sganciandolo) dallo stack.
	public E preleva()
	{
		if(cima == null)
			throw new RuntimeException("Lo stack è vuoto");
		else
		{
			E risultato = cima.dato;
			cima = cima.next;
			return risultato;
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

	// Il metodo print() stampa il contenuto dello stack.
	public String print()
	{
		String s = "";
		for(Nodo t = cima; t != null; t = t.next)
		{
			if(s.length() > 0)
				s = s + ", ";
			s = s + t.dato;
		}
		return s;
	}
}

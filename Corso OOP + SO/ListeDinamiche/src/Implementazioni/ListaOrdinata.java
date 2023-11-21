package Implementazioni;

public class ListaOrdinata<E extends Comparable<? super E>>
{
	private class Nodo
	{
		E dato;
		Nodo next;
	}

	private Nodo cima;

	public void inserisci(E e)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;
		while(nodo_corrente != null && nodo_corrente.dato.compareTo(e) < 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}
		Nodo nodo = new Nodo();
		nodo.dato = e;
		nodo.next = nodo_corrente;
		if(nodo_pre == null)
			cima = nodo;
		else
			nodo_pre.next = nodo;
	}

	// Il metodo cancella() riceve come parametro un riferimento e ed elimina dalla lista la prima occorrenza di un oggetto uguale a quello riferito da e, se presente.
	public void cancella(E e)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;
		while(nodo_corrente != null && nodo_corrente.dato.compareTo(e) < 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}
		if(nodo_corrente != null && nodo_corrente.dato.equals(e))
			if(nodo_pre == null)
				cima = cima.next;
			else
				nodo_pre.next = nodo_corrente.next;
	}

	// Il metodo trova() restituisce l'intero indicante la posizione dell'elemento nella lista.
	public int trova(E e)
	{
		Nodo nodo = cima;
		int posizione = 1;
		while(nodo != null && nodo.dato.compareTo(e) < 0)
		{
			nodo = nodo.next;
			posizione++;
		}
		if(nodo == null || nodo.dato.compareTo(e) > 0)
			return 0;
		else
			return posizione;
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
}
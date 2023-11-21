package Implementazioni;

public class Coda<E>
{
	class Nodo
	{
		E dato;
		Nodo next;
	}

	private Nodo cima;
	private Nodo coda;

	// Il metodo aggiungi() si occupa dell'inserimento in coda di un nuovo elemento.
	public void aggiungi(E e)
	{
		Nodo t = new Nodo();
		t.dato = e;
		t.next = null;
		if(cima == null)
			cima = coda = t;
		else
		{
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
		if(cima == null)
			throw new RuntimeException("La coda è vuota!");
		else
		{
			E risultato = cima.dato;
			cima = cima.next;
			if(cima == null)
				coda = null;
			return risultato;
		}
	}

	// Il metodo esiste() restituisce true se l'elemento cercato è presente nella coda, false altrimenti.
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

	// Il metodo print() stampa il contenuto della coda.
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

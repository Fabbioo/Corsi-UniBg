public class ProvaB_1giugno2018
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> coda = new PriorityQueue<>();

		coda.insert(5,true);
		coda.insert(6,true);
		coda.insert(2,false);
		coda.insert(9,false);
		coda.insert(7,true);
		coda.insert(1,false);

		System.out.println("Coda pre: " + coda.print());

		coda.next();

		System.out.println("Coda post: " + coda.print());
	}
}

class PriorityQueue<E>
{
	class Nodo
	{
		E dato;
		Nodo next;

		Nodo(E e)
		{
			dato = e;
			next = null;
		}
	}

	private Nodo cima;
	private Nodo coda;

	public void insert(E e,boolean val)
	{
		if(val)
			insertInCoda(e);
		else
			insertInTesta(e);
	}

	private void insertInCoda(E e)
	{
		Nodo t = new Nodo(e);
		if(cima == null)
			cima = coda = t;
		else
		{
			coda.next = t;
			coda = t;
		}
	}

	private void insertInTesta(E e)
	{
		Nodo t = new Nodo(e);
		t.next = cima;
		cima = t;
	}

	public E next()
	{
		// Il metodo next() sgancia il primo oggetto della coda (cioè l'oggetto in testa alla coda) restituendone il riferimento.
		if(cima == null)
			throw new RuntimeException("La coda è vuota!");
		E risultato = cima.dato;
		cima = cima.next;
		if(cima == null)
			coda = null;
		return risultato;
	}

	public String print()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
		{
			if(nodo != null)
				s = s + " ";
			s = s + nodo.dato;
		}
		return s;
	}
}

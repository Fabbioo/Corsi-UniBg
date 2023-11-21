public class ProvaA_1giugno2018
{
	public static void main(String[] args)
	{
		Lista<String> lista_prof = new Lista<>();
		Lista<Integer> lista_num = new Lista<>();
		
		lista_prof.insert("Gargantini");
		lista_prof.insert("Coldani");
		lista_prof.insert("Scandurra");
		lista_prof.insert("Re");
		lista_prof.insert("Fassò");
		lista_prof.insert("Garattini");

		System.out.println("Lista pre: " + lista_prof.print());

		lista_prof.remove("Fassò");

		System.out.println("\nLista post: " + lista_prof.print());
		
		lista_num.insert(5);
		lista_num.insert(9);
		lista_num.insert(1);
		lista_num.insert(4);
		lista_num.insert(8);

		System.out.println("\nLista pre: " + lista_num.print());

		lista_num.remove(5);

		System.out.println("\nLista post: " + lista_num.print());
	}
}

class Lista<E extends Comparable<? super E>>
{
	private class Nodo
	{
		E dato;
		Nodo next;
	}

	private Nodo cima;

	public void insert(E e)
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

	public void remove(E e)
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

	public String print()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
		{
			if(s.length() > 0)
				s = s + ", ";
			s = s + nodo.dato;
		}
		return s;
	}
}

public class ProvaB_4luglio2018
{
	public static void main(String[] args)
	{
		ListaOrdinata lista = new ListaOrdinata();
		
		lista.insert("Castellammare");
		lista.insert("Zurigo");
		lista.insert("Ancona");
		lista.insert("Reggio");
		lista.insert("Zante");
		lista.insert("Salerno");
		
		System.out.println("Lista pre: " + lista.print());
		System.out.println("\nNumero di nodi: " + lista.numNodi());
		
		lista.remove(2);
		lista.remove(10);
		
		System.out.println("\nLista post: " + lista.print());
		System.out.println("\nNumero di nodi: " + lista.numNodi());
	}
}

class ListaOrdinata
{
	class Nodo
	{
		String dato;
		Nodo next;
	}

	private Nodo cima;

	public void insert(String str)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;
		
		while(nodo_corrente != null && nodo_corrente.dato.compareTo(str) > 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}
		
		Nodo nodo = new Nodo();
		nodo.dato = str;
		nodo.next = nodo_corrente;
		if(nodo_pre == null)
			cima = nodo;
		else
			nodo_pre.next = nodo;
	}

	public String print()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			s = s + nodo.dato + " ";
		return s;
	}

	public void remove(int X)
	{
		if(X <= numNodi())
		{
			// Se entro in questo if vuol dire che almeno un elemento è presente nella lista.
			int j = 1; 
			Nodo nodo_corrente = cima;
			Nodo nodo_pre = null;
			while(nodo_corrente != null && j < X)
			{
				j++;
				nodo_pre = nodo_corrente;
				nodo_corrente = nodo_corrente.next;
			}
			if(nodo_pre == null)
				cima = cima.next;
			else
				nodo_pre.next = nodo_corrente.next;
		}
		else
		{
			// Non succede niente.
		}
	}
	
	public int numNodi()
	{
		int i = 0;
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			i++;
		return i;
	}
}

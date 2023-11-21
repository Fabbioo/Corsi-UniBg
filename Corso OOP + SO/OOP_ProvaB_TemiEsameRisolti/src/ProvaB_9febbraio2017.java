public class ProvaB_9febbraio2017
{
	public static void main(String[] args)
	{
		ListaInteri li = new ListaInteri();
		
		li.insert(4);
		li.insert(8);
		li.insert(2);
		li.insert(7);
		li.insert(5);
		
		System.out.println("Lista: " + li.toString());
		System.out.println("Somma: " + li.somma());
		System.out.println("Media: " + li.media());
		System.out.println("Massimo: " + li.getMax());
	}
}

class ListaInteri
{
	class Nodo
	{
		Integer dato;
		Nodo next;
	}
	
	private Nodo cima;
	
	public void insert(Integer numero)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;
		
		while(nodo_corrente != null && nodo_corrente.dato.compareTo(numero) < 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}
		
		Nodo nodo = new Nodo();
		nodo.dato = numero;
		nodo.next = nodo_corrente;
		if(nodo_pre == null)
			cima = nodo;
		else
			nodo_pre.next = nodo;
	}
	
	public String toString()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			s = s + nodo.dato + " ";
		return s;
	}
	
	public Integer somma()
	{
		Integer somma = 0;
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			somma = somma + nodo.dato;
		return somma;
	}
	
	public Integer getMax()
	{
		Integer max = Integer.MIN_VALUE;
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			if(nodo.dato > max)
				max = nodo.dato;
		return max;
	}
	
	public float media()
	{
		float somma = somma();
		float num_nodi = numNodi();
		
		float media = somma / num_nodi;
		return media;
	}
	
	private Integer numNodi()
	{
		Integer num_nodi = 0;
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			num_nodi++;
		return num_nodi;
	}
}
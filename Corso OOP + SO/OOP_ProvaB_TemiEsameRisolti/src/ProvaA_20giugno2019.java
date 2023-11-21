public class ProvaA_20giugno2019
{
	public static void main(String[] args)
	{
		ListaPersone lista = new ListaPersone();

		lista.insert(new Persona("Fabio"));
		lista.insert(new Persona("Pippo"));
		lista.insert(new Persona("Andrea"));
		lista.insert(new Persona("Antonella"));
		lista.insert(new Persona("Dario"));
		lista.insert(new Persona("Valerio"));
		lista.insert(new Persona("Amedeo"));
		lista.insert(new Persona("Ermenigildo"));

		System.out.println("Lista: " + lista.print());
		
		System.out.println("\nNumero di persone il cui nome inizia con 'A': " + lista.countNomeIniziaconA());
	}
}

class Persona implements Comparable<Persona>
{
	String nome;

	public Persona(String n)
	{
		this.nome = n;
	}

	public int compareTo(Persona persona)
	{
		return this.nome.compareTo(persona.nome);
	}
}

class ListaPersone
{
	class Nodo
	{
		Persona dato;
		Nodo next;
	}

	private Nodo cima;

	public void insert(Persona pers)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;
		while(nodo_corrente != null && nodo_corrente.dato.nome.compareTo(pers.nome) < 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}
		Nodo nodo = new Nodo();
		nodo.dato = pers;
		nodo.next = nodo_corrente;
		if(nodo_pre == null)
			cima = nodo;
		else
			nodo_pre.next = nodo;
	}

	public String print()
	{
		String str = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
		{
			if(str.length() > 0)
				str = str + ", ";
			str = str + nodo.dato.nome;
		}
		return str;
	}

	public int countNomeIniziaconA()
	{
		int i = 0;
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			if(nodo.dato.nome.charAt(0) == 'A')
				i++;
		return i;
	}
}

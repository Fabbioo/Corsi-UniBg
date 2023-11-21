public class ProvaB_20giugno2019
{
	public static void main(String[] args)
	{
		AlberoPersone lista = new AlberoPersone();

		lista.insert(new Personaa("Fabio"));
		lista.insert(new Personaa("Pippo"));
		lista.insert(new Personaa("Andrea"));
		lista.insert(new Personaa("Antonella"));
		lista.insert(new Personaa("Dario"));
		lista.insert(new Personaa("Valerio"));
		lista.insert(new Personaa("Amedeo"));
		lista.insert(new Personaa("Ermenigildo"));
		lista.insert(new Personaa("Arisa"));
		lista.insert(new Personaa("Moscardelli"));

		System.out.print("Albero: ");
		lista.print();

		System.out.println("\n\nNumero di persone il cui nome inizia con 'A': " + lista.countNomeIniziaconA());
	}
}

class Personaa implements Comparable<Personaa>
{
	String nome;

	public Personaa(String n)
	{
		this.nome = n;
	}

	public int compareTo(Personaa pers)
	{
		return this.nome.compareTo(pers.nome);
	}
}

class AlberoPersone
{
	class Nodo
	{
		Personaa dato;
		AlberoPersone sx;
		AlberoPersone dx;
	}

	private Nodo radice;

	public void insert(Personaa pers)
	{
		if(radice == null)
		{
			radice = new Nodo();
			radice.dato = pers;
			radice.sx = new AlberoPersone();
			radice.dx = new AlberoPersone();
		}
		else
		{
			if(radice.dato.compareTo(pers) < 0)
				radice.dx.insert(pers);
			else
				radice.sx.insert(pers);
		}
	}

	public void print()
	{
		if(radice == null)
			System.out.print("");
		else
		{
			radice.sx.print();
			System.out.print(radice.dato.nome + " ");
			radice.dx.print();
		}
	}

	public int countNomeIniziaconA()
	{
		return countNomeIniziaconA(radice);
	}

	private int countNomeIniziaconA(Nodo nodo)
	{
		int cont = 0;
		if(nodo == null)
			return cont;
		if(nodo.dato.nome.charAt(0) == 'A')
			cont++;
		cont = cont + countNomeIniziaconA(nodo.sx.radice);
		cont = cont + countNomeIniziaconA(nodo.dx.radice);
		return cont;
	}
}

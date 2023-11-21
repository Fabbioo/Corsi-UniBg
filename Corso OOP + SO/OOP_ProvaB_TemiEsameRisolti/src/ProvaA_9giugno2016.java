public class ProvaA_9giugno2016
{
	public static void main(String[] args)
	{
		AlberoStudenti as = new AlberoStudenti();

		as.insert(new Studente(104));
		as.insert(new Studente(105));
		as.insert(new Studente(106));
		as.insert(new Studente(107));
		as.insert(new Studente(108));

		System.out.print("Albero: ");
		as.print();

		System.out.println("\n\nTrovato studente 105? -> " + as.find(105));
		System.out.println("\n\nTrovato studente 109? -> " + as.find(109));
		System.out.println("\n\nTrovato studente 108? -> " + as.find(108));
	}
}

class Studente
{
	int matricola;

	Studente(int matr)
	{
		this.matricola = matr;
	}

	public String toString()
	{
		return String.valueOf(this.matricola);
	}

	public int estraiMatricola()
	{
		return this.matricola;
	}
}

class AlberoStudenti
{
	class Nodo
	{
		Studente dato;
		AlberoStudenti sx;
		AlberoStudenti dx;
	}

	private Nodo radice;

	public void insert(Studente studente)
	{
		if(radice == null)
		{
			radice = new Nodo();
			radice.dato = studente;
			radice.sx = new AlberoStudenti();
			radice.dx = new AlberoStudenti();
		}
		else
		{
			if(radice.dato.estraiMatricola() < studente.estraiMatricola())
				radice.dx.insert(studente);
			else
				radice.sx.insert(studente);
		}
	}
	
	// Il modo con cui ho risolto il problema del find() fa a dir poco schifo, però funziona.
	public String find(int matricola)
	{
		return find(matricola,new StringBuffer("false"));
	}

	private String find(int matricola,StringBuffer str)
	{
		if(radice == null)
			return str.toString();

		if(radice.dato.estraiMatricola() == matricola)
		{
			str.setLength(0);
			str.append("true");
		}

		radice.sx.find(matricola,str);
		radice.dx.find(matricola,str);
		return str.toString();
	}

	public void print()
	{
		if(radice != null)
		{
			radice.sx.print();
			System.out.print(radice.dato.toString() + " ");
			radice.dx.print();
		}
	}
}
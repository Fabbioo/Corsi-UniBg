public class ProvaA_18maggio2019
{
	public static void main(String[] args)
	{
		AlberoAuto AA = new AlberoAuto();

		AA.insert(new Automobile("abca"));
		AA.insert(new Automobile("lmna"));
		AA.insert(new Automobile("uvz"));
		AA.insert(new Automobile("rsta"));
		AA.insert(new Automobile("opq"));
		AA.insert(new Automobile("def"));
		AA.insert(new Automobile("ghia"));

		System.out.print("Albero: "); 
		AA.print();

		System.out.print("\n\n" + AA.countWithA() + " targhe contengono almeno una 'a'");
	}
}

class Automobile implements Comparable<Automobile>
{
	String targa;

	Automobile(String t)
	{
		this.targa = t;
	}

	public int compareTo(Automobile auto)
	{
		return this.targa.compareTo(auto.targa);
	}
}

class AlberoAuto
{
	class Nodo
	{
		Automobile dato;
		AlberoAuto sx;
		AlberoAuto dx;
	}

	private Nodo radice;

	public void insert(Automobile auto)
	{
		if(radice == null)
		{
			radice = new Nodo();
			radice.dato = auto;
			radice.sx = new AlberoAuto();
			radice.dx = new AlberoAuto();
		}
		else
		{
			if(radice.dato.compareTo(auto) < 0)
				radice.dx.insert(auto);
			else
				radice.sx.insert(auto);
		}
	}

	public void print()
	{
		if(radice != null)
		{
			radice.sx.print();
			System.out.print(radice.dato.targa + " ");
			radice.dx.print();
		}
	}

	public int countWithA()
	{
		return countWithA(radice);
	}

	private int countWithA(Nodo nodo)
	{
		int occorrenza_A = 0;
		if(nodo == null)
			return occorrenza_A;

		for(int i = 0; i < nodo.dato.targa.length(); i++)
			if(nodo.dato.targa.charAt(i) == 'a')
			{
				occorrenza_A++;
				break; // Poichè UNA targa può contenere PIù DI UNA 'a', introduco questo break cosicchè una targa contenente più 'a' venga contata una sola volta.
			}		
		occorrenza_A = occorrenza_A + countWithA(nodo.dx.radice);
		occorrenza_A = occorrenza_A + countWithA(nodo.sx.radice);
		return occorrenza_A;
	}
}

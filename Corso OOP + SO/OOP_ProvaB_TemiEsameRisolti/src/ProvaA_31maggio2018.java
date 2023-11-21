public class ProvaA_31maggio2018
{
	public static void main(String[] args)
	{
		AlberoComputer ac = new AlberoComputer();
		
		ac.insert(new Computer(3000));
		ac.insert(new Computer(800));
		ac.insert(new Computer(20));
		ac.insert(new Computer(123));
		ac.insert(new Computer(987));
		ac.insert(new Computer(567));
		
		System.out.print("Albero: ");
		ac.print();
		
		System.out.print("\n\nIl computer più caro è quello che costa " + ac.getMax() + "$");
	}
}

class Computer implements Comparable<Computer>
{
	int costo;
	
	Computer(int c)
	{
		this.costo = c;
	}

	public int compareTo(Computer computer)
	{
		return this.costo - computer.costo;
	}	
	
	public int estraiCosto()
	{
		return this.costo;
	}
	
	public String toString()
	{
		return String.valueOf(this.costo);
	}
}

class AlberoComputer
{
	class Nodo
	{
		Computer dato;
		AlberoComputer sx;
		AlberoComputer dx;
	}
	
	private Nodo radice;
	
	public void insert(Computer computer)
	{
		if(radice == null)
		{
			radice = new Nodo();
			radice.dato = computer;
			radice.sx = new AlberoComputer();
			radice.dx = new AlberoComputer();
		}
		else
		{
			if(radice.dato.compareTo(computer) < 0)
				radice.dx.insert(computer);
			else
				radice.sx.insert(computer);
		}
	}
	
	public void print()
	{
		if(radice != null)
		{
			radice.sx.print();
			System.out.print(radice.dato.estraiCosto() + " ");
			radice.dx.print();
		}
	}
	
	public int getMax()
	{
		return getMax(radice);
	}
	
	private int getMax(Nodo nodo)
	{
		int costo = 0;
		
		if(nodo != null)
		{
			if(nodo.dato.estraiCosto() > costo)
				costo = nodo.dato.estraiCosto();
			getMax(nodo.sx.radice);
			getMax(nodo.dx.radice);
		}
		return costo;
	}
}

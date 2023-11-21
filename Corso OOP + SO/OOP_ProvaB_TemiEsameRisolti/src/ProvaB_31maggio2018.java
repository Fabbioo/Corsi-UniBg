public class ProvaB_31maggio2018
{
	public static void main(String[] args)
	{
		PilaComputer pc = new PilaComputer();

		pc.push(new Computerr(1200));
		pc.push(new Computerr(23));
		pc.push(new Computerr(678));
		pc.push(new Computerr(3456));
		pc.push(new Computerr(123));
		pc.push(new Computerr(90));

		pc.pop();
		pc.pop();

		System.out.println("Trovato il PC con costo 678? -> " + pc.find(678));
		System.out.println("Trovato il PC con costo 1? -> " + pc.find(1));

		System.out.println("Pila: " + pc.print());
	}
}

class Computerr implements Comparable<Computerr>
{
	int costo;

	Computerr(int c)
	{
		this.costo = c;
	}

	public int compareTo(Computerr computer)
	{
		return this.costo - computer.costo;
	}

	public String toString()
	{
		return String.valueOf(this.costo);
	}
	
	public int estraiCosto()
	{
		return this.costo;
	}
}

class PilaComputer
{
	class Nodo
	{
		Computerr dato;
		Nodo next;
	}

	private Nodo cima;

	public void push(Computerr computer)
	{
		Nodo nodo = new Nodo();
		nodo.dato = computer;
		nodo.next = cima;
		cima = nodo;
	}

	public Computerr pop()
	{
		Computerr risultato = cima.dato;
		cima = cima.next;
		return risultato;
	}

	public boolean find(int costo)
	{
		boolean trovato = false;
		
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			if(nodo.dato.estraiCosto() == costo)
				trovato = true;
		
		return trovato;
	}

	public String print()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			s = s + nodo.dato.estraiCosto() + " ";
		return s;
	}
}
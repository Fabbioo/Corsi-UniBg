/**
 * Ogni Fruit ha un nome e una quantità.
 * 
 * OrderedListFruit rappresenta una collezione di frutti gestiti in modo che siano in ordine decrescente di quantità.
 * E' una struttura dinamica non generica.
 * 
 * Ha un metodo insFruit che prende un Fruit e lo inserisce secondo la modalità sopra scritta.
 * Ha un metodo find che, dato il nome del frutto, restituisce true se quel frutto è nella lista, altrimenti false; nel caso
 * in cui la lista sia vuota, solleva eccezione.
 * Ha un metodo toString() che stampa i frutti nella lista.
 * 
 * Scrivi anche un main di prova in cui provi la tua struttura dati. Non fare alcun input con l'utente.
 */
public class ListaFruit
{
	public static void main(String[] args)
	{
		FruitList lista = new FruitList();

		lista.insFruit(new Fruit("kiwi",20));
		lista.insFruit(new Fruit("arance",8));
		lista.insFruit(new Fruit("kaki",13));
		lista.insFruit(new Fruit("banana",88));
		lista.insFruit(new Fruit("mela",37));
		lista.insFruit(new Fruit("pesca",50));

		System.out.println(lista.toString());

		System.out.println("banana?    -> " + lista.find(new Fruit("banana",8)));
		System.out.println("kaki?      -> " + lista.find(new Fruit("kaki",13)));
		System.out.println("albicocca? -> " + lista.find(new Fruit("albicocca",13)));
		System.out.println("arance?    -> " + lista.find(new Fruit("arance",10)));
		System.out.println("anguria?   -> " + lista.find(new Fruit("anguria",1)));
		System.out.println("pompelmo?  -> " + lista.find(new Fruit("pompelmo",250)));
	}
}

class Fruit implements Comparable<Fruit>
{
	String nome;
	int quantita;

	Fruit(String n,int q)
	{
		this.nome = n;
		this.quantita = q;
	}

	public int compareTo(Fruit f)
	{
		return f.quantita - this.quantita; // Poichè i frutti devono essere ordinati in ordine decrescente di quantità, devo scrivere così questa relazione.
	}

	public String toString()
	{
		return nome + ", " + quantita + "\n";
	}
}

class FruitList
{
	class Nodo
	{
		Fruit dato;
		Nodo next;
	}

	private Nodo cima;

	public void insFruit(Fruit f)
	{
		Nodo nodo_corrente = cima;
		Nodo nodo_pre = null;

		while(nodo_corrente != null && nodo_corrente.dato.compareTo(f) > 0)
		{
			nodo_pre = nodo_corrente;
			nodo_corrente = nodo_corrente.next;
		}

		Nodo nodo = new Nodo();
		nodo.dato = f;
		nodo.next = nodo_corrente;

		if(nodo_pre == null)
			cima = nodo;
		else
			nodo_pre.next = nodo;
	}

	public boolean find(Fruit f)
	{
		if(cima == null)
			throw new RuntimeException("La lista è vuota!");

		Nodo nodo = cima;
		boolean trovato = false;

		while(nodo != null)
		{
			if(nodo.dato.nome.equals(f.nome))
			{
				trovato = true;
				break;
			}
			nodo = nodo.next;
		}

		return trovato;
	}

	public String toString()
	{
		String s = "";
		for(Nodo nodo = cima; nodo != null; nodo = nodo.next)
			s = s + nodo.dato.toString();
		return s;
	}
}

public class ProvaA_4luglio2018
{
	public static void main(String[] args)
	{
		AlberoStringhe str_tree = new AlberoStringhe();

		str_tree.insert("Berlino");
		str_tree.insert("Parigi");
		str_tree.insert("Copenaghen");
		str_tree.insert("Lisbona");
		str_tree.insert("Zurigo");
		str_tree.insert("Amsterdam");
		str_tree.insert("Londra");
		str_tree.insert("Dublino");

		System.out.print("Ordine crescente -> "); 
		str_tree.print(true); // uso true per la stampa in ordine crescente

		System.out.print("\n\nOrdine decrescente -> ");
		str_tree.print(false); // uso false per la stampa in ordine decrescente

		System.out.print("\n\nLa più lunga è: " + str_tree.getPiuLunga());
	}
}

class AlberoStringhe
{
	class Nodo
	{
		String dato;
		AlberoStringhe left;
		AlberoStringhe right;
	}

	private Nodo radice;

	public void insert(String str)
	{
		if(radice == null)
		{
			radice = new Nodo();
			radice.dato = str;
			radice.left = new AlberoStringhe();
			radice.right = new AlberoStringhe();
		}
		else
		{
			if(radice.dato.compareTo(str) < 0)
				radice.right.insert(str);
			else
				radice.left.insert(str);
		}
	}

	public void print(boolean val)
	{
		if(val)
			printCrescente();
		else
			printDecrescente();
	}

	private void printCrescente()
	{
		if(radice != null)
		{
			radice.left.printCrescente();
			System.out.print(radice.dato + " ");
			radice.right.printCrescente();
		}
	}

	private void printDecrescente()
	{
		if(radice != null)
		{
			radice.right.printDecrescente();
			System.out.print(radice.dato + " ");
			radice.left.printDecrescente();
		}
	}	

	public String getPiuLunga()
	{
		return getPiuLunga(new StringBuffer(""));
	}

	private String getPiuLunga(StringBuffer str)
	{
		if(radice == null)
			return "";
		if(radice.dato.length() > str.length())
		{
			str.setLength(0);
			str.append(radice.dato);
		}
		radice.right.getPiuLunga(str);
		radice.left.getPiuLunga(str);
		return str.toString();
	}
}

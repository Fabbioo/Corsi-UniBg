package Esame_ListaOrdinata;

/*
 * Definisci una struttura dati ListaOrdinata generica di elementi ordinabili. Ha sottostante
 * un array di Object. Ha i seguenti metodi:
 * _ insert che inserisce nella lista in ordine; se l'array non è abbastanza capiente cosa puoi fare? 
 * _ toString che restituisce una stringa con gli elementi.
 * Prova a fare un main in cui provi con le stringhe.
 * Se hai una classe Person ordinabile e una classe Student sottoclasse di Person, riesci a
 * creare ListaOrdinata di Student?
 */

class ListaOrdinata<T extends Comparable<? super T>> {

	private int DIM;
	private Object[] array;
	private int numElem;

	ListaOrdinata() {
		this.DIM = 5;
		this.array = new Object[DIM];
		this.numElem = 0;
	}

	void insert(T elem) {
		
		// Innanzitutto verifico che il vettore abbia spazio residuo al suo interno.
		// Se non c'è più spazio, creo un nuovo vettore più capiente e copio gli elementi presenti
		// all'interno del vettore più piccolo in quello più capiente appena creato.
		if (numElem == array.length) {
			Object[] newArray = new Object[array.length + DIM];
			for (int i = 0; i < numElem; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		
		// Effettuo un inserimento ordinato.
		int posizione;
		for (posizione = numElem - 1; posizione >= 0; posizione--) {
			if (((T) array[posizione]).compareTo(elem) < 0)
				break;
			array[posizione + 1] = array[posizione];
		}
		array[posizione + 1] = elem;
		
		// Avendo inserito un nuovo elemento, incremento il contatore di elementi presenti.
		numElem++;		
	}
	
	public String toString() {
		String r = "";
		for (int i = 0; i < numElem; i++)
			r += array[i].toString() + " ";
		return r;
	}

}

class Person implements Comparable<Person> {

	private String nome;

	Person(String nome) {
		this.nome = nome;
	}

	public int compareTo(Person o) {
		return this.nome.compareTo(o.nome);
	}

	public String toString() {
		return nome;
	}
}

class Studente extends Person {
	
	private String matricola;

	Studente(String nome, String matricola) {
		super(nome);
		this.matricola = matricola;
	}

	public String toString() {
		return super.toString() + " " + this.matricola;
	}
}

public class Esercizio {

	public static void main(String[] args) {
		
		ListaOrdinata<String> lista = new ListaOrdinata<>();
		lista.insert("Prif");
		lista.insert("Zara");
		lista.insert("Angelo");
		System.out.println(lista.toString());

		ListaOrdinata<Person> listaP = new ListaOrdinata<>();
		listaP.insert(new Person("Prif"));
		listaP.insert(new Person("Zara"));
		listaP.insert(new Person("Angelo"));
		System.out.println(listaP.toString());

		ListaOrdinata<Studente> listaS = new ListaOrdinata<>();
		listaS.insert(new Studente("220", "Zara"));
		listaS.insert(new Studente("333", "Angelo"));
		listaS.insert(new Studente("10", "Prif"));
		System.out.println(listaS.toString());
		
	}
}

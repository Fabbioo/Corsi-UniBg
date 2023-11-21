package Esercizio;

import java.util.List;
import java.util.ArrayList;

class SequenzaOrdinabile<T extends Comparable<? super T>> {
	/*
	 * La classe SequenzaOrdinabile è una classe che accetta in input un parametro
	 * di tipo T che deve essere comparabile con altri elementi di tipo T o altri
	 * elementi definiti sfruttando una superclasse di T.
	 */

	private List<T> array;

	SequenzaOrdinabile() {
		this.array = new ArrayList<>();
	}

	void insert(T elemento) {
		array.add(elemento);
	}

	void bubbleSort() {

		T temp;
		boolean scambiato;

		do {
			scambiato = false;
			for (int i = 1; i < array.size(); i++) {
				if (array.get(i - 1).compareTo(array.get(i)) > 0) {
					temp = array.get(i - 1);
					array.set(i - 1, array.get(i));
					array.set(i, temp);
					scambiato = true;
				}
			}
		} while (scambiato);
	}

	// Opzione 1:
	void stampa() {
		for (int i = 0; i < array.size(); i++)
			System.out.print(array.get(i).toString() + " ");
	}

	// Opzione 2:
	public String toString() {
		return array + "";
	}
}

class Persona implements Comparable<Persona> {

	private String nome;

	public String getNome() {
		return nome;
	}

	public int compareTo(Persona o) {
		if (this.nome.compareTo(o.getNome()) < 0)
			return -1;
		else if (this.nome.compareTo(o.getNome()) == 0)
			return 0;
		else
			return 1;
	}
}

class Studente extends Persona {
}

public class ExeSequenzaOrdinabile {

	public static void main(String[] args) {

		SequenzaOrdinabile<String> nomi = new SequenzaOrdinabile<>();

		nomi.insert("Fabbio");
		nomi.insert("Andrea");
		nomi.insert("Matteo");
		nomi.insert("Zanna");
		nomi.insert("Crise");
		nomi.insert("Stella");

		System.out.print("Pre ordinamento:");
		System.out.print("\n\tMetodo stampa -> ");
		nomi.stampa();
		System.out.print("\n\tMetodo toString -> " + nomi.toString());

		nomi.bubbleSort();

		System.out.print("\n\nPost ordinamento:");
		System.out.print("\n\tMetodo stampa -> ");
		nomi.stampa();
		System.out.print("\n\tMetodo toString -> " + nomi.toString());

		SequenzaOrdinabile<Studente> miaClasse;
		// La riga 99 funziona solo perchè è presente il <? super T> all'interno del
		// prototipo: class SequenzaOrdinabile<T extends Comparable<? super T>>

		/*
		 * Risposta alla domanda del testo: in SequenzaOrdinabile è stato dichiarato T
		 * extends Comparable<T> -> è stato utilizzato T sia a sx di extends sia dentro
		 * il Comparable: ciò che deve essere messo dentro il diamante di
		 * SequenzaOrdinabile deve essere Comparable rispetto a istanze del suo stesso
		 * tipo, ma Studente non è Comparable di Studente, bensì di Persona. Volendo
		 * rendere accettabile la dichiarazione bisogna modificare la segnatura in:
		 * class SequenzaOrdinabile<T extends Comparable<? super T>>
		 * In questo modo si dice che il tipo generico T sia Comparable rispetto a tipi
		 * della stessa classe T oppure rispetto a tipi di superclassi di T.
		 */

	}
}

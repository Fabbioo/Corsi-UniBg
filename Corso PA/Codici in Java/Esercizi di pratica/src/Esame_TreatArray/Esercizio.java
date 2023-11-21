package Esame_TreatArray;

import java.util.List;
import java.util.ArrayList;

class TreatArray<E extends Comparable<? super E>> {

	private List<E> vettore;

	TreatArray() {
		this.vettore = new ArrayList<>();
	}

	void insert(E e) {
		vettore.add(e);
	}

	E getMax() {
		E max = vettore.get(0);
		for (int i = 0; i < vettore.size(); i++)
			if (vettore.get(i).compareTo(max) > 0)
				max = vettore.get(i);
		return max;
	}
	
	// Implementazione alternativa per la ricerca del valore massimo.
	E getMax2() {
		bubbleSort();
		return vettore.get(vettore.size() - 1);
	}

	E getMin() {
		E min = vettore.get(0);
		for (int i = 0; i < vettore.size(); i++)
			if (vettore.get(i).compareTo(min) < 0)
				min = vettore.get(i);
		return min;
	}

	// Implementazione alternativa per la ricerca del valore minimo.
	E getMin2() {
		bubbleSort();
		return vettore.get(0);
	}
	
	void bubbleSort() {
		boolean scambiato;
		E temp;
		do {
			scambiato = false;
			for (int i = 1; i < vettore.size(); i++)
				if (vettore.get(i - 1).compareTo(vettore.get(i)) > 0) {
					temp = vettore.get(i - 1);
					vettore.set(i - 1, vettore.get(i));
					vettore.set(i, temp);
					scambiato = true;
				}
		} while (scambiato);
	}

	void stampa() {
		for (int i = 0; i < vettore.size(); i++)
			System.out.print(vettore.get(i) + " ");
	}
	
	// Metodo alternativo per la stampa:
	public String toString() {
		return vettore + "";
	}
	
}

public class Esercizio {

	public static void main(String[] args) {

		TreatArray<Integer> vettore = new TreatArray<>();

		vettore.insert(7);
		vettore.insert(87);
		vettore.insert(12);
		vettore.insert(15);
		vettore.insert(45);

		System.out.print("Vettore non ordinato: "); vettore.stampa();
		System.out.print("\nVettore non ordinato toString: " + vettore.toString());
		
		vettore.bubbleSort();

		System.out.print("\n\nVettore ordinato: "); vettore.stampa();
		System.out.print("\nVettore ordinato toString: " + vettore.toString());
		
		System.out.println("\n\nMax: " + vettore.getMax());
		System.out.println("Min: " + vettore.getMin());

	}

}

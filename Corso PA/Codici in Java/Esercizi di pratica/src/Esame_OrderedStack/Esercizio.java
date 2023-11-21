package Esame_OrderedStack;

class OrderedStack<E extends Comparable<? super E>> {

	private int DIM; // Dimensione dell'array
	private Object[] array;
	private int numElem; // # elementi presenti all'interno dell'array

	OrderedStack() {
		this.DIM = 5;
		this.array = new Object[DIM];
		this.numElem = 0;
	}

	void push(E elemento) {
		// Se l'array in cui voglio aggiungere l'elemento è pieno, lo espando.
		if (numElem == array.length) {
			Object[] newArray = new Object[array.length + DIM];
			for (int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		array[numElem] = elemento;
		numElem++;
	}

	E pop() {
		E elemento = (E) array[numElem - 1];
		numElem--;
		return elemento;
	}

	boolean isEmpty() {
		return numElem == 0;
	}

	public String toString() {
		String r = "";
		for (int i = 0; i < this.numElem; i++)
			r += array[i].toString() + " ";
		return r;
	}

	void bubbleSort() {
		E temp;
		boolean scambiato;
		do {
			scambiato = false;
			for (int i = 1; i < this.numElem; i++) {
				if (((Comparable<? super E>) array[i - 1]).compareTo((E) array[i]) > 0) {
					temp = (E) array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					scambiato = true;
				}
			}
		} while (scambiato);
	}

	// Ricerco il minimo prendendo il primo elemento di un vettore riordinato tramite bubblesort.
	E getMin() {
		bubbleSort();
		return (E) array[0];
	}

	// Ricerco il massimo prendendo l'ultimo elemento di un vettore riordinato tramite bubblesort.
	E getMax() {
		bubbleSort();
		return (E) array[numElem - 1];
	}

}

class Persona implements Comparable<Persona> {

	private String nome;

	String getNome() {
		return nome;
	}

	public int compareTo(Persona o) {
		return this.getNome().compareTo(o.getNome());
	}
}

class Studente extends Persona {}

public class Esercizio {

	public static void main(String[] args) {

		OrderedStack<Integer> os = new OrderedStack<>();

		System.out.println("Array vuoto: " + os.isEmpty());

		System.out.println("\nAggiungo 12.");
		os.push(12);
		System.out.println("Array: " + os.toString());
		
		System.out.println("\nAggiungo 18.");
		os.push(18);
		System.out.println("Array: " + os.toString());

		System.out.println("\nAggiungo 5.");
		os.push(5);
		System.out.println("Array: " + os.toString());

		System.out.println("\nAggiungo 10.");
		os.push(10);
		System.out.println("Array: " + os.toString());

		System.out.println("\nAggiungo 8.");
		os.push(8);
		System.out.println("Array: " + os.toString());
		
		System.out.println("\nArray vuoto: " + os.isEmpty());

		System.out.println("\nValore estratto: " + os.pop());
		System.out.println("Array: " + os.toString());

		System.out.println("\nValore estratto: " + os.pop());
		System.out.println("Array: " + os.toString());

		System.out.println("\nMinimo: " + os.getMin());
		System.out.println("Massimo: " + os.getMax());

		OrderedStack<Studente> oss;
	}

}

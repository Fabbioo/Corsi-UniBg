public class BubbleSortGenerico<E extends Comparable<? super E>> {

	public static void main(String[] args) {
		Integer[] vettore_interi = { 6, 2, 9, 5, 7, 4, 1 };
		ordinaBubbleSort(vettore_interi);
		stampa(vettore_interi);

		String[] vettore_stringhe = { "Fabio", "Beatrice", "Silvia", "Antonio" };
		ordinaBubbleSort(vettore_stringhe);
		stampa(vettore_stringhe);

		int x = 10;
		String u = ricercaDicotomica(vettore_interi, x);
		System.out.println(u);

		String a = "Fabio";
		String g = ricercaDicotomica(vettore_stringhe, a);
		System.out.println(g);
	}

	static <E extends Comparable<? super E>> void ordinaBubbleSort(E[] array) {
		E temp;
		boolean scambiato;
		do {
			scambiato = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1].compareTo(array[i]) > 0) {
					temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					scambiato = true;
				}
			}
		} while (scambiato);
	}

	static <E> void stampa(E[] array) {
		System.out.println("\n\nArray generico ordinato: \n");
		for (int i = 0; i < array.length; i++)
			System.out.print("\t" + array[i] + " ");
	}

	static <T extends Comparable<T>, E extends T> String ricercaDicotomica(E[] array, T indice) {
		int i = 0; // Indice che scorre da sinistra verso destra.
		int j = array.length - 1; // Indice che scorre da destra verso sinistra.
		int m = 0;

		for (;;) // Sfrutto un for infinito per scorrere tutto l'array.
		{
			m = (i + j) / 2; // Calcolo elemento centrale dell'array.
			if (array[m].equals(indice))
				return "\n\nL'elemento cercato " + indice + " è presente nel vettore alla posizione: " + (m + 1) + "!";
			if (array[m].compareTo(indice) < 0)
				i = m + 1;
			else
				j = m - 1;
			if (j < i)
				// Nel momento in cui j < i si configura la situazione per cui l'indice sinistro
				// ha superato la metà e quindi non è stato trovato l'elemento.
				return "\n\nNel vettore non è presente l'elemento " + indice + "!";
		}
	}
}

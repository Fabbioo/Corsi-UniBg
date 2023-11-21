package OrdinamentoVettori;

public class SelectionSort {

	public static <E extends Comparable<? super E>> void selectionSort(E[] array) {

		for (int i = 0; i < array.length - 1; i++) {

			int minimo = i; // Parto dall'i-esimo elemento.

			// All'interno di questo ciclo avviene la selezione (o, più propriamente, lo scambio):
			for (int j = i + 1; j < array.length; j++) {
				// Ogni volta che nell'iterazione si trova un elemento piú piccolo di minimo
				// assegno a minimo tale valore.
				if (array[minimo].compareTo(array[j]) > 0)
					minimo = j;
			}

			// Se minimo è diverso dall'elemento di partenza avviene lo scambio.
			if (minimo != i) {
				E k = array[minimo];
				array[minimo] = array[i];
				array[i] = k;
			}
		}
	}
}

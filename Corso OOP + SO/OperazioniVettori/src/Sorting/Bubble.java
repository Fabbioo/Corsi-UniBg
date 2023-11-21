package Sorting;

public class Bubble {
	static <E extends Comparable<? super E>> void bubbleSort(E[] array) {
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
}

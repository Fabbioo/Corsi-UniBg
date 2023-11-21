import java.util.Arrays;

public class MergeSort {

	// Questo è il metodo che viene chiamato ogni volta che si vuole ordinare un
	// vettore.
	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	// Questo metodo scompone il vettore di partenza nei suoi singoli elementi.
	// In pratica: da 1 vettore di n elementi ottengo n scalari.
	private static void mergeSort(int[] a, int min, int max) // min e max rappresentano rispettivamente la prima e
																// l'ultima posizione del vettore da ordinare.
	{
		if (min == max)
			return;

		// Calcolo il valore dell'indice per suddividere il vettore.
		int middle = (max + min) / 2;

		mergeSort(a, min, middle);

		mergeSort(a, middle + 1, max);

		// Avendo svolto la suddivisione di cui sopra, chiamo il metodo sort() per
		// riordinare tutti gli elementi.
		sort(a, min, middle, max);
	}

	private static void sort(int[] array, int min, int middle, int max) {
		// Questi due indici servono per scorrere i due sottovettori:
		int sx = min; // Indice al primo elemento del primo sottovettore.
		int dx = middle + 1; // Indice al primo elemento del secondo sottovettore.

		// Dichiaro un array TEMPORANEO temp di supporto atto a contenere gli elementi
		// sorted (ordinati).
		// L'obiettivo finale è quello di ricopiare il contenuto di tale vettore nel
		// vettore array.
		int[] temp = new int[max - min + 1];
		// Immaginando di avere un vettore di 9 elementi: max = 8 e min = 0 -> max - min
		// + 1 = 9.
		// In pratica costruisco un nuovo vettore con lo stesso numero di elementi del
		// vettore da ordinare.

		// Ciclo for per riempire il vettore temp con tutti gli elementi in modo
		// ordinato.
		for (int i = 0; i < temp.length; i++)
			// Inserisco elementi nel vettore temp in due casi:
			// 1) se la parte destra è stata copiata tutta: dx > max;
			// 2) l'elemento a sx è minore di quello di dx e sx non è stato ancora copiato:
			// a[sx] < a[dx] && sx <= middle.
			if (dx > max || (array[sx] < array[dx] && sx <= middle)) {
				// copio a[sx] e avanzo sx
				temp[i] = array[sx];
				sx++;
			} else {
				// copio a[dx] e avanzo dx
				temp[i] = array[dx];
				dx++;
			}

		// Ciclo for per copiare tutti gli elementi del vettore temp nel vettore array.
		for (int i = 0; i < temp.length; i++)
			array[i + min] = temp[i];
	}
}

/**
 * Il Selection Sort è un algoritmo di ordinamento decisamente semplice ed intuitivo. L'idea di base è la seguente:
 * _alla prima iterazione viene selezionato il valore piú piccolo dell'intero vettore e viene scambiato con il valore
 *  che in quel momento occupa la prima posizione;
 * _alla seconda iterazione viene selezionato il successivo valore piú piccolo del vettore e viene scambiato con il valore
 *  che in quel momento occupa la seconda posizione;
 * _ecc..., fino a quando tutti gli elementi del vettore non sono collocati nella loro giusta posizione.
 */

public class SelectionSortNonGenerico
{
	public static void main(String[] args)
	{
		int[] valori= {23,556,12,3,2,1,34};
		System.out.println("Array di partenza:");
		stampa(valori);

		selectionSort(valori);

		System.out.println("\n\nArray ordinato:");
		stampa(valori);
	}

	public static void selectionSort(int [] array)
	{
		for(int i = 0; i < array.length - 1; i++) {
			int minimo = i; // Parto dall'i-esimo elemento.

			// All'interno di questo ciclo avviene la selezione (o, più propriamente, lo scambio): 
			for(int j = i + 1; j < array.length; j++) {	
				// Ogni volta che nell'iterazione si trova un elemento piú piccolo di minimo assegno a minimo tale valore.
				if(array[minimo] > array[j])
					minimo = j;
			}

			// Se minimo è diverso dall'elemento di partenza avviene lo scambio.
			if(minimo != i)	{ 
				int k = array[minimo];
				array[minimo]= array[i];
				array[i] = k;
			}
		}
	}

	public static void stampa(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}

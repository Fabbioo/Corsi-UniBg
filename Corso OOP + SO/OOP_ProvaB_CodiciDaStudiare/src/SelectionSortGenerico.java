public class SelectionSortGenerico 
{
	public static void main(String[] args)
	{
		// Vettore di interi
		Integer[] vettore_interi = {23,556,12,3,2,1,34};
		System.out.println("Array di partenza:");
		stampa(vettore_interi);

		selectionSort(vettore_interi);

		System.out.println("\n\nArray ordinato:");
		stampa(vettore_interi);
		
		// Vettore di stringhe
		String[] vettore_stringhe = {"Pippo","Asia","Giacomo","Marco","Paride"};
		System.out.println("\n\nArray di partenza:");
		stampa(vettore_stringhe);
		
		selectionSort(vettore_stringhe);
		
		System.out.println("\n\nArray ordinato:");
		stampa(vettore_stringhe);
	}

	static<E extends Comparable<? super E>> void selectionSort(E[] array)
	{
		for(int i = 0; i < array.length - 1; i++) {
			int minimo = i; // Parto dall'i-esimo elemento.

			// All'interno di questo ciclo avviene la selezione (o, più propriamente, lo scambio): 
			for(int j = i + 1; j < array.length; j++) {	
				// Ogni volta che nell'iterazione si trova un elemento piú piccolo di minimo assegno a minimo tale valore.
				if(array[minimo].compareTo(array[j]) > 0)
					minimo = j;
			}

			// Se minimo è diverso dall'elemento di partenza avviene lo scambio.
			if(minimo != i)	{ 
				E k = array[minimo];
				array[minimo]= array[i];
				array[i] = k;
			}
		}
	}

	static <E> void stampa(E[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}

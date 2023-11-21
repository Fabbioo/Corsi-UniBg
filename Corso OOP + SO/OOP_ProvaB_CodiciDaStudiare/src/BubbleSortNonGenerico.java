public class BubbleSortNonGenerico
{
	public static void main(String[] args)
	{
		int[] vettore_interi = {6,2,9,5,7,4,1};
		ordinaBubbleSort(vettore_interi);
		stampa(vettore_interi);
		int x = 10;	// Elemento da cercare
		System.out.println("\n\nCerco l'elemento: " + x);
		System.out.println(ricercaBinaria(vettore_interi,x));

		String[] vettore_stringhe = {"Fabio","Beatrice","Silvia","Antonio"};
		ordinaBubbleSort(vettore_stringhe);
		stampa(vettore_stringhe);
		String a = "Fabio"; // Elemento da cercare
		System.out.println("\n\nCerco l'elemento: " + a);
		System.out.println(ricercaBinaria(vettore_stringhe,a));
	}

	static void ordinaBubbleSort(int[] vet)
	{
		boolean scambiato;
		do
		{
			scambiato = false;
			for(int i = 0; i < vet.length - 1; i++)
			{
				if (vet[i] > vet[i + 1])
				{
					int temp = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = temp;
					scambiato = true;
				}
			}
		}while(scambiato);
	}

	static void stampa(int[] array)
	{
		System.out.println("Array di interi ordinato: \n");
		for(int i = 0; i < array.length; i++)
			System.out.print("\t" + array[i] + " ");
	}

	public static String ricercaBinaria(int[] array, int x) // x è il numero da ricercare nel vettore array
	{
		int i = 0; 					// Indice che scorre da sinistra verso destra.
		int j = array.length - 1;	// Indice che scorre da destra verso sinistra.

		for (;;) // Sfrutto un for infinito per scorrere tutto l'array.
		{ 
			int m = (i + j) / 2; // Calcolo elemento centrale dell'array.
			if (array[m] == x)   // Se l'elemento in centro è uguale all'elemento da ricercare x, ritorno l'elemento in centro.
				return "L'elemento cercato si trova in posizione: " + (m + 1) + "!";
			if (array[m] < x) 	 // Se l'elemento in centro è più piccolo dell'elemento da ricercare, analizzo la parte destra dell'array.
				i = m + 1;
			else				 // Altrimenti cerco a sinistra perchè è minore dell'elemento in centro.
				j = m - 1;
			if (j < i) 
				// Nel momento in cui j < i si configura la situazione per cui l'indice sinistro 
				// ha superato la metà e quindi non è stato trovato l'elemento.
				return "Nel vettore non è presente l'elemento " + x + "!";
		}
	}

	static void ordinaBubbleSort(String vet[])
	{
		boolean scambiato;
		do
		{
			scambiato = false;
			for (int i = 0; i < vet.length - 1; i++)
			{
				if (vet[i].compareTo(vet[i + 1]) > 0)
				{
					String temp = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = temp;
					scambiato = true;
				}
			}
		} while (scambiato);
	}

	static void stampa(String[] array)
	{
		System.out.println("\n\nArray di stringhe ordinato: \n");
		for(int i = 0; i < array.length; i++)
			System.out.print("\t" + array[i] + " ");
	}

	public static String ricercaBinaria(String[] array, String x) // x è il numero da ricercare nel vettore array
	{
		int i = 0; 					// Indice che scorre da sinistra verso destra.
		int j = array.length - 1;	// Indice che scorre da destra verso sinistra.

		for (;;) // Sfrutto un for infinito per scorrere tutto l'array.
		{ 
			int m = (i + j) / 2; // Calcolo elemento centrale dell'array.
			if (array[m] == x)   // Se l'elemento in centro è uguale all'elemento da ricercare x, ritorno l'elemento in centro.
				return "L'elemento cercato si trova in posizione: " + (m+1) + "!";
			if (array[m].compareTo(x) < 0) 	 // Se l'elemento in centro è più piccolo dell'elemento da ricercare, analizzo la parte destra dell'array.
				i = m + 1;
			else				 // Altrimenti cerco a sinistra perchè è minore dell'elemento in centro.
				j = m - 1;
			if (j < i) 
				// Nel momento in cui j < i si configura la situazione per cui l'indice sinistro 
				// ha superato la metà e quindi non è stato trovato l'elemento.
				return "Nel vettore non è presente l'elemento " + x + "!";
		}
	}
}

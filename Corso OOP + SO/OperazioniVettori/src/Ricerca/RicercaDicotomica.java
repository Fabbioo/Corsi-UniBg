package Ricerca;

public class RicercaDicotomica
{
	static <T extends Comparable<T>, E extends T> boolean ricercaDicotomica(E[] array, T indice)
	{
		int i = 0;
		int j = array.length - 1;
		int m = 0;

		for(;;)
		{
			m = (i + j) / 2;
			if (array[m].equals(indice))   
				return true;
			if (array[m].compareTo(indice) < 0) 	 
				i = m + 1;
			else				 
				j = m - 1;
			if (j < i) 
				return false;
		}
	}
}

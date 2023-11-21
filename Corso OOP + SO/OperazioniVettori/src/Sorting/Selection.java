package Sorting;

public class Selection
{
	static <E extends Comparable<? super E>> void selectionSort(E[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			int minimo = i;

			for(int j = i + 1; j < array.length; j++)	
				if(array[minimo].compareTo(array[j]) > 0)
					minimo = j;

			if(minimo != i)
			{ 
				E k = array[minimo];
				array[minimo]= array[i];
				array[i] = k;
			}
		}
	}
}

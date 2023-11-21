package Sorting;

// NON SONO SICURO CHE FUNZIONI IL METODO sort

public class Merge
{
	static <E extends Comparable<? super E>> void mergeSort(E[] array)
	{
		mergesort(array, 0, array.length - 1);
	}

	private static <E extends Comparable<? super E>> void mergesort(E[] array, int min, int max)
	{
		if (min == max)
			return;
		int middle = (max + min) / 2;
		mergesort(array, min, middle);
		mergesort(array, middle + 1, max);
		sort(array, min, middle, max);
	}

	private static <E extends Comparable<? super E>> void sort(E[] array, int min, int middle, int max)
	{
		int sx = min;
		int dx = middle + 1;
		Object[] temp = new Object[max - min + 1];
		for(int i = 0; i < temp.length; i++)
			if(dx > max || (array[sx].compareTo(array[dx]) < 0 && sx <= middle))
			{
				temp[i] = array[sx];
				sx++;
			}
			else
			{
				temp[i] = array[dx];
				dx++;
			}
		for(int i = 0; i < temp.length; i++)
			array[i + min] = (E) temp[i];
	}
}

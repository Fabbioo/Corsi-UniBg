import java.util.Arrays;

public class ProvaC_31maggio2018
{
	public static void main(String[] args)
	{
		Computerrr[] array = {new Computerrr(5),new Computerrr(8),new Computerrr(1),new Computerrr(7),new Computerrr(4),new Computerrr(9)};
		System.out.println("Vettore da ordinare: " + Arrays.toString(array));
		mergeSort(array);
		System.out.println("\nVettore ordinato: " + Arrays.toString(array));
	}

	public static void mergeSort(Computerrr[] array)
	{
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(Computerrr[] array, int min, int max)
	{
		if(min == max)
			return;

		int middle = (min + max) / 2;

		mergeSort(array, min, middle);
		mergeSort(array, middle + 1, max);

		sort(array, min, middle, max);
	}

	private static void sort(Computerrr[] array, int min, int middle, int max)
	{
		int sx = min;
		int dx = middle + 1;

		Computerrr[] temp = new Computerrr[max - min + 1];

		for(int i = 0; i < temp.length; i++)
			if(dx > max || ((array[sx].compareTo(array[dx]) < 0 && sx <= middle)))
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
			array[i + min] = temp[i];
	}
}

class Computerrr implements Comparable<Computerrr>
{
	int costo;

	Computerrr(int c)
	{
		this.costo = c;
	}

	public int compareTo(Computerrr computer)
	{
		return this.costo - computer.costo;
	}

	public String toString()
	{
		return String.valueOf(this.costo);
	}
}

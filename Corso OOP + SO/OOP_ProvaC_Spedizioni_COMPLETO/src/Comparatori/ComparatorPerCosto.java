package Comparatori;

import java.util.Comparator;
import Spedizioni.Spedizione;

public class ComparatorPerCosto implements Comparator<Spedizione>
{
	public int compare(Spedizione s1, Spedizione s2)
	{
		return Integer.compare((int)s1.costo(), (int)s2.costo());
	}
}

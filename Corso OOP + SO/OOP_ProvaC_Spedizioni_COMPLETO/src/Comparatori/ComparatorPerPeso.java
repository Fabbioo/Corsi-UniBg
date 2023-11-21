package Comparatori;

import java.util.Comparator;
import Spedizioni.Spedizione;

public class ComparatorPerPeso implements Comparator<Spedizione>
{
	public int compare(Spedizione s1, Spedizione s2)
	{
		return Integer.compare((int)s1.getPeso(), (int)s2.getPeso());
	}
}

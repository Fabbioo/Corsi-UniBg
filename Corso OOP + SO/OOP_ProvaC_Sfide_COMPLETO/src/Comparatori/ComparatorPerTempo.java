package Comparatori;

import java.util.Comparator;
import Sfide.Sfida;

public class ComparatorPerTempo implements Comparator<Sfida>
{
	public int compare(Sfida s1, Sfida s2)
	{
		return Integer.compare(Integer.valueOf(s1.getOrario()), Integer.valueOf(s2.getOrario()));
	}
}

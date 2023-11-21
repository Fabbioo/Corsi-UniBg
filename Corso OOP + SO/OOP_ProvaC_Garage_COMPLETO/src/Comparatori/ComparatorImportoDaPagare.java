package Comparatori;

import java.util.Comparator;
import Posti.Posto;

public class ComparatorImportoDaPagare implements Comparator<Posto>
{
	public int compare(Posto p1, Posto p2)
	{
		return Integer.compare(p2.getImporto(), p1.getImporto());
	}
}

package Comparatori;

import java.util.Comparator;
import Pratiche.PraticaLegale;

public class ComparatorPerPriorita implements Comparator<PraticaLegale>
{
	public int compare(PraticaLegale pl1, PraticaLegale pl2)
	{
		return Integer.compare(pl1.priorità(), pl2.priorità());
	}
}

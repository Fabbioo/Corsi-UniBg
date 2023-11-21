package Comparatori;

import java.util.Comparator;
import Posti.Posto;

public class ComparatorTarga implements Comparator<Posto>
{
	public int compare(Posto p1, Posto p2)
	{
		return p1.getVeicolo().getTarga().compareTo(p2.getVeicolo().getTarga());
	}
}

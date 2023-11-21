package Comparatori;

import java.util.Comparator;
import Posti.Posto;

public class ComparatorTempoOccupazione implements Comparator<Posto>
{
	public int compare(Posto p1, Posto p2)
	{
		return p1.getOrarioIngressoVeicolo().compareTo(p2.getOrarioIngressoVeicolo());
	}
}

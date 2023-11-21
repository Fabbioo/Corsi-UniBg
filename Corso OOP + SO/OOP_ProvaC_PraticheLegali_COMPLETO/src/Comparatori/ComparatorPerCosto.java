package Comparatori;

import java.util.Comparator;
import Pratiche.PraticaLegale;

// Definisco un nuovo comparatore affinchè possa essere correttamente implementata la stampa delle pratiche in ordine di costo
public class ComparatorPerCosto implements Comparator<PraticaLegale>
{
	public int compare(PraticaLegale pl1, PraticaLegale pl2)
	{
		return Integer.compare(pl1.costo(), pl2.costo());
	}
}

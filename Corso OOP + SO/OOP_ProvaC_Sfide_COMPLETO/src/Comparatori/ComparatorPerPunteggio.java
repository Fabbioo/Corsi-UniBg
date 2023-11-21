package Comparatori;

import java.util.Comparator;
import Sfide.Sfida;

// Definisco un nuovo comparatore affinchè possa essere correttamente implementata la stampa delle sfide in ordine di punteggio
public class ComparatorPerPunteggio implements Comparator<Sfida>
{
	public int compare(Sfida s1, Sfida s2)
	{
		return Integer.compare(s1.punteggio(), s2.punteggio());
	}
}

package Comparatori;

import java.util.Comparator;
import Audio.Audio;

public class ComparatorPerPeso implements Comparator<Audio>
{
	public int compare(Audio a1, Audio a2)
	{
		return Integer.compare(a1.peso(), a2.peso());
	}
}

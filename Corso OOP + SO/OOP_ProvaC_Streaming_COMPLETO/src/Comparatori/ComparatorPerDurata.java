package Comparatori;

import java.util.Comparator;
import Audio.Audio;

public class ComparatorPerDurata implements Comparator<Audio>
{
	public int compare(Audio a1, Audio a2)
	{
		return a1.getDurataAudio().compareTo(a2.getDurataAudio());
	}
}

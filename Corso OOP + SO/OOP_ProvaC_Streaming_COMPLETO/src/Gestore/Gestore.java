package Gestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import Audio.*;
import Comparatori.*;
import Eccezioni.*;
import prog.io.FileInputManager;
import prog.utili.Orario;

public class Gestore
{
	List<Audio> audio;

	Gestore()
	{
		this.audio = new ArrayList<Audio>();
	}

	// Metodo 1: lettura da file di audio e utenti
	static Gestore caricaAudioDaFile() throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		Gestore g = new Gestore();
		FileInputManager fin = new FileInputManager("streaming.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{
			case "S":
				g.insertAudio(new Singolo(data[1], Orario.parseOrario(data[2]), CategoriaAudio.valueOf(data[3]), GenereAudio.valueOf(data[4]), data[5], data[6]));
				break;
			case "A":
				g.insertAudio(new Album(data[1], Orario.parseOrario(data[2]), CategoriaAudio.valueOf(data[3]), GenereAudio.valueOf(data[4]), Integer.valueOf(data[5])));
				break;
			case "H":
				g.insertAudio(new Live(data[1], Orario.parseOrario(data[2]), CategoriaAudio.valueOf(data[3]), GenereAudio.valueOf(data[4]), data[5]));
				break;
			default:
				break;
			}
		}
		return g;
	}

	// Metodo 2: aggiunta di un audio
	void insertAudio(Audio a)
	{
		audio.add(a);
	}

	// 1^ implementazione del metodo 3: rimozione di un audio dato il suo ID
	/*
	 * Logica di funzionamento: sfrutto un iteratore.
	 * Il fine di tutto ciò è evitare l'eccezione ConcurrentModificationException.
	 */ 
	boolean removeAudio(String ID)
	{
		boolean trovato = false;
		Iterator<Audio> iter = audio.iterator();
		while(iter.hasNext())
		{
			Audio audio = iter.next();
			if(audio.getID().equals(ID))
			{
				trovato = true;
				iter.remove();
				break;
			}
		}
		return trovato;
	}

	// 2^ implementazione del metodo 3: rimozione di un audio dato il suo ID
	/*
	 * Logica di funzionamento: 
	 * 1) aggiungo ad un altro ArrayList (che chiamo audioDaRimuovere) tutti gli elementi che devono essere eliminati;
	 * 2) sfrutto il metodo removeAll() sull'ArrayList audio passandogli in input l'ArrayList contenente gli audio da eliminare.
	 * Il fine di tutto ciò è evitare l'eccezione ConcurrentModificationException.
	 */
	//boolean removeAudio(String ID)
	//{
	//	boolean trovato = false;
	//	List<Audio> audioDaRimuovere = new ArrayList<Audio>();
	//	for(Audio a: audio)
	//		if(a.getID().equals(ID))
	//		{
	//			trovato = true;
	//			audioDaRimuovere.add(a);
	//		}
	//	audio.removeAll(audioDaRimuovere);
	//	return trovato;
	//}

	// Metodo 4: stampa di tutti gli audio in ordine di durata
	void stampaOrdineDurata()
	{
		Collections.sort(audio, new ComparatorPerDurata());
		stampa();
	}

	// Metodo 5: stampa di tutti gli audio in ordine di peso
	void stampaOrdinePeso()
	{
		Collections.sort(audio, new ComparatorPerPeso());
		stampa();
	}

	void stampa()
	{
		for(Audio a: audio)
			System.out.println(a);
	}

	// Metodo aggiuntivo: stampa di tutti gli audio in ordine di titolo
	void stampaOrdineTitolo()
	{
		Collections.sort(audio);
		stampa();
	}
}

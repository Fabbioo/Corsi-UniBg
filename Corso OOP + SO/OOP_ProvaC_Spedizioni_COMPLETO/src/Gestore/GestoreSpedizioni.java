package Gestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Comparatori.*;
import Spedizioni.*;
import prog.io.FileInputManager;
import prog.utili.Data;
import prog.utili.Orario;

public class GestoreSpedizioni
{
	List<Spedizione> spedizioni;

	GestoreSpedizioni()
	{
		this.spedizioni = new ArrayList<Spedizione>();
	}

	// 1) Inserimento di una spedizione
	void addSpedizione(Spedizione s)
	{
		spedizioni.add(s);
	}

	// 2) Stampa di tutte le spedizioni in ordine di costo
	void stampaOrdineCosto()
	{
		Collections.sort(spedizioni, new ComparatorPerCosto());
		stampa();
	}

	// 2bis) Stampa di tutte le spedizioni in ordine di peso (OPZIONALE)
	void stampaOrdinePeso()
	{
		Collections.sort(spedizioni, new ComparatorPerPeso());
		stampa();
	}

	// 2tris) Stampa di tutte le spedizioni in ordine di data (OPZIONALE)
	void stampaOrdineData()
	{
		Collections.sort(spedizioni);
		stampa();
	}

	void stampa()
	{
		for(Spedizione s: spedizioni)
			System.out.println(s);
	}

	// 3) Lettura di spedizioni da file
	static GestoreSpedizioni caricaSpedizioniDaFile()
	{
		GestoreSpedizioni gs = new GestoreSpedizioni();
		FileInputManager fin = new FileInputManager("spedizioni.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{
			case "P":
				gs.addSpedizione(new Pacco(new Data(data[1]), data[2], data[3], Float.parseFloat(data[4]), data[5]));
				break;
			case "R":
				gs.addSpedizione(new Raccomandata(new Data(data[1]), data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5])));
				break;
			case "C":
				gs.addSpedizione(new Celere(new Data(data[1]), data[2], data[3], Float.parseFloat(data[4]), Orario.parseOrario(data[5])));
				break;
			default:
				break;
			}
		}
		return gs;
	}
}

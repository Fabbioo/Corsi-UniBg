package Gestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Comparatori.*;
import Pratiche.*;
import prog.io.FileInputManager;
import prog.utili.Data;

public class GestorePratiche
{
	List<PraticaLegale> pratiche;

	GestorePratiche()
	{
		this.pratiche = new ArrayList<PraticaLegale>();
	}

	// 1) Inserimento di una pratica
	void insert(PraticaLegale pl)
	{
		pratiche.add(pl);
	}

	// 2) Stampa delle pratiche in ordine di priorità
	void stampaInOrdinePriorità()
	{
		Collections.sort(pratiche, new ComparatorPerPriorita());
		stampa();
	}

	// 3) Stampa delle pratiche in ordine di costo
	void stampaInOrdineCosto()
	{
		Collections.sort(pratiche, new ComparatorPerCosto());
		stampa();
	}

	void stampa()
	{
		for(PraticaLegale pl: pratiche)
			System.out.println(pl);
	}

	// 4) Stampa delle pratiche archiviate in ordine di costo
	void stampaArchiviateInOrdineCosto()
	{
		Collections.sort(pratiche, new ComparatorPerCosto());
		for(PraticaLegale pl: pratiche)
			if(pl.statoPratica() == StatoPratica.ARCHIVIATA)
				System.out.println(pl);
	}

	// 5) Caricamento da file delle pratiche
	static GestorePratiche caricaPraticheDaFile()
	{
		GestorePratiche gp = new GestorePratiche();
		FileInputManager fin = new FileInputManager("pratiche.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{	
			case "CIV":
				gp.insert(new PraticaCivile(data[1], data[2], Data.parseData(data[3]), Integer.parseInt(data[4]), StatoPratica.valueOf(data[5]), GradoGiudizio.valueOf(data[6])));
				break;
			case "PEN":
				gp.insert(new PraticaPenale(data[1], data[2], Data.parseData(data[3]), Integer.parseInt(data[4]), StatoPratica.valueOf(data[5]), GradoGiudizio.valueOf(data[6])));
				break;
			case "CON":
				gp.insert(new Conciliazione(data[1], data[2], Data.parseData(data[3]), StatoPratica.valueOf(data[4]), Integer.parseInt(data[5])));
				break;
			default:
				break;
			}
		}
		return gp;
	}
}

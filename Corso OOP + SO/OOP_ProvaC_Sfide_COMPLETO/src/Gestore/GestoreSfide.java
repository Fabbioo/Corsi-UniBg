package Gestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Comparatori.*;
import Eccezioni.*;
import Sfide.*;
import prog.io.FileInputManager;
import prog.utili.Orario;

public class GestoreSfide
{
	List<Sfida> sfide;

	GestoreSfide()
	{
		this.sfide = new ArrayList<Sfida>();
	}

	// 1) Lettura da file di alcune sfide
	static GestoreSfide caricaSfideDaFile() throws OrarioNonValidoException
	{
		GestoreSfide gs = new GestoreSfide();
		FileInputManager fin = new FileInputManager("sfide.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{	
			case "C":
				gs.insert(new SfidaCompetizione(data[1], data[2], data[3], data[4], new Orario(data[5]), TipologiaSfida.valueOf(data[6]), Integer.parseInt(data[7])));
				break;
			case "N":
				gs.insert(new SfidaNormale(data[1], data[2], data[3], data[4], Orario.parseOrario(data[5]), TipologiaSfida.valueOf(data[6]), data[7]));
				break;
			case "P":
				gs.insert(new SfidaPacifica(data[1], data[2], data[3], data[4], new Orario(data[5]), TipologiaSfida.valueOf(data[6])));
				break;
			default:
				break;
			}
		}
		return gs;
	}

	void stampa()
	{
		for(Sfida s: sfide)
			System.out.println(s);
	}

	// 2) Inserimento di una nuova sfida
	void insert(Sfida s)
	{
		sfide.add(s);
	}

	// 3) Stampa delle sfide in ordine di tempo
	void stampaOrdineTempo()
	{
		Collections.sort(sfide, new ComparatorPerTempo());
		stampa();
	}

	// 4) Stampa delle sfide in ordine di punteggio
	void stampaOrdinePunteggio()
	{
		Collections.sort(sfide, new ComparatorPerPunteggio());
		stampa();
	}

	// 5) Ricerca di una sfida in cui il nome di un partecipante sia uno passato in input
	public boolean cercaPartecipante(String nomePartecipante)
	{
		// Se viene trovato un riscontro ritorna true, altrimenti false
		boolean trovato = false;
		for(Sfida s: sfide)
			if(s.get1Partecipante() == nomePartecipante || s.get2Partecipante() == nomePartecipante)
				trovato = true;
		return trovato;
	}
}

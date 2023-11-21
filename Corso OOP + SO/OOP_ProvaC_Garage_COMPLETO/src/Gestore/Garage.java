package Gestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import Comparatori.*;
import Eccezioni.PostoIDPresenteException;
import Posti.*;
import Veicoli.*;
import prog.io.FileInputManager;
import prog.utili.Data;
import prog.utili.Orario;

public class Garage
{
	List<Posto> posti;

	Garage()
	{
		this.posti = new ArrayList<Posto>();
	}

	// Metodo 1: lettura dei posti del garage e delle eventuali occupazioni da file
	static Garage caricaPostiDaFile() throws PostoIDPresenteException
	{
		Garage g = new Garage();
		FileInputManager fin = new FileInputManager("parcheggio.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{
			case "PA":
				g.aggiungiPosto(new PostoAuto(OccupazionePosto.valueOf(data[1]), new Auto(data[2], data[3], data[4]), Data.parseData(data[5]), Orario.parseOrario(data[6])));
				break;
			case "PM":
				g.aggiungiPosto(new PostoMoto(OccupazionePosto.valueOf(data[1]), new Moto(data[2]), Data.parseData(data[3]), Orario.parseOrario(data[4])));
				break;
			case "PF":
				g.aggiungiPosto(new PostoFurgone(OccupazionePosto.valueOf(data[1]), new Furgone(data[2], Integer.valueOf(data[3])), Data.parseData(data[4]), Orario.parseOrario(data[5])));
				break;
			default:
				break;
			}
		}
		return g;
	}

	// Metodo 2: aggiungi un posto al garage
	void aggiungiPosto(Posto posto) throws PostoIDPresenteException
	{
		int i = 0;
		for(Posto p: posti)
			if(posto.getID() != p.getID())
				i++;
		if(i == posti.size())
			posti.add(posto);
		else
			throw new PostoIDPresenteException("Esiste gia' un parcheggio con ID " + posto.getID());
	}

	// Metodo 3: aggiunta di un veicolo in un posto libero
	void aggiungiVeicolo(Veicolo veicolo)
	{
		for(Posto posto: posti)
			if(posto.getOccupazionePosto() == OccupazionePosto.FREE && posto.getVeicolo() == null)
				if((veicolo instanceof Auto && posto instanceof PostoAuto) || (veicolo instanceof Moto && posto instanceof PostoMoto) || (veicolo instanceof Furgone && posto instanceof PostoFurgone))
				{
					posto.postoEmploy(veicolo);
					break;
				}
				else
					System.out.println("Non e' presente un parcheggio idoneo al tipo di veicolo!");
	}

	// Metodo 4: libera un posto data la targa del veicolo che lo occupa (con contestuale eliminazione del posto dal parcheggio)
	String liberaPosto(String targa)
	{
		String stringaDaCostruire = "";
		Iterator<Posto> iter = posti.iterator();
		while(iter.hasNext())
		{
			Posto posto = iter.next();
			if(posto.getVeicolo().getTarga().equals(targa))
			{
				stringaDaCostruire = String.valueOf(posto.calcolaImporto()) + "$";
				iter.remove();
				break;
			}
			else
				stringaDaCostruire = "Il veicolo o non e' presente o e' ancora parcheggiato.";
		}
		return stringaDaCostruire;
	}

	// Metodo 5: stampa l'elenco dei veicoli in ordine del tempo di occupazione
	void stampaOrdineOccupazione()
	{
		Collections.sort(posti, new ComparatorTempoOccupazione());
		stampa();
	}

	// Metodo 6: stampa l'elenco dei posti in ordine di ID con relativa descrizione e la descrizione del veicolo che lo occupa
	void stampaIDDescrizionePostoVeicolo()
	{
		Collections.sort(posti);
		stampa();
	}

	// Metodo 7: stampa l'elenco dei veicoli in ordine decrescente rispetto al prezzo da pagare
	void stampaImportoDaPagare()
	{
		Collections.sort(posti, new ComparatorImportoDaPagare());
		stampa();
	}

	// Metodo 8: stampa l'elenco dei veicoli in ordine di targa, ma raggruppati
	void stampaRaggruppatiOrdineTarga()
	{
		Collections.sort(posti, new ComparatorTarga());
		System.out.println("AUTO:");
		for(Posto p: posti)
			if(p.getVeicolo() instanceof Auto)
				System.out.println(p);
		System.out.println("MOTO:");
		for(Posto p: posti)
			if(p.getVeicolo() instanceof Moto)
				System.out.println(p);
		System.out.println("FURGONI:");
		for(Posto p: posti)
			if(p.getVeicolo() instanceof Furgone)
				System.out.println(p);
	}

	void stampa()
	{
		for(Posto p: posti)
			System.out.println(p);
	}
}

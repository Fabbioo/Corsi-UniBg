package Gestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Eccezioni.*;
import Prenotazioni.*;
import Volo.*;
import prog.io.FileInputManager;
import prog.utili.Data;
import prog.utili.Orario;

public class Aeroporto
{
	List<Volo> voli;

	Aeroporto()
	{
		this.voli = new ArrayList<Volo>();
	}

	// Metodo 1: lettura dei dati di voli e prenotazioni da file
	static Aeroporto caricaVoliDaFile() throws SintassiAeroportoNonCorrettaException, VoloPienoException, IOException
	{
		Aeroporto a = new Aeroporto();
		FileInputManager fin = new FileInputManager("voli.txt");
		List<String> prova = new ArrayList<String>();
		BufferedReader b = new BufferedReader(new FileReader("gruppo.txt"));
		String s = "";
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{
			case "V":
				a.aggiungiVolo(data[1], data[2], Data.parseData(data[3]), Orario.parseOrario(data[4]), Integer.valueOf(data[5]));
				break;
			case "PI":
				a.aggiungiPrenotazione(new PrenotazioneIndividuale(data[1], Integer.valueOf(data[2]), PreferenzaPosto.valueOf(data[3])), Integer.valueOf(data[4]));
				break;
			case "PG":
				for(int i = 0; i < Integer.MAX_VALUE; i++)
				{
					s = b.readLine();
					if(s == null)
						break;
					prova.add(s);
				}
				String[] prova2 = prova.toArray(new String[prova.size()]);
				a.aggiungiPrenotazione(new PrenotazioneGruppo(prova2, Float.parseFloat(data[1])), Integer.valueOf(data[2]));
				break;
			default:
				break;
			}
		}
		return a;
	}

	// Metodo 2: inserimento di un volo
	void aggiungiVolo(String origine, String destinazione, Data dataPartenza, Orario oraPartenza, int numMassimoPasseggeri) throws SintassiAeroportoNonCorrettaException
	{
		voli.add(new Volo(origine, destinazione, dataPartenza, oraPartenza, numMassimoPasseggeri));
	}

	// Metodo 3: inserimento di una prenotazione
	void aggiungiPrenotazione(Prenotazione prenotazione, int ID) throws VoloPienoException
	{
		for(Volo volo: voli)
		{
			if(volo.getNumMassimoPasseggeri() == volo.getNumPrenotazioni())
				throw new VoloPienoException("Il volo " + ID + " e' pieno!");
			// Superati i due controlli, la prenotazione può essere aggiunta al primo volo disponibile
			if(volo.getID() == ID)
			{
				volo.inserisciPrenotazione(prenotazione);
				break;
			}
		}
	}

	// Metodo 4: spostamento di una prenotazione da un volo ad un altro
	void spostaPrenotazione(String IDPrenotazioneDaSpostare, int IDNuovoVolo) throws VoloPienoException
	{
		// Inizialmente cerco a quale volo appartiene la prenotazione che eventualmente deve essere spostata
		Volo src = null;
		Prenotazione prenotazioneDaSpostare = null;
		for(Volo volo: voli)
			for(Prenotazione prenotazione: volo.getPrenotazioni())
				if(prenotazione.getID().equals(IDPrenotazioneDaSpostare))
				{
					src = volo;
					prenotazioneDaSpostare = prenotazione;
				}

		// Successivamente cerco il volo su cui spostare la prenotazione
		for(Volo volo: voli)
			if(volo.getID() == IDNuovoVolo)
				if(volo.getNumMassimoPasseggeri() == volo.getNumPrenotazioni())
					throw new VoloPienoException("Il volo su cui si vuole spostare la prenotazione e' gia' pieno!");
				else
				{
					src.getPrenotazioni().remove(prenotazioneDaSpostare);
					volo.inserisciPrenotazione(prenotazioneDaSpostare);
				}
	}

	// Metodo 5: aggiunta di una persona ad una prenotazione di gruppo
	void aggiungiPersona(String nomePersona, String IDPrenotazioneGruppo)
	{
		for(Volo volo: voli)
			for(Prenotazione prenotazione: volo.getPrenotazioni())
				if(prenotazione.getID().equals(IDPrenotazioneGruppo) && prenotazione instanceof PrenotazioneGruppo)
					((PrenotazioneGruppo) prenotazione).addPersona(nomePersona);
	}

	// Metodo 6: stampa dei voli con relative prenotazioni e costi
	void stampaVoli()
	{
		Collections.sort(voli);
		for(Volo volo: voli)
			System.out.println(volo);
	}

	// Metodo 7: ricerca di un volo tramite sigle di origine o destinazione che non sia ancora pieno
	boolean ricercaVolo(String sigla)
	{
		boolean trovato = false;
		for(Volo volo: voli)
			if(volo.getOrigine().equals(sigla) || volo.getDestinazione().equals(sigla))
			{
				trovato = true;
				break;
			}
		return trovato;
	}
}

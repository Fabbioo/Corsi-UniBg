package Volo;

import prog.utili.Data;
import prog.utili.Orario;
import java.util.ArrayList;
import java.util.List;
import Eccezioni.SintassiAeroportoNonCorrettaException;
import Prenotazioni.Prenotazione;

public class Volo implements Comparable<Volo>
{
	static int numVoliCreati = 0;
	int ID;
	String origine;
	String destinazione;
	Data dataPartenza;
	Orario oraPartenza;
	int numMassimoPasseggeri; // il numero massimo di passeggeri viene stabilito in fase di creazione del volo, mentre il numero effettivo di passeggeri sul volo lo si può ricavare col metodo size()
	List<Prenotazione> prenotazioni;

	public Volo(String origine, String destinazione, Data dataPartenza, Orario oraPartenza, int numMassimoPasseggeri) throws SintassiAeroportoNonCorrettaException
	{
		this(origine, destinazione, dataPartenza, oraPartenza, numMassimoPasseggeri, ++numVoliCreati);
	}

	public Volo(String origine, String destinazione, Data dataPartenza, Orario oraPartenza, int numMassimoPasseggeri, int ID) throws SintassiAeroportoNonCorrettaException
	{
		if(origine.length() > 3)
			throw new SintassiAeroportoNonCorrettaException("Rivedi la sintassi dell'aeroporto di partenza!");
		if(destinazione.length() > 3)
			throw new SintassiAeroportoNonCorrettaException("Rivedi la sintassi dell'aeroporto di arrivo!");
		this.origine = origine;
		this.destinazione = destinazione;
		this.dataPartenza = dataPartenza;
		this.oraPartenza = oraPartenza;
		this.numMassimoPasseggeri = numMassimoPasseggeri;
		this.ID = ID;
		this.prenotazioni = new ArrayList<Prenotazione>();
	}

	public int getID()
	{
		return ID;
	}

	public String getOrigine()
	{
		return origine;
	}

	public String getDestinazione()
	{
		return destinazione;
	}

	public Data getDataPartenza()
	{
		return dataPartenza;
	}

	public Orario getOraPartenza()
	{
		return oraPartenza;
	}

	public int getNumMassimoPasseggeri() // ritorna il numero massimo di passeggeri che il particolare aereo può trasportare
	{
		return numMassimoPasseggeri; 
	}

	public List<Prenotazione> getPrenotazioni()
	{
		return prenotazioni;
	}

	public int getNumPrenotazioni() // ritorna il numero di persone che si sono aggiunte al volo
	{
		return prenotazioni.size(); 
	}

	public void inserisciPrenotazione(Prenotazione prenotazione)
	{
		prenotazioni.add(prenotazione);
	}

	public int compareTo(Volo volo)
	{
		return this.ID - volo.getID();
	}

	public String toString()
	{
		return "ID volo: " + ID + " | Origine: " + origine + " | Destinazione: " + destinazione + " | Data: " + dataPartenza + " | Orario: " + oraPartenza + " | Numero massimo passeggeri: " + numMassimoPasseggeri + " | Numero effettivo passeggeri: " + getNumPrenotazioni();
	}
}

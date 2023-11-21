package Telecamere;

import Eccezioni.*;

public abstract class Telecamera implements Comparable<Telecamera>
{
	static int numTelecamereCreate = 0;
	int ID;
	String descrizione;
	StatoTelecamera statoTelecamera;
	int posizione;

	Telecamera(String descrizione, int posizione)
	{
		this.ID = ++numTelecamereCreate;
		this.descrizione = descrizione;
		this.posizione = posizione;
	}

	public int getID()
	{
		return ID;
	}

	public StatoTelecamera getStatoTelecamera()
	{
		return statoTelecamera;
	}

	public abstract String getTipo();
	public abstract void accendiTelecamera() throws TelecameraNonFunzionanteException;
	public abstract void spegniTelecamera() throws OperazioneNonAmmessaException, TelecameraNonFunzionanteException;
	public abstract void bloccoImmagineTelecamera() throws OperazioneNonAmmessaException, TelecameraNonFunzionanteException;

	public int compareTo(Telecamera telecamera)
	{
		return this.posizione - telecamera.posizione;
	}

	public String toString()
	{
		return "ID: " + ID + " \t| Tipologia: " + getTipo() + " \t| Descrizione: " + descrizione + " \t| Stato: " + statoTelecamera + " \t| Posizione: " + posizione;
	}
}

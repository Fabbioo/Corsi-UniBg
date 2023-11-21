package Telecamere;

import Eccezioni.*;

public class TelecameraSemplice extends Telecamera
{
	String descrizioneCostruttore;

	public TelecameraSemplice(String descrizione, StatoTelecamera statoTelecamera, int posizione, String descrizioneCostruttore) throws TelecameraNonFunzionanteException
	{
		super(descrizione, posizione);
		if(statoTelecamera == StatoTelecamera.BLOCCO)
			throw new TelecameraNonFunzionanteException("Telecamera semplice non funzionante: la telecamera semplice non puo' mai trovarsi nello stato di BLOCCOIMMAGINE!");
		this.statoTelecamera = statoTelecamera;
		this.descrizioneCostruttore = descrizioneCostruttore;
	}

	public String getTipo()
	{
		return "Semplice";
	}
	
	public void accendiTelecamera() throws TelecameraNonFunzionanteException
	{
		if(statoTelecamera == StatoTelecamera.ACCESA)
			System.out.println("La telecamera semplice e' gia' nello stato di ACCESA!");
		else if(statoTelecamera == StatoTelecamera.SPENTA)
			statoTelecamera = StatoTelecamera.ACCESA;
		else
			throw new TelecameraNonFunzionanteException("Telecamera semplice non funzionante: la telecamera semplice non puo' mai trovarsi nello stato di BLOCCOIMMAGINE!");
	}

	public void spegniTelecamera() throws OperazioneNonAmmessaException, TelecameraNonFunzionanteException
	{
		if(statoTelecamera == StatoTelecamera.ACCESA)
			statoTelecamera = StatoTelecamera.SPENTA;
		else if(statoTelecamera == StatoTelecamera.SPENTA)
			System.out.println("La telecamera semplice e' gia' spenta!");
		else
			throw new TelecameraNonFunzionanteException("Telecamera semplice non funzionante: la telecamera semplice non puo' mai trovarsi nello stato di BLOCCOIMMAGINE!");
	}

	public void bloccoImmagineTelecamera() throws TelecameraNonFunzionanteException, OperazioneNonAmmessaException
	{
		if(statoTelecamera == StatoTelecamera.ACCESA || statoTelecamera == StatoTelecamera.SPENTA)
			throw new OperazioneNonAmmessaException("Operazione non ammessa: la telecamera semplice non puo' mai scattare immagini!");
		else
			throw new TelecameraNonFunzionanteException("Telecamera semplice non funzionante: la telecamera non puo' mai trovarsi nello stato di BLOCCOIMMAGINE!");
	}

	public String toString()
	{
		return super.toString() + " \t| Descrizione costruttore: " + descrizioneCostruttore;
	}
}

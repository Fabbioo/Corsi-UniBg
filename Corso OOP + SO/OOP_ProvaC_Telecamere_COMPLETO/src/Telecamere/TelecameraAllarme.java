package Telecamere;

import Eccezioni.*;

public class TelecameraAllarme extends Telecamera
{
	String numTelefonoEmergenza;
	
	public TelecameraAllarme(String descrizione, StatoTelecamera statoTelecamera, int posizione, String numTelefonoEmergenza) throws TelecameraNonFunzionanteException 
	{
		super(descrizione, posizione);
		if(statoTelecamera == StatoTelecamera.SPENTA)
			throw new TelecameraNonFunzionanteException("Telecamera di allarme non funzionante: la telecamera non puo' mai trovarsi nello stato di SPENTA!");
		this.statoTelecamera = statoTelecamera;
		this.numTelefonoEmergenza = numTelefonoEmergenza;
	}

	public String getTipo()
	{
		return "Allarme";
	}
	
	public void accendiTelecamera() throws TelecameraNonFunzionanteException
	{
		if(statoTelecamera == StatoTelecamera.SPENTA)
			throw new TelecameraNonFunzionanteException("Telecamera di allarme non funzionante: la telecamera non puo' mai trovarsi nello stato di SPENTA!");
		else if(statoTelecamera == StatoTelecamera.BLOCCO)
			statoTelecamera = StatoTelecamera.ACCESA;
		else
			System.out.println("La telecamera di allarme e' gia' nello stato di ACCESA!");
	}

	public void spegniTelecamera() throws OperazioneNonAmmessaException, TelecameraNonFunzionanteException
	{
		if(statoTelecamera == StatoTelecamera.ACCESA || statoTelecamera == StatoTelecamera.BLOCCO)
			throw new OperazioneNonAmmessaException("Operazione non ammessa: la telecamera di allarme non puo' mai essere spenta!");
		else
			throw new TelecameraNonFunzionanteException("Telecamera di allarme non funzionante: la telecamera non puo' mai trovarsi nello stato di SPENTA!");
	}

	public void bloccoImmagineTelecamera() throws TelecameraNonFunzionanteException
	{
		if(statoTelecamera == StatoTelecamera.ACCESA)
			statoTelecamera = StatoTelecamera.BLOCCO;
		else if(statoTelecamera == StatoTelecamera.SPENTA)
			throw new TelecameraNonFunzionanteException("Telecamera di allarme non funzionante: la telecamera non puo' mai trovarsi nello stato di SPENTA!");
		else
			System.out.println("La telecamera di allarme e' gia' nello stato di BLOCCOIMMAGINE!");
	}

	public String toString()
	{
		return super.toString() + " \t| Numero emergenza: " + numTelefonoEmergenza;
	}
}

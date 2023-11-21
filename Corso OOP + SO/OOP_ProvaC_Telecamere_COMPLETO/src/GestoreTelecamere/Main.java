package GestoreTelecamere;

import Eccezioni.*;
import Telecamere.*;

public class Main
{
	public static void main(String[] args) throws TelecameraNonFunzionanteException, OperazioneNonAmmessaException, TelecameraIDNonPresenteException
	{
		Gestore g1 = new Gestore();

		g1.aggiungiTelecamera(new TelecameraNormale("Uran", StatoTelecamera.BLOCCO, 25));
		g1.aggiungiTelecamera(new TelecameraNormale("Mart", StatoTelecamera.ACCESA, 17));
		g1.aggiungiTelecamera(new TelecameraNormale("Giov", StatoTelecamera.BLOCCO, 89));
		g1.aggiungiTelecamera(new TelecameraAllarme("Sole", StatoTelecamera.ACCESA, 30, "334562"));
		g1.aggiungiTelecamera(new TelecameraAllarme("Luna", StatoTelecamera.BLOCCO, 20, "12334"));
		g1.aggiungiTelecamera(new TelecameraSemplice("Vene", StatoTelecamera.ACCESA, 12, "Sony"));
		g1.aggiungiTelecamera(new TelecameraSemplice("Plut", StatoTelecamera.ACCESA, 10, "Samsung"));

		System.out.println("Telecamere ordinate in base alla posizione:");
		g1.stampaOrdinePosizione();

		Gestore g2 = Gestore.leggiTelecamereDaFile();

		System.out.println("\nTelecamere lette da file e ordinate in base alla posizione:");
		g2.stampaOrdinePosizione();

		System.out.println("\nLo stato della telecamera con ID 3 e' stato cambiato? -> " + g1.operaTelecamera(3));
		System.out.println("Lo stato della telecamera con ID 7 e' stato cambiato? -> " + g1.operaTelecamera(7));
		System.out.println("Lo stato della telecamera con ID 8 e' stato cambiato? -> " + g2.operaTelecamera(8)); // Lancio appositamente l'eccezione
	}
}

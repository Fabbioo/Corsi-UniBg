package GestoreTelecamere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Eccezioni.*;
import Telecamere.*;
import prog.io.FileInputManager;

public class Gestore
{
	List<Telecamera> telecamere;

	Gestore()
	{
		this.telecamere = new ArrayList<Telecamera>();
	}

	// Metodo 1: aggiunta di una telecamera
	void aggiungiTelecamera(Telecamera telecamera)
	{
		telecamere.add(telecamera);
	}

	// Metodo 2: operazioni su ogni telecamera
	boolean operaTelecamera(int ID) throws OperazioneNonAmmessaException, TelecameraNonFunzionanteException, TelecameraIDNonPresenteException
	{
		int i = 0;
		boolean statoCambiato = false;
		for(Telecamera telecamera: telecamere)
		{
			i++;
			if(telecamera.getID() == ID)
			{
				if(telecamera.getStatoTelecamera() == StatoTelecamera.ACCESA)
				{
					telecamera.spegniTelecamera();
					statoCambiato = true;
					break;
				}
				else if(telecamera.getStatoTelecamera() == StatoTelecamera.SPENTA)
				{
					telecamera.accendiTelecamera();
					statoCambiato = true;
					break;
				}
				else
				{
					// Non succede nulla e restituisco false
				}
			}
			if(i == telecamere.size() + 1) // Se arrivo a questo punto è perchè non è mai stato eseguito uno dei due break
				throw new TelecameraIDNonPresenteException("Non esiste una telecamera con ID " + ID + "!");
		}
		return statoCambiato;
	}

	// Metodo 3: stampa delle telecamere in ordine di posizione con il loro stato
	void stampaOrdinePosizione()
	{
		Collections.sort(telecamere);
		for(Telecamera telecamera: telecamere)
			System.out.println(telecamera);
	}

	// Metodo 4: leggi telecamere da file
	static Gestore leggiTelecamereDaFile() throws TelecameraNonFunzionanteException
	{
		Gestore g = new Gestore();
		FileInputManager fin = new FileInputManager("telecamere.txt");
		for(;;)
		{
			String line = fin.readLine();
			if(line == null)
				break;
			String[] data = line.split(";");
			switch(data[0])
			{
			case "N":
				g.aggiungiTelecamera(new TelecameraNormale(data[1], StatoTelecamera.valueOf(data[2]), Integer.valueOf(data[3])));
				break;
			case "S":
				g.aggiungiTelecamera(new TelecameraSemplice(data[1], StatoTelecamera.valueOf(data[2]), Integer.valueOf(data[3]), data[4]));
				break;
			case "A":
				g.aggiungiTelecamera(new TelecameraAllarme(data[1], StatoTelecamera.valueOf(data[2]), Integer.valueOf(data[3]), data[4]));
				break;
			default:
				break;
			}
		}
		return g;
	}
}

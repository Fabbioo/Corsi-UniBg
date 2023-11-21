package Gestore;

import java.io.IOException;

import Eccezioni.SintassiAeroportoNonCorrettaException;

import Eccezioni.VoloPienoException;
import Prenotazioni.PreferenzaPosto;
import Prenotazioni.PrenotazioneGruppo;
import Prenotazioni.PrenotazioneIndividuale;
import prog.utili.Data;
import prog.utili.Orario;

public class Main
{
	public static void main(String[] args) throws SintassiAeroportoNonCorrettaException, VoloPienoException, NumberFormatException, IOException
	{
		Aeroporto a1 = new Aeroporto();

		a1.aggiungiVolo("Pal", "Nap", new Data("05.01.8000"), new Orario("16:30"), 3);
		a1.aggiungiVolo("Urg", "Cin", new Data("05.01.7000"), new Orario("19:30"), 2);

		a1.aggiungiPrenotazione(new PrenotazioneIndividuale("Deni", 15, PreferenzaPosto.CORRIDOIO), 1);
		a1.aggiungiPrenotazione(new PrenotazioneIndividuale("Franco", 105, PreferenzaPosto.FINESTRINO), 1);
		a1.aggiungiPrenotazione(new PrenotazioneIndividuale("Mandy", 98, PreferenzaPosto.CORRIDOIO), 2);
		//a1.aggiungiPrenotazione(new PrenotazioneIndividuale("Anna", 56, PreferenzaPosto.INDIFFERENTE), 1); // Togliendo il commento verrebbe lanciata l'eccezione del volo pieno

		a1.stampaVoli();

		String[] array = {"Marco", "Jack", "Anna"};
		a1.aggiungiPrenotazione(new PrenotazioneGruppo(array, 20.0f), 2);
		System.out.println();
		a1.stampaVoli();

		System.out.println("\nEsiste il volo che parte da Pal? -> " + a1.ricercaVolo("Pal"));
		System.out.println("Esiste il volo che arriva a Mil? -> " + a1.ricercaVolo("Mil"));

		Aeroporto a2 = Aeroporto.caricaVoliDaFile();

		System.out.println("\nVoli letti da file:");
		a2.stampaVoli();
	}
}

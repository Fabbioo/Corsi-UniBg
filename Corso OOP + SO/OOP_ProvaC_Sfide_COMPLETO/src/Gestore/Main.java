package Gestore;

import prog.utili.Orario;
import Eccezioni.*;
import Sfide.*;

public class Main
{
	public static void main(String[] args) throws OrarioNonValidoException, PunteggioNonValidoException
	{
		GestoreSfide gs1 = new GestoreSfide();

		gs1.insert(new SfidaPacifica("P", "Fifa", "Alice", "Marcolin", new Orario(15,30), TipologiaSfida.AMICHEVOLE));
		gs1.insert(new SfidaNormale("N", "PESS", "Fabio", "Federico", new Orario(18,28), TipologiaSfida.AMICHEVOLE, "Stadio"));
		gs1.insert(new SfidaCompetizione("C", "GTAA", "Danie", "Annalisa", new Orario(12,30), TipologiaSfida.CAMPIONATO, 9));

		System.out.println("Sfide in ordine di orario:");
		gs1.stampaOrdineTempo();

		System.out.println("\nSfide in ordine di punteggio:");
		gs1.stampaOrdinePunteggio();

		GestoreSfide gs2 = GestoreSfide.caricaSfideDaFile();

		System.out.println("\nSfide lette da file:");
		gs2.stampa();

		System.out.println("\nIl player Danie e' presente? -> " + gs1.cercaPartecipante("Danie"));
		System.out.println("Il player Alfredo e' presente? -> " + gs1.cercaPartecipante("Alfredo"));
	}
}

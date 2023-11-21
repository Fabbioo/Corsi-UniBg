package Gestore;

import Spedizioni.*;
import prog.utili.Data;
import prog.utili.Orario;

public class Main
{
	public static void main(String[] args)
	{
		GestoreSpedizioni gs1 = new GestoreSpedizioni();

		gs1.addSpedizione(new Celere(new Data(13,07,2019), "Fabio", "Martha", 12, new Orario(9,30)));
		gs1.addSpedizione(new Raccomandata(new Data(12,07,2019), "Denise", "Andrea", 10, 9));
		gs1.addSpedizione(new Pacco(new Data(14,07,2019), "Stefano", "Marco", 10.5f, "Sony"));
		gs1.addSpedizione(new Raccomandata(new Data(11,07,2019), "Matteo", "Alex", 11, 6));

		System.out.println("Spedizioni in ordine crescente di data:");
		gs1.stampaOrdineData();

		System.out.println("\nSpedizioni in ordine crescente di peso:");
		gs1.stampaOrdinePeso();

		System.out.println("\nSpedizioni in ordine crescente di costo:");
		gs1.stampaOrdineCosto();

		GestoreSpedizioni gs2 = GestoreSpedizioni.caricaSpedizioniDaFile();

		System.out.println("\nSpedizioni lette da file:");
		gs2.stampa();
	}
}

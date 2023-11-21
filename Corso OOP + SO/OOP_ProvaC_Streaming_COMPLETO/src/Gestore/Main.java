package Gestore;

import Audio.*;
import Eccezioni.*;
import prog.utili.Orario;

public class Main
{
	public static void main(String[] args) throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		Gestore g1 = new Gestore();

		g1.insertAudio(new Singolo("Lento", new Orario("02:42"), CategoriaAudio.RK, GenereAudio.EUROPEO, "BoroBoro", "Italia"));
		g1.insertAudio(new Singolo("Bling", new Orario("03:28"), CategoriaAudio.JZ, GenereAudio.AFRICANO, "GuePeque", "Miami"));
		g1.insertAudio(new Live("Felic", new Orario("03:39"), CategoriaAudio.JZ, GenereAudio.AFRICANO, "Sidney"));
		g1.insertAudio(new Album("DarPP",  new Orario("04:25"), CategoriaAudio.CL, GenereAudio.INDIANO, 15));

		System.out.println("Brani in ordine di titolo:");
		g1.stampaOrdineTitolo();

		System.out.println("\nBrani in ordine di durata:");
		g1.stampaOrdineDurata();

		System.out.println("\nBrani in ordine di peso:");
		g1.stampaOrdinePeso();

		System.out.println("\nRimosso audio con ID: S2? -> " + g1.removeAudio("S2"));
		System.out.println("Rimosso audio con ID: P6? -> " + g1.removeAudio("P6"));

		Gestore g2 = Gestore.caricaAudioDaFile();

		System.out.println("\nAudio letti da file:");
		g2.stampa();
	}
}

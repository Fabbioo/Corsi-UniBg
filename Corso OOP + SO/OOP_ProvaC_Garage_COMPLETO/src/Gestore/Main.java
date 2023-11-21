package Gestore;

import Eccezioni.*;
import Posti.*;
import Veicoli.*;
import prog.utili.Data;
import prog.utili.Orario;

public class Main
{
	public static void main(String[] args) throws PostoIDPresenteException, PostoOccupatoException, VeicoloNonPresenteException
	{
		Garage g1 = Garage.caricaPostiDaFile();

		System.out.println("Parcheggio letto da file:");
		g1.stampa();

		Garage g2 = new Garage();

		g2.aggiungiPosto(new PostoAuto(OccupazionePosto.BUSY, new Auto("BL801VC", "Opel", "Astra"), new Data("05.01.9000"), new Orario("15:30")));
		g2.aggiungiPosto(new PostoMoto(OccupazionePosto.BUSY, new Moto("BL850VC"), new Data("05.01.4000"), new Orario("12:30")));
		g2.aggiungiPosto(new PostoFurgone(OccupazionePosto.BUSY, new Furgone("BL802VC", 2000), new Data("05.01.5000"), new Orario("14:30")));
		g2.aggiungiPosto(new PostoAuto(OccupazionePosto.FREE, null, null, null));
		g2.aggiungiPosto(new PostoMoto(OccupazionePosto.FREE, null, null, null));
		g2.aggiungiPosto(new PostoFurgone(OccupazionePosto.FREE, null, null, null));

		g2.aggiungiVeicolo(new Auto("BL809VC", "Merc", "Benzi"));
		g2.aggiungiVeicolo(new Moto("BL806VC"));
		g2.aggiungiVeicolo(new Furgone("BL804VC", 3000));

		System.out.println("\nImporto da pagare per il veicolo di targa BL850VC? -> " + g2.liberaPosto("BL850VC"));
		System.out.println("Importo da pagare per il veicolo di targa BL850VC? -> " + g2.liberaPosto("BL900VC"));

		System.out.println("\nParcheggi inseriti a mano:");
		g2.stampa();

		System.out.println("\nVeicoli in ordine del tempo di occupazione:");
		g2.stampaOrdineOccupazione();

		System.out.println("\nVeicoli in ordine di ID:");
		g2.stampaIDDescrizionePostoVeicolo();

		System.out.println("\nVeicoli in ordine in base all'importo da pagare:");
		g2.stampaImportoDaPagare();

		System.out.println("\nVeicoli raggruppati e stampati in ordine di targa:");
		g2.stampaRaggruppatiOrdineTarga();
	}
}

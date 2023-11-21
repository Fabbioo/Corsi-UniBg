package Gestore;

import Pratiche.*;
import prog.utili.Data;

public class Main
{
	public static void main(String[] args)
	{
		GestorePratiche gp1 = new GestorePratiche();
		
		gp1.insert(new PraticaCivile("Fabioooo", "", new Data(5,7,3019), 10, StatoPratica.ARCHIVIATA, GradoGiudizio.PRIMO));
		gp1.insert(new PraticaPenale("Angelooo", "", new Data(7,7,3019), 20, StatoPratica.ARCHIVIATA, GradoGiudizio.SECONDO));
		gp1.insert(new PraticaCivile("Giacomoo", "", new Data(6,7,3019), 30, StatoPratica.CHIUSA, GradoGiudizio.CASSAZIONE));
		gp1.insert(new PraticaPenale("Federico", "", new Data(4,7,3019), 50, StatoPratica.INCORSO, GradoGiudizio.PRIMO));
		gp1.insert(new Conciliazione("Mandyyyy", "", new Data(8,7,3019), StatoPratica.INCORSO, 12));
		
		System.out.println("Pratiche in ordine di priorita':");
		gp1.stampaInOrdinePriorità();
		
		System.out.println("\nPratiche in ordine di costo:");
		gp1.stampaInOrdineCosto();
		
		System.out.println("\nPratiche archiviate in ordine di costo:");
		gp1.stampaArchiviateInOrdineCosto();
		
		GestorePratiche gp2 = GestorePratiche.caricaPraticheDaFile();
		
		System.out.println("\nPratiche lette da file:");
		gp2.stampa();
	}
}

package Pratiche;

import prog.utili.Data;

public abstract class PraticaLegale implements Comparable<PraticaLegale>
{
	// Definisco i campi di ciascuna pratica
	static int numPraticheLegali = 0; // Numero di pratiche legali costruite
	int ID;
	String cliente;
	String descrizione;
	Data prossimaUdienza;
	StatoPratica statoPratica;
	int numeroOre; // Numero di ore dedicate alla particolare pratica

	/**
	 * 
	 * @param c cliente
	 * @param d descrizione
	 * @param u data prossima udienza
	 * @param n numero di ore già dedicate alla pratica
	 */
	PraticaLegale(String c, String d, Data u, int n)
	{
		this.cliente = c;						
		this.descrizione = d;					
		this.prossimaUdienza = u;				
		this.numeroOre = n;					
		this.ID = ++numPraticheLegali;
	}

	// Metodo che calcola la priorità di ciascuna pratica
	public int priorità()
	{
		if(statoPratica == StatoPratica.CHIUSA || statoPratica == StatoPratica.ARCHIVIATA)
			return 1000;
		Data oggi = new Data();
		int giorniMancanti = oggi.quantoManca(prossimaUdienza);
		if(giorniMancanti < 0)		  	// Se è un lavoro passato...
			return Integer.MAX_VALUE; 	// ... ha valore standard Integer.MAX_VALUE...
		else 						  	// ... altrimenti [cioè se giorni_mancanti >= 0 (udienza nel futuro)] ...
			return giorniMancanti;    	// ... la priorità coincide con il numero di giorni che mancano.
	}

	public abstract int costo(); 		// Il costo della pratica dipende dalla particolare pratica

	public int compareTo(PraticaLegale pl)
	{
		return this.prossimaUdienza.compareTo(pl.prossimaUdienza);
	}

	public String toString()
	{
		return "" + ID + "; \tCliente: " + cliente + "; \tUdienza fissata per il: " + prossimaUdienza + "; \tCosto: " + costo() + "$; \tPriorita': " + priorità();
	}

	/**
	 * 
	 * @return stato della pratica
	 */
	public StatoPratica statoPratica()
	{
		return this.statoPratica;
	}
}

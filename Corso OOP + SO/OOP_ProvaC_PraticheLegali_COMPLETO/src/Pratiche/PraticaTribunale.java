package Pratiche;

import prog.utili.Data;

// Classe astratta che rappresenta le pratiche civili e penali che hanno un grado di giudizio
public abstract class PraticaTribunale extends PraticaLegale
{
	GradoGiudizio grado;
	
	/**
	 * 
	 * @param c  cliente
	 * @param d  descrizione
	 * @param u  prossima udienza
	 * @param n  numero di ore già dedicate alla particolare pratica
	 * @param gg grado di giudizio
 	 */
	PraticaTribunale(String c, String d, Data u, int n, GradoGiudizio gg)
	{
		super(c, d, u, n);
		this.grado = gg;
	}

	// Il costo sia per le pratiche civili sia per quelle penali ha come moltiplicando il fattore 100, perciò 
	// lo dichiaro quì e non nelle classi PraticaPenale e PraticaCivile.
	private static final int COSTO_ORARIO = 100;

	/**
	 * 
	 * @return costo della pratica
	 */
	public int costo()
	{
		return grado.fattoreCosto * numeroOre * COSTO_ORARIO;
	}

	public String toString()
	{
		return super.toString() + "; \tGrado: " + grado + ".";
	}
}

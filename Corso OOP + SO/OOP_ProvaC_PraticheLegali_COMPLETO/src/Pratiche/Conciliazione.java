package Pratiche;

import prog.utili.Data;

public class Conciliazione extends PraticaLegale
{
	/**
	 * 
	 * @param c  cliente
	 * @param d  descrizione
	 * @param u  data prossima udienza
	 * @param sp stato della pratica
	 * @param n numero di ore già dedicate alla pratica
	 */
	public Conciliazione(String c, String d, Data u, StatoPratica sp, int n)
	{
		super(c, d, u, n);
		this.statoPratica = sp;
	}

	private static final int COSTO_ORARIO_C = 120;

	/**
	 * 
	 * @return costo della pratica
	 */
	public int costo()
	{
		return numeroOre * COSTO_ORARIO_C;
	}

	public String toString()
	{
		return "Concil con ID: " + super.toString();
	}
}

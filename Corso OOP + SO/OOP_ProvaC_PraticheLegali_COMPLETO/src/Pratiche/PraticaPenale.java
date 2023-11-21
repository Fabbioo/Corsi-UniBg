package Pratiche;

import prog.utili.Data;

public class PraticaPenale extends PraticaTribunale
{
	/**
	 * 
	 * @param c  cliente
	 * @param d  descrizione
	 * @param u  data prossima udienza
	 * @param n  numero di ore già dedicate alla pratica
	 * @param sp stato della pratica
	 * @param gg grado di giudizio
	 */
	public PraticaPenale(String c, String d, Data u, int n, StatoPratica sp, GradoGiudizio gg)
	{
		super(c, d, u, n, gg);
		this.statoPratica = sp;
	}
	
	public String toString()
	{
		return "Penale con ID: " + super.toString();
	}
}

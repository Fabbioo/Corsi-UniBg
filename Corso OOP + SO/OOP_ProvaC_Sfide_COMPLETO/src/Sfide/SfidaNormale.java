package Sfide;

import Eccezioni.OrarioNonValidoException;
import prog.utili.Orario;

public class SfidaNormale extends Sfida
{
	String luogo;

	private final int PUNTEGGIO_MINORE = 200;
	private final int PUNTEGGIO_MAGGIORE = 300;
	private final int MEZZOGIORNO = 12;

	/**
	 * @param id ID della sfida
	 * @param d  descrizione della sfida
	 * @param p1 nome 1° partecipante
	 * @param p2 nome 2° partecipante
	 * @param o	 orario della sfida
	 * @param t  tipologia della sfida
	 * @param l  luogo della sfida
	 * @throws OrarioNonValidoException 
	 */
	public SfidaNormale(String id, String d, String p1, String p2, Orario o, TipologiaSfida t, String l) throws OrarioNonValidoException
	{
		super(id, d, p1, p2, o, t);
		this.luogo = l;
	}

	/**
	 * @return punteggio associato alla sfida normale
	 */
	public int punteggio()
	{
		if(orario.getOre() < MEZZOGIORNO)
			return PUNTEGGIO_MINORE;
		else
			return PUNTEGGIO_MAGGIORE;
	}
}

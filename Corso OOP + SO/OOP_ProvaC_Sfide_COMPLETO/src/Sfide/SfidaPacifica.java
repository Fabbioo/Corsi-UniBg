package Sfide;

import Eccezioni.OrarioNonValidoException;
import prog.utili.Orario;

public class SfidaPacifica extends Sfida
{
	// Nessun campo in più come specificato dalla traccia

	private final int PUNTEGGIO_MINORE = 10;
	private final int PUNTEGGIO_MAGGIORE = 100;

	/**
	 * @param id ID della sfida
	 * @param d  descrizione della sfida
	 * @param p1 nome 1° partecipante
	 * @param p2 nome 2° partecipante
	 * @param o	 orario della sfida
	 * @param t  tipologia della sfida
	 * @throws OrarioNonValidoException
	 */
	public SfidaPacifica(String id, String d, String p1, String p2, Orario o, TipologiaSfida t) throws OrarioNonValidoException 
	{
		super(id, d, p1, p2, o, t);
	}

	/**
	 * @return punteggio associato alla sfida pacifica
	 */
	public int punteggio()
	{
		if(tipologia == TipologiaSfida.AMICHEVOLE)
			return PUNTEGGIO_MINORE;
		else
			return PUNTEGGIO_MAGGIORE;
	}
}

package Sfide;

import Eccezioni.*;
import prog.utili.Orario;

public class SfidaCompetizione extends Sfida
{
	private final int INCREMENTO_BASE = 1000;
	private final int MOLTIPLICATORE = 500;

	int punteggio;

	/**
	 * @param id ID della sfida
	 * @param d  descrizione della sfida
	 * @param p1 nome 1° partecipante
	 * @param p2 nome 2° partecipante
	 * @param o	 orario della sfida
	 * @param t  tipologia della sfida
	 * @param p  punteggio associato alla sfida
	 * @throws OrarioNonValidoException 
	 * @throws PunteggioNonValidoException 
	 */
	public SfidaCompetizione(String id, String d, String p1, String p2, Orario o, TipologiaSfida t, int p) throws OrarioNonValidoException
	{
		super(id, d, p1, p2, o, t);
		if(p > 0 && p < 11)
			this.punteggio = p;
	}

	/**
	 * @return punteggio associato alla sfida
	 */
	public int punteggio()
	{
		return INCREMENTO_BASE + punteggio * MOLTIPLICATORE;
	}
}

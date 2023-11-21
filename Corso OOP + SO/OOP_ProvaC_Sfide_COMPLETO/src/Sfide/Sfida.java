package Sfide;

import Eccezioni.*;
import prog.utili.Orario;

public abstract class Sfida implements Comparable<Sfida>
{
	// Definisco i campi posseduti da ciascun oggetto Sfida
	String ID;
	String descrizione; 		 // (ad esempio il nome del videogioco)
	String nome1Partecipante;
	String nome2Partecipante;
	Orario orario; 				 // Orario in cui si tiene la sfida
	TipologiaSfida tipologia; 	 // Tipologia della sfide
	static int nSfide = 0;	 	 // Conto quante sfide vengono create
	int numSfida; 				 // Numero (crescente) da associare alla particolare sfida

	Sfida(String id, String d, String p1, String p2, Orario o, TipologiaSfida t) throws OrarioNonValidoException
	{
		this.ID = id;
		this.descrizione = d;
		this.nome1Partecipante = p1;
		this.nome2Partecipante = p2;
		if(o.getOre() < 7 || o.getOre() > 24)
			throw new OrarioNonValidoException("Orario non valido!");
		this.orario = o;
		this.tipologia = t;
		this.numSfida = ++nSfide;
	}

	public abstract int punteggio(); // Il punteggio della sfida dipende dalla particolare sfida

	public int compareTo(Sfida s)
	{
		return this.descrizione.compareTo(s.descrizione);
	}

	public String toString()
	{
		return "ID: " + ID + numSfida + "; \tOrario: " + orario + "; \t\tPlayer 1: " + nome1Partecipante + "; \tPlayer 2: " + nome2Partecipante + "; \tDescrizione: " + descrizione + "; \tPunteggio: " + punteggio();
	}

	public String getOrario()
	{
		return String.valueOf(orario.getOre()) + String.valueOf(orario.getMinuti());
	}
	
	/** 
	 * @return nome del 1° partecipante
	 */
	public String get1Partecipante()
	{
		return this.nome1Partecipante;
	}

	/**
	 * @return nome del 2° partecipante
	 */
	public String get2Partecipante()
	{
		return this.nome2Partecipante;
	}
}

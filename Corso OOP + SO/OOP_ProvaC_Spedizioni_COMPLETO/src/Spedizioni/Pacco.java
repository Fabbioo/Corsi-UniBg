package Spedizioni;

import prog.utili.Data;

// Per ciascuna delle tre classi che estendono Spedizione definisco un campo in più per contraddistinguerle l'una dall'altra
public class Pacco extends Spedizione
{
	String descrizione;

	/**
	 * 
	 * @param da data della spedizione
	 * @param m  mittente
	 * @param d  destinatario
	 * @param p  peso  
	 * @param de descrizione della spedizione
	 */
	public Pacco(Data da, String m, String d, float p, String de)
	{
		super(da, m, d, p);
		this.descrizione = de;
	}

	// Impongo che il costo di un pacco sia pari al peso della spedizione moltiplicato per 3
	public float costo()
	{
		return peso * 3;
	}

	public String tipoSpedizione()
	{
		return "P";
	}

	public String toString()
	{
		return super.toString() + "; \tDescrizione: " + descrizione;
	}
}

package Spedizioni;

import prog.utili.Data;
import prog.utili.Orario;

// Per ciascuna delle tre classi che estendono Spedizione definisco un campo in più per contraddistinguerle l'una dall'altra
public class Celere extends Spedizione
{
	Orario oraPartenza;

	/**
	 * @param da data della spedizione
	 * @param m  mittente
	 * @param d  destinatario
	 * @param p  peso  
	 * @param o  orario di partenza della spedizione
	 */
	public Celere(Data da, String m, String d, float p, Orario o)
	{
		super(da, m, d, p);
		this.oraPartenza = o;
	}

	// Impongo che il costo di un pacco celere sia pari al peso della spedizione moltiplicato per 4
	public float costo()
	{
		return peso * 4;
	}

	public String tipoSpedizione()
	{
		return "C";
	}

	public String toString()
	{
		return super.toString() + "; \tOrario: " + oraPartenza;
	}
}

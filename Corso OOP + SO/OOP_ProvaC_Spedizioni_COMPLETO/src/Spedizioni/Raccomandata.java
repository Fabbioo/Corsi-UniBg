package Spedizioni;

import prog.utili.Data;

// Per ciascuna delle tre classi che estendono Spedizione definisco un campo in più per contraddistinguerle l'una dall'altra
public class Raccomandata extends Spedizione
{
	int priorita; // Numero compreso tra 1 e 10 -> più è alto il numero, più è elevata la priorità

	/**
	 * 
	 * @param da data della spedizione
	 * @param m  mittente
	 * @param d  destinatario
	 * @param p  peso  
	 * @param pr priorità della spedizione
	 */
	public Raccomandata(Data da, String m, String d, float p, int pr)
	{
		super(da, m, d, p);
		this.priorita = pr;
	}

	// Impongo che il costo di una raccomandata sia pari al peso della spedizione moltiplicato per 2
	public float costo()
	{
		return this.peso * 5;
	}

	public String tipoSpedizione()
	{
		return "R";
	}

	public String toString()
	{
		return super.toString() + "; \tPriorita': " + priorita;
	}
}

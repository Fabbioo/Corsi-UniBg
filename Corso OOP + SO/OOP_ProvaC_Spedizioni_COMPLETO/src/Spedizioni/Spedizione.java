package Spedizioni;

import prog.utili.Data;

public abstract class Spedizione implements Comparable<Spedizione>
{
	Data data;
	String mittente;
	String destinatario;
	float peso;
	int ID;
	static int numSpedizione = 0;

	/**
	 * @param da data della spedizione
	 * @param m  mittente
	 * @param d  destinatario
	 * @param p  peso del pacco
	 */
	Spedizione(Data da, String m, String d, float p)
	{
		this.data = da;
		this.mittente = m;
		this.destinatario = d;
		this.peso = p;
		this.ID = ++numSpedizione;
	}

	public abstract float costo();
	public abstract String tipoSpedizione();
	
	public float getPeso()
	{
		return this.peso;
	}
	
	public int compareTo(Spedizione s)
	{
		return this.data.compareTo(s.data);
	}

	public String toString()
	{
		return "ID: " + ID + "; \tTipo: " + tipoSpedizione() + " \tMittente: " + mittente + "; \tDestinatario: " + destinatario + "; \tData: " + data + "; \tPeso: " + peso + "kg; \tCosto: " + costo();
	}
}

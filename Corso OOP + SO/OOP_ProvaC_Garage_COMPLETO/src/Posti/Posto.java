package Posti;

import Veicoli.*;
import prog.utili.Data;
import prog.utili.Orario;

public abstract class Posto implements Comparable<Posto>
{
	static int numPostiCreati = 0;
	int ID;
	OccupazionePosto occupazionePosto;
	Veicolo veicolo;
	Data dataIngressoVeicolo;
	Orario orarioIngressoVeicolo;

	public Posto(OccupazionePosto occupazionePosto, Veicolo veicolo, Data dataIngressoVeicolo, Orario orarioIngressoVeicolo)
	{
		this.ID = ++numPostiCreati;
		this.occupazionePosto = occupazionePosto;
		this.veicolo = veicolo;
		this.dataIngressoVeicolo = dataIngressoVeicolo;
		this.orarioIngressoVeicolo = orarioIngressoVeicolo;
	}

	public int getID()
	{
		return ID;
	}

	public OccupazionePosto getOccupazionePosto()
	{
		return occupazionePosto;
	}

	public Veicolo getVeicolo()
	{
		return veicolo;
	}

	public Data getDataIngressoVeicolo()
	{
		return dataIngressoVeicolo;
	}

	public Orario getOrarioIngressoVeicolo()
	{
		return orarioIngressoVeicolo;
	}

	public abstract int calcolaImporto();

	public int getImporto()
	{
		return calcolaImporto();
	}

	public int compareTo(Posto posto)
	{
		return this.ID - posto.ID;
	}

	public String toString()
	{
		return "ID: " + ID + " \t| Occupazione: " + occupazionePosto + " \t| Tipo: " + veicolo.getTipo() + " \t| Targa: " + veicolo.getTarga() + " \t| Importo: " + getImporto() + " \t| Data ingresso: " + this.dataIngressoVeicolo + " \t| Orario ingresso: " + this.orarioIngressoVeicolo;
	}

	// Metodo per liberare un posto dal parcheggio
	public void postoRelease()
	{
		this.veicolo = null;
		this.occupazionePosto = OccupazionePosto.FREE;
		this.dataIngressoVeicolo = null;
		this.orarioIngressoVeicolo = null;
	}

	// Metodo per occupare un posto del parcheggio dato il veicolo
	public void postoEmploy(Veicolo veicolo)
	{
		this.veicolo = veicolo;
		this.occupazionePosto = OccupazionePosto.BUSY;
		this.dataIngressoVeicolo = new Data();
		this.orarioIngressoVeicolo = new Orario();
	}
}

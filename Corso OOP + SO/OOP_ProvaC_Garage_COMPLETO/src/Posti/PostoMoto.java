package Posti;

import Veicoli.Veicolo;
import prog.utili.Data;
import prog.utili.Orario;

public class PostoMoto extends Posto
{
	public PostoMoto(OccupazionePosto occupazionePosto, Veicolo veicolo, Data dataIngressoVeicolo, Orario orarioIngressoVeicolo)
	{
		super(occupazionePosto, veicolo, dataIngressoVeicolo, orarioIngressoVeicolo);
	}

	public int calcolaImporto()
	{
		if(this.orarioIngressoVeicolo.getOre() > 10)
			return 10;
		else
			return orarioIngressoVeicolo.getOre();
	}
}

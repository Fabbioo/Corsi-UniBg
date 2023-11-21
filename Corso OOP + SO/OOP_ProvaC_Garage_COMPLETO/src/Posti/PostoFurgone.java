package Posti;

import Veicoli.Veicolo;
import prog.utili.Data;
import prog.utili.Orario;

public class PostoFurgone extends Posto
{
	public PostoFurgone(OccupazionePosto occupazionePosto, Veicolo veicolo, Data dataIngressoVeicolo, Orario orarioIngressoVeicolo)
	{
		super(occupazionePosto, veicolo, dataIngressoVeicolo, orarioIngressoVeicolo);
	}

	public int calcolaImporto()
	{
		if(veicolo.getPeso() < 3500)
			return 10 + 10 * orarioIngressoVeicolo.getOre();
		else
			return 10 + 20 * orarioIngressoVeicolo.getOre();
	}
}

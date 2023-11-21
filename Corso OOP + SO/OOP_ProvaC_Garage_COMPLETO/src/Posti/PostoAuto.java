package Posti;

import Veicoli.Veicolo;
import prog.utili.Data;
import prog.utili.Orario;

public class PostoAuto extends Posto
{
	public PostoAuto(OccupazionePosto occupazionePosto, Veicolo veicolo, Data dataIngressoVeicolo, Orario orarioIngressoVeicolo)
	{
		super(occupazionePosto, veicolo, dataIngressoVeicolo, orarioIngressoVeicolo);
	}

	public int calcolaImporto()
	{
		if(this.orarioIngressoVeicolo.getOre() == 0 && orarioIngressoVeicolo.getMinuti() < 30)
			return 0; // Se l'auto rimane parcheggiata per meno di mezz'ora, il parcheggio è gratis
		else if(this.orarioIngressoVeicolo.getOre() == 0 && orarioIngressoVeicolo.getMinuti() > 30)
			return 3; // Se l'auto rimane parcheggiata per più di mezz'ora, ma meno di un'ora, pago l'ora intera
		else
			return 3 * orarioIngressoVeicolo.getOre();
	}
}

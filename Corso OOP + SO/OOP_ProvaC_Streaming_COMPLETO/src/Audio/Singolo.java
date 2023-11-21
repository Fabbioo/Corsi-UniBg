package Audio;

import prog.utili.Orario;
import Eccezioni.*;

public class Singolo extends Audio
{
	String autore;
	String paeseRealizzazione;

	public Singolo(String titolo, Orario durataAudio, CategoriaAudio categoriaAudio, GenereAudio genereAudio, String autore, String paeseRealizzazione) throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		super(titolo, durataAudio, categoriaAudio, genereAudio);
		this.ID = "S" + ++numAudioCreati;
		this.autore = autore;
		this.paeseRealizzazione = paeseRealizzazione;
	}

	public int peso()
	{
		if(genereAudio == GenereAudio.AMERICANO)
			return 90;
		else
			return 60;
	}

	public String toString()
	{
		return super.toString() + " | Autore: " + autore + " | Paese: " + paeseRealizzazione;
	}
}

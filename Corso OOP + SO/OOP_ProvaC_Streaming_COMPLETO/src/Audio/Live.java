package Audio;

import prog.utili.Orario;
import Eccezioni.*;

public class Live extends Audio
{
	String luogoLive;

	public Live(String titolo, Orario durataAudio, CategoriaAudio categoriaAudio, GenereAudio genereAudio, String luogoLive) throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		super(titolo, durataAudio, categoriaAudio, genereAudio);
		this.ID = "H" + ++numAudioCreati;
		this.luogoLive = luogoLive;
	}

	public int peso()
	{
		if(categoriaAudio == CategoriaAudio.RK)
			return 50;
		else
			return 40;
	}

	public String toString()
	{
		return super.toString() + " | Luogo: " + luogoLive;
	}
}

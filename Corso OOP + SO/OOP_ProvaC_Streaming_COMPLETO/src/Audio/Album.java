package Audio;

import prog.utili.Orario;
import Eccezioni.*;

public class Album extends Audio
{
	int numBrani;

	public Album(String titolo, Orario durataAudio, CategoriaAudio categoriaAudio, GenereAudio genereAudio, int numBrani) throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		super(titolo, durataAudio, categoriaAudio, genereAudio);
		this.ID = "A" + ++numAudioCreati;
		this.numBrani = numBrani;
	}

	public int peso()
	{
		return 10;
	}

	public String toString()
	{
		return super.toString() + " | Numero brani: " + numBrani;
	}
}

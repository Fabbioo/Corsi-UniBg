package Audio;

import prog.utili.Orario;
import Eccezioni.*;

public abstract class Audio implements Comparable<Audio>
{
	CategoriaAudio categoriaAudio;
	static int numAudioCreati = 0;
	String ID;
	Orario durataAudio;
	String titolo;
	GenereAudio genereAudio;

	Audio(String titolo, Orario durataAudio, CategoriaAudio categoriaAudio, GenereAudio genereAudio) throws TitoloNonValidoException, DurataEccessivaException, CategoriaNonValidaException, GenereNonValidoException
	{
		if(titolo.equals(""))
			throw new TitoloNonValidoException("Non e' possibile creare un brano senza avergli dato un titolo!");
		if(durataAudio.getOre() > 5)
			throw new DurataEccessivaException("Non e' possibile creare un audio con durata maggiore di 5h!");
		if(categoriaAudio != CategoriaAudio.JZ && categoriaAudio != CategoriaAudio.RK && categoriaAudio != CategoriaAudio.CL)
			throw new CategoriaNonValidaException("La categoria non esiste!");
		this.titolo = titolo;
		this.durataAudio = durataAudio;
		this.categoriaAudio = categoriaAudio;
		this.genereAudio = genereAudio;
	}

	public String getID()
	{
		return this.ID;
	}

	public String getDurataAudio()
	{
		return String.valueOf(durataAudio.getOre()) + String.valueOf(durataAudio.getMinuti());
	}

	public String getTitolo()
	{
		return this.titolo;
	}

	public CategoriaAudio getCategoriaAudio()
	{
		return this.categoriaAudio;
	}

	public GenereAudio getGenereAudio()
	{
		return this.genereAudio;
	}

	public abstract int peso();

	public int preferenza(Utente utente, String genereAudio)
	{
		int a = (int)(Math.random() * 10); // Genero casualmente un numero compreso tra 0 e 10
		Audio[] aa = utente.generiPreferiti;
		for(int i = 0; i < aa.length; i++)
			if(aa[i].getGenereAudio().equals(GenereAudio.valueOf(genereAudio)))
				a = a + a * (int)0.10;
		return a;
	}

	public int compareTo(Audio a)
	{
		return this.titolo.compareTo(a.titolo);
	}

	public String toString()
	{
		return "ID: " + ID + " | Titolo: " + titolo + " | Durata: " + durataAudio + " | Peso: " + peso();
	}
}

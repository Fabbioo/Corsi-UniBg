package Prenotazioni;

public class PrenotazioneIndividuale extends Prenotazione
{
	String nome;
	final int costo;
	PreferenzaPosto preferenzaPosto;

	public PrenotazioneIndividuale(String nome, int costo, PreferenzaPosto preferenzaPosto)
	{
		super(); // Con questa chiamata creo l'ID per la particolare prenotazione individuale
		this.nome = nome;
		this.costo = costo;
		this.preferenzaPosto = preferenzaPosto;
	}
}

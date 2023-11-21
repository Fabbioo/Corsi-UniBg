package Prenotazioni;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneGruppo extends Prenotazione
{
	List<String> persone;
	float costoPersonaGruppo; // Suppongo che tutti i componenti del gruppo paghino la stessa quota

	public PrenotazioneGruppo(String[] lista, float costoPersonaGruppo)
	{
		super(); // Con questa chiamata creo l'ID per la particolare prenotazione di gruppo
		this.persone = new ArrayList<String>();
		for(int i = 0; i < lista.length; i++)
			persone.add(lista[i]);
		this.costoPersonaGruppo = costoPersonaGruppo;
	}

	public float getCostoPrenotazioneGruppo()
	{
		if(persone.size() <= 10)
			return costoPersonaGruppo * persone.size() * 0.90f; // Ovvero: return costoPersonaGruppo * persone.size() - costoPersonaGruppo * persone.size() * 0.10f;
		else
			return costoPersonaGruppo * persone.size() * 0.80f; // Ovvero: return costoPersonaGruppo * persone.size() - costoPersonaGruppo * persone.size() * 0.20f;
	}

	public void addPersona(String nome)
	{
		persone.add(nome);
	}
}

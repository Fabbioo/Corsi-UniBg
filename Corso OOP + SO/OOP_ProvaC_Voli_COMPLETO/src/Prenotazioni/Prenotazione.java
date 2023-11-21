package Prenotazioni;

import java.util.Random;

public abstract class Prenotazione implements Comparable<Prenotazione>
{
	String ID;
	Random rnd = new Random();

	public Prenotazione()
	{
		this.ID = "" + (char)(rnd.nextInt(26) + 'A') + (char)(rnd.nextInt(26) + 'A'); // Calcolo due caratteri per l'ID
		this.ID = ID + rnd.nextInt(10) + rnd.nextInt(10); // Calcolo due interi per l'ID
		this.ID = ID + (char)(rnd.nextInt(26) + 'A') + (char)(rnd.nextInt(26) + 'A'); // Calcolo altri due caratteri per l'ID
		// Ad ogni invocazione del costruttore di prenotazioni, ottengo un ID del tipo: PH15KR
	}

	public String getID()
	{
		return ID;
	}

	public int compareTo(Prenotazione prenotazione)
	{
		return this.getID().compareTo(prenotazione.getID());
	}
}

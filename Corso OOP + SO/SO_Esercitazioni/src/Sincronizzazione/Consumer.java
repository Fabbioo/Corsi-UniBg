package Sincronizzazione;

import java.util.*;

public class Consumer implements Runnable
{
	private Buffer buffer;

	// Il consumatore conserva il riferimento all'oggetto condiviso buffer:
	public Consumer(Buffer b)
	{
		this.buffer = b;
	}

	public void run()
	{
		Date message;

		while(true)
		{
			System.out.println(Thread.currentThread().getName() + ": dormo");

			SleepUtilities.nap(); // Metodo statico per far sì che il consumatore aspetti un tempo compreso tra 0 e 5 secondi prima di stampare il prossimo output.

			// Il consumatore prova a consumare un oggetto dal buffer
			System.out.println(Thread.currentThread().getName() + ": voglio rimuovere un numero");

			try {
				message = (Date)buffer.remove(); // Poichè il metodo remove() restituisce un Object occorre effettuare un cast esplicito al tipo Date.
			} catch (InterruptedException e) { }

			// Se il consumatore trova il buffer vuoto rimane in attesa che venga prodotto qualche oggetto dal produttore.
			// Solo quando il consumatore riesce a prelevare qualcosa dal buffer riprende la sua esecuzione.
		}
	}
}

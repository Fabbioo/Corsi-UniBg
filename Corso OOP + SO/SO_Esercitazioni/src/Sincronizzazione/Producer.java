package Sincronizzazione;

import java.util.*;

public class Producer implements Runnable
{
	private Buffer buffer;

	// Il produttore conserva il riferimento all'oggetto condiviso buffer:
	public Producer(Buffer b)
	{
		this.buffer = b;
	}

	public void run()
	{
		Date message; // Come oggetti da rilasciare nel buffer vengono presi oggetti di tipo Integer

		// Il produttore produce infiniti oggetti di tipo Date aggiungendoli al buffer:
		while(true)
		{
			System.out.println(Thread.currentThread().getName() + ": dormo"); // Il produttore sta facendo un pisolino.

			SleepUtilities.nap(); // Metodo statico per far sì che il produttore aspetti un tempo compreso tra 0 e 5 secondi prima di stampare il prossimo output.

			System.out.println(Thread.currentThread().getName() + ": devo aggiungere un numero");
			message = new Date(); // Il produttore crea un oggetto dte e lo assegna alla variabile message
			System.out.println(Thread.currentThread().getName() + ": ho prodotto \"" + message + "\" e ora la inserisco nel buffer");

			// Il produttore inserisce la data appena creata nel buffer
			try {
				buffer.insert(message);
			} catch (InterruptedException e) { }
	
			// Se il buffer è pieno, il produttore, prima di poter aggiungere una nuova data, deve aspettare che si liberi almeno uno slot.
		}
	}
}

package Multithreading;

public class MyThreadTerzoMetodo
{
	/**
	 * ATTENZIONE:
	 * Il docente sconsiglia l'uso di questo metodo per creare oggetti di tipo Thread dato che tutte le istruzioni sono "appiccicate".
	 */

	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName()); // Stampo il nome del main thread

		//Creazione di 10 thread di classe anonima   
		for(int i = 0; i < 10; i++)
		{
			new Thread("" + i) 
			// Creo 10 oggetti di tipo Thread assegnando a ciascuno di essi un nome corrispondente al valore dell'indice i
			// (uso il costruttore che prende in input il nome che si vuole attribuire allo specifico oggetto di tipo Thread)
			{
				public void run() // Override del metodo run()
				{
					System.out.println("Thread: " + getName() + " running");
				}
			}.start(); // Al termine della creazione di ciascun oggetto di tipo Thread, contestualmente viene avviato
		}
	}
}

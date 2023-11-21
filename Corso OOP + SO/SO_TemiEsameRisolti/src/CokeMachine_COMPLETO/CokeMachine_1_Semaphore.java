package CokeMachine_COMPLETO;

import java.util.concurrent.Semaphore;

/* Assunzione: il fornitore è svegliato dal thread che rimuove l'ultima lattina presente nel distributore. */

public class CokeMachine_1_Semaphore implements CokeMachineIF
{
	private static final int N = 5; // Costante che rappresenta la capacità del distributore.
	private int count; 				// Contatore del numero di lattine presenti.
	private Semaphore mutex; 		// Semaforo (binario) per la realizzazione della mutua esclusione.
	private Semaphore empty; 		// Semaforo (generalizzato) che rappresenta la risorsa astratta distributore vuoto.
		// Il semaforo empty è presente per un motivo: è necessario far addormentare il fornitore quando il distributore è pieno
		// e svegliarlo quando è vuoto. Per realizzare questa cooperazione introduco un tipo di risorsa ASTRATTA col nome di"empty" (cioè distributore vuoto).
		// Il fornitore aspetta di avere dei distributori vuoti per poterli riempire.
		// I semafori servono sempre per realizzare l'accesso esclusivo alle risorse, le quali possono anche avere una natura astratta.

	CokeMachine_1_Semaphore()
	{
		// Inizialmente assumo che il distributore sia pieno e che non ci siano thread attivi.
		this.count = N;
		this.mutex = new Semaphore(1); // Accesso libero al distributore.
		this.empty = new Semaphore(0); // All'inizio il distributore è pieno -> inizializzo a 0 perchè voglio che il fornitore inizialmente sia dormiente (il distributore è pieno e perciò non deve essere ulteriormente riempito) -> blocco l'accesso al distributore vuoto -> questo perchè il distributore, INIZIALMENTE, è pieno.
	}

	public void remove() throws InterruptedException
	{
		// La prima cosa da fare è accedere alla sezione critica: il primo semaforo che acquisisce il cliente è il mutex.
		mutex.acquire();

		// Supponendo che il thread utente abbia accesso al distributore (cioè ha acquisito mutex), a questo punto può prelevare.
		// L'atto del prelievo può avvenire se e solo se ci sono lattine dentro al distributore:
		if(count > 0)
		{
			count--;
			System.out.println(Thread.currentThread().getName() + ": 1 lattina rimossa. Lattine rimaste: " + count);
			// L'utente che ha prelevato l'ultima lattina deve svegliare il fornitore, perciò:
			if(count == 0)
				empty.release();
		}

		// Come ultimo passaggio rimane solo il rilascio del semaforo mutex ad opera del thread cliente.
		mutex.release();
	}

	public void deposit() throws InterruptedException
	{
		// Il fornitore, COME PRIMA COSA, deve acquisire il semaforo empty, ovvero la risorsa astratta distributore vuoto.
		empty.acquire();

		// Se empty.acquire() va in porto vuol dire che il distributore è vuoto, perciò il fornitore lo deve riempire.
		// A tal fine è necessario che il distributore acquisisca mutex:
		mutex.acquire();

		count = N;

		System.out.println("\nDistributore completamente riempito dal " + Thread.currentThread().getName() + ". Lattine presenti = " + count + "\n");

		mutex.release();
	}
}

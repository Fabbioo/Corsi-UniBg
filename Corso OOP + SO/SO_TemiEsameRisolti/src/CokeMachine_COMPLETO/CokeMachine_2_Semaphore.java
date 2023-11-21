package CokeMachine_COMPLETO;

import java.util.concurrent.Semaphore;

/* Assunzione: il fornitore è svegliato dal primo cliente che trova il distributore vuoto. */

public class CokeMachine_2_Semaphore implements CokeMachineIF
{
	private static final int N = 10;		// Costante che rappresenta la capacità del distributore.
	private int count;  				// Contatore del numero di lattine presenti.
	private Semaphore mutex;			// Semaforo (binario) per la realizzazione della mutua esclusione.
	private Semaphore empty;			// Semaforo (generalizzato) che rappresenta la risorsa astratta distributore vuoto.
	private boolean fornitoreAvvisato;  // Flag per filtrare le sveglie ricevute da tutti gli utenti.

	CokeMachine_2_Semaphore()
	{
		// Inizialmente assumo che il distributore sia pieno e che non ci siano thread attivi.
		this.count = N;
		this.mutex = new Semaphore(1);   // Accesso libero al distributore -> nessun utente cerca di prelevare.
		this.empty = new Semaphore(0);   // All'inizio il distributore è pieno -> inizializzo a 0 perchè voglio che inizialmente il fornitore inizialmente sia dormiente (il distributore è pieno e perciò non deve essere ulteriormente riempito).
		this.fornitoreAvvisato = false;	 // All'inizio il fornitore non deve ricevere alcuna sveglia, perciò inizializzo il flag a false.
	}

	public void remove() throws InterruptedException
	{
		mutex.acquire();

		// Se il cliente trova il distributore vuoto e il fornitore NON è stato ancora avvisato:
		if(count == 0 && !fornitoreAvvisato)
		{
			// Nel caso in cui il thread in azione trovasse il distributore vuoto e nessuno avesse ancora avvisato il fornitore, lo avvisa tale thread.
			empty.release(); 		  // Serve per svegliare il fornitore
			fornitoreAvvisato = true; // Setto il flag a true in modo tale che i prossimi clienti che si avvicinano al distributore e la trovano vuoto non avvisino nuovamente il fornitore.
		}
		else if(count > 0)
		{
			count--;
			System.out.println(Thread.currentThread().getName() + ": 1 lattina rimossa. Lattine rimaste: " + count);
		}

		mutex.release();
	}

	public void deposit() throws InterruptedException
	{
		empty.acquire();

		mutex.acquire();

		count = N;

		System.out.println("\nDistributore completamente riempito dal " + Thread.currentThread().getName() + ". Lattine presenti = " + count + "\n");

		fornitoreAvvisato = false;

		mutex.release();
	}
}

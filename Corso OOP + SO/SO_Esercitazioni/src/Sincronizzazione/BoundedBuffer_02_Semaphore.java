package Sincronizzazione;

import java.util.concurrent.Semaphore;

public class BoundedBuffer_02_Semaphore implements Buffer
{
	private static final int BUFFER_SIZE = 5;

	private int in;   		 // "Puntatore" alla prossima posizione libera nel buffer.
	private int out;  		 // "Puntatore" alla prossima posizione occupata nel buffer.
	private Object[] buffer; // Buffer.

	private Semaphore mutex; // Semaforo che regola la mutua esclusione (semaforo binario).
	private Semaphore empty; // Semaforo che conta le locazioni vuote (semaforo generalizzato).
	private Semaphore full;  // Semaforo che conta le locazioni piene (semaforo generalizzato).

	BoundedBuffer_02_Semaphore()
	{
		// Il buffer è inizialmente vuoto e nessun thread è attivo sul buffer stesso, perciò:
		this.in = 0;
		this.out = 0;
		this.buffer = new Object[BUFFER_SIZE];
		this.mutex = new Semaphore(1);			 // Accesso libero alla sezione critica.
		this.empty = new Semaphore(BUFFER_SIZE); // Avendo un buffer inizialmente vuoto, il buffer è costituito da BUFFER_SIZE locazioni vuote.
		this.full = new Semaphore(0);			 // Avendo un buffer inizialmente vuoto, il buffer è costituito da 0 locazioni piene.
	}

	public void insert(Object item) throws InterruptedException
	{
		try {
			empty.acquire(); // Se l'acquisizione del semaforo empty va in porto, vuol dire che il buffer è vuoto e perciò deve essere riempito.
			mutex.acquire(); // Per poter inserire un elemento nel buffer si deve acquisire il semaforo binario.

			// Sezione critica -> aggiunta di un elemento nel buffer:
			buffer[in] = item;
			in = (in + 1) % BUFFER_SIZE;

			System.out.println("Il produttore ha inserito: " + item + ". Locazioni occupate: " + (full.availablePermits() + 1) + "; Locazioni libere: " + (empty.availablePermits() + "."));
		} finally {
			mutex.release();	// Dopo aver inserito la data nel buffer occorre rilasciare il semaforo binario.
			full.release();		// Mando una notifica al consumatore dicendogli che c'è almeno una locazione piena.
		}
	}

	public Object remove() throws InterruptedException
	{
		Object item;

		try {
			full.acquire();	 // Se l'acquisizione del semaforo full va in porto, vuol dire che è il buffer non è vuoto e perciò si può rimuovere un elemento.
			mutex.acquire(); // Per poter rimuovere un elemento dal buffer occorre acquisire preventivamente il semaforo binario.

			// Sezione critica -> rimozione di un elemento dal buffer:
			item = buffer[out];
			out = (out + 1) % BUFFER_SIZE;

			System.out.println("Il consumatore ha consumato: " + item + ". Locazioni occupate: " + (full.availablePermits()) + "; Locazioni libere: " + (empty.availablePermits() + 1) + ".");
		} finally {
			mutex.release();	// Dopo aver rimosso una data dal buffer il consumatore ha terminato il suo compito e può rilasciare il semaforo binario.
			empty.release();	// Mando una notifica al produttore dicendogli che c'è almeno una locazione da riempire.
		}
		return item;
	}
}

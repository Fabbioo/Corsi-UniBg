package Sincronizzazione;

import java.util.concurrent.locks.*;

public class BoundedBuffer_03_LockVarCond implements Buffer
{
	private static final int BUFFER_SIZE = 5; // Buffer limitato: la capacità è inizialmente impostata a 5.

	private int count; 		 // Contatore del numero di elementi presenti nel buffer.
	private int in;   		 // Indice che punta alla successiva posizione libera -> usata dal produttore.
	private int out;  		 // Indice che punta alla successiva posizione piena -> usata dal consumatore.
	private Object[] buffer; // Array di oggetti.

	private Lock lock; 				// Variabile condizione che serve per realizzare la mutua esclusione.
	private Condition notFull;	 	// Variabile condizione di attesa per il produttore.
	private Condition notEmpty; 	// Variabile condizione di attesa per il consumatore.

	BoundedBuffer_03_LockVarCond()
	{
		// Il buffer è inizialmente vuoto, perciò:
		this.count = 0;
		this.in = 0;
		this.out = 0;
		this.buffer = new Object[BUFFER_SIZE];
		this.lock = new ReentrantLock();
		this.notFull = lock.newCondition();
		this.notEmpty = lock.newCondition();
	}

	// Metodo invocato dal produttore.
	public void insert(Object item) throws InterruptedException
	{
		lock.lock();

		try {
			while(count == BUFFER_SIZE) // Finchè il buffer è pieno il produttore non può inserire nuovi elementi, perciò...
				notFull.await();		// ... deve essere bloccato [-> il produttore viene bloccato nell'attesa dell'evento notFull (che gli verrà segnalato dal consumatore)]

			// SEZIONE CRITICA:
			// Se giungo a questo punto del codice vuol dire che il buffer non è saturo -> aggiungo un elemento al buffer.
			count++;
			buffer[in] = item;
			in = (in + 1) % BUFFER_SIZE;

			// SCRITTE DI DEBUG OPZIONALI:
			if(count == BUFFER_SIZE)
				System.out.println(Thread.currentThread().getName() + " -> ho inserito: \"" + item + "\" -> Buffer PIENO.");
			else
				System.out.println(Thread.currentThread().getName() + " -> ho inserito: \"" + item + "\" -> Buffer Size = " + count + ".");

			notEmpty.signal(); // Prima che la sezione critica termini è necessario che il produttore svegli il consumatore per segnalargli che il buffer non è più vuoto
		} finally {
			// System.out.println(Thread.currentThread().getName() + ": rilascio il lock.");
			lock.unlock();
		}
	}

	// Metodo invocato dal consumatore.
	public Object remove() throws InterruptedException
	{
		Object item;

		lock.lock();

		try {
			while(count == 0)		// Finchè il buffer è vuoto il consumatore non può rimuovere elementi, perciò...
				notEmpty.await(); 	//... deve essere bloccato -> il consumatore viene bloccato nell'attesa dell'evento notEmpty (che gli verrà segnalato dal produttore)

			// SEZIONE CRITICA:
			// Rimuovo un elemento dal buffer
			count--;
			item = buffer[out];
			out = (out + 1) % BUFFER_SIZE;

			// SCRITTE DI DEBUG OPZIONALI:
			if(count == 0)
				System.out.println(Thread.currentThread().getName() + " -> ho eliminato \"" + item + "\" -> Buffer VUOTO.");
			else
				System.out.println(Thread.currentThread().getName() + " -> ho eliminato \"" + item + "\" -> Buffer Size = " + count + ".");

			notFull.signal(); // Prima che la sezione critica termini è necessario che il consumatore svegli il produttore per segnalargli che il buffer non è più pieno

			return item;
		} finally {
			// System.out.println(Thread.currentThread().getName() + ": rilascio il lock.");
			lock.unlock();
		}
	}
}

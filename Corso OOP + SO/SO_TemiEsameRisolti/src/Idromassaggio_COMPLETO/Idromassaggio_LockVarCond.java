package Idromassaggio_COMPLETO;

import java.util.concurrent.locks.*;

public class Idromassaggio_LockVarCond
{
	private int N; 				// Capacità dell'idromassaggio.
	private int donneIn; 		// Numero di donne nell'idromassaggio.
	private int uominiIn; 		// Numero di uomini nell'idromassaggio.
	private int sospD; 			// Numero di donne in attesa di entrare nell'idromassaggio.
	private int sospU; 			// Numero di uomini in attesa di entrare nell'idromassaggio.
	private Lock lock;			// Variabile condizione per realizzare la mutua esclusione.
	private Condition donneL;	// Variabile condizione di attesa per le donne.
	private Condition uominiL;	// Variabile condizione di attesa per gli uomini.

	Idromassaggio_LockVarCond(int N)
	{ 
		// Inizialmente l'idromassaggio è vuoto e non ci sono persone in coda:
		this.N = N;
		this.donneIn = 0;
		this.uominiIn = 0;
		this.sospD = 0;
		this.sospU = 0;
		this.lock = new ReentrantLock();
		this.donneL = lock.newCondition();
		this.uominiL = lock.newCondition();
	}

	public void donnaEntra() throws InterruptedException
	{
		lock.lock(); 	// Acquisisco il lock.

		try {
			// Una donna viene sospesa in due situazioni:
			// 1) se l'idromassaggio è pieno;
			// 2) se ci sono uomini nell'idromassaggio.
			while((donneIn + uominiIn) == N || uominiIn > 0)
			{
				sospD++; 		// Aggiungo la donna in attesa.
				donneL.await(); // Il thread viene sospeso, lo inserisco nella coda e rilascio il lock.
				sospD--; 		// Quando riacquisisce il lock ricomincio da qui e tolgo una donna dalla coda.
			}

			donneIn++; // La donna entra nell'idromassaggio.

			System.out.println(Thread.currentThread().getName() + ": entrata.");
		} finally {
			lock.unlock(); // Rilascio il lock.
		}
	}

	public void donnaEsce() throws InterruptedException
	{
		lock.lock(); 		// Acquisisco il lock.

		try {
			donneIn--;			 // Diminuisco il numero di donne nell'idromassaggio.

			System.out.println(Thread.currentThread().getName() + ": uscita.");

			if(sospD > 0)						// Se ci sono donne che aspettano risveglio una donna sospesa
				donneL.signal();
			else if(donneIn == 0 && sospU > 0)	// Non ci sono più donne: risveglio tutti gli uomini
				uominiL.signalAll();
		} finally {
			lock.unlock(); // Rilascio il lock.
		}
	}

	public void uomoEntra() throws InterruptedException
	{
		lock.lock();

		try {
			// Un uomo viene sospeso in tre condizioni:
			// 1) se l'idromassaggio è pieno;
			// 2) se ci sono donne nell'idromassaggio;
			// 3) se ci sono donne in attesa di entrare nell'idromassaggio.
			while((donneIn + uominiIn) == N || donneIn > 0 || sospD > 0)
			{
				sospU++;
				uominiL.await();
				sospU--;
			}

			uominiIn++;

			System.out.println(Thread.currentThread().getName() + ": entrato.");
		} finally {
			lock.unlock();
		}
	}

	public void uomoEsce() throws InterruptedException
	{
		lock.lock();

		try {
			uominiIn--;

			System.out.println(Thread.currentThread().getName() + ": uscito.");

			if(uominiIn == 0 && sospD > 0)
				donneL.signalAll();
			else if(sospD == 0 && sospU > 0)	// Se non ci sono donne che aspettano e ci sono uomini che aspettano, allora risveglio un uomo.
				uominiL.signal();
		} finally {
			lock.unlock();
		}
	}
}

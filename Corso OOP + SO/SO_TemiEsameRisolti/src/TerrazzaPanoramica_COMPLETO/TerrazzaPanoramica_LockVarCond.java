package TerrazzaPanoramica_COMPLETO;

import java.util.concurrent.locks.*;

// Questa è la classe che dovrà essere scritta all'esame, dando per scontato che le altre (cioè MonitorIF, Visitatore e TerrazzaPanoramica) siano già presenti.

public class TerrazzaPanoramica_LockVarCond implements TerrazzaPanoramicaIF
{
	private final int MAX = 30;   	// Numero massimo di persone ammesse contemporaneamente sulla terrazza.
	private final int EST = 0;
	private final int OVEST = 1;
	private int dentro; 		  	// Contatore del numero di persone presenti sulla terrazza.
	private int[] inE; 				// Contatore delle persone nel tratto E per entrambe le provenienze di viaggio.
	private int[] inO; 				// Contatore delle persone nel tratto O per entrambe le provenienze di viaggio.
	/*
	 * Dichiaro due vettori perchè ciascun tratto può contenere SIA persone provenienti da est SIA persone provenienti di OVEST.
	 * Le diverse posizioni dei due vettori (posizione 0 e posizione 1) stanno ad indicare le due diverse provenienze:
	 * inE[0] = numero di persone sul tratto E con provenienza EST
	 * inE[1] = numero di persone sul tratto E con provenienza OVEST
	 * inO[0] = numero di persone sul tratto O con provenienza EST
	 * inO[1] = numero di persone sul tratto O con provenienza OVEST
	 */
	private Lock lock;				// Variabile di lock.
	private Condition[] codaTE; 	// Variabile condizione: code in ingresso al tratto E per entrambe le provenienze (una coda sul tratto E e una sulla riva est).
	private Condition[] codaTO; 	// Variabile condizione: code in ingresso al tratto O per entrambe le provenienze (una coda sul tratto O e una sulla riva ovest).
	/*
	 * Le variabili condizione vengono inserite perchè si è interessati alla sospensione dei thread:
	 * sospensione dei thread = creazione di code di attesa.
	 * I visitatori devono aspettare (e quindi si creano code) sia sulle rive sia sui ponti.
	 * Visto che ci sono due rive e due ponti, servono 4 variabili condizione.
	 */

	TerrazzaPanoramica_LockVarCond()
	{
		// All'inizio il parco è vuoto e non ci sono visitatori, perciò:
		this.dentro = 0;
		this.inE = new int[2];
		this.inO = new int[2];
		this.lock = new ReentrantLock();
		this.codaTE = new Condition[2];
		this.codaTO = new Condition[2];
		for(int i = 0; i < 2; i++)
		{
			this.inE[i] = 0;
			this.inO[i] = 0;
			this.codaTE[i] = lock.newCondition();
			this.codaTO[i] = lock.newCondition();
		}
	}

	/* 
	 * Il metodo EntraTrattoE() viene invocato sia dai visitatori che provengono dalla riva est (cioè quelli che ancora
	 * devono visitare la terrazza panoramica per poi dirigersi verso la riva ovest) sia da quelli che provengono dalla 
	 * riva ovest (cioè quelli che sono appena usciti dalla terrazza panoramica e si devono dirigere verso la riva est).
	 */
	public void EntraTrattoE(int d) throws InterruptedException
	{
		// Realizzo la mutua esclusione -> acquisisco il lock:
		lock.lock(); 
		try {
			// Sezione critica.
			if(d == EST) // Se il visitatore proviene dalla riva est, deve entrare nel tratto E.
			{
				/* 
				 * Il visitatore proveniente dalla riva est deve aspettare ad accedere al tratto E in due occasioni: 
				 * 1) se sul tratto E sono presenti visitatori con provenienza da ovest; 
				 * 2) se il numero di persone all'interno del parco è maggiore di MAX.
				 */ 
				while(inE[OVEST] > 0 || totDentro() == MAX) 
					codaTE[d].await(); // Il visitatore deve attendere.

				inE[d]++; // Superato il controllo while, il visitatore accede al tratto E.
			}			
			else		// ... altrimenti se proviene da ovest (d == OVEST)...
			{
				// Il visitatore che deve uscire dalla terrazza deve solo controllare che non ci siano visitatori sul tratto E con provenienza dalla riva est.
				while(inE[EST] > 0)
					codaTE[d].await();

				inE[d]++; // Superato il controllo while, il visitatore esce dalla terrazza e accede al tratto E.
				dentro--; // Contestualmente il numero di visitatori all'interno della terrazza deve essere decrementato di 1.

				// Se il tratto O non è attraversato da visitatori provenienti da est, sveglia i visitatori da ovest:
				if(inO[EST] == 0)
					codaTO[OVEST].signal();
			}

			System.out.println(Thread.currentThread().getName() + ": entrato nel tratto E con provenienza " + ((d == 0) ? "EST." : "OVEST."));
			stampa();
		} finally {
			lock.unlock();
		}
	}

	// Il metodo EntraTrattoO() è speculare rispetto a EntraTrattoE().
	public void EntraTrattoO(int d) throws InterruptedException
	{
		try {
			lock.lock();

			if(d == OVEST)
			{
				while(inO[EST] > 0 || totDentro() == MAX)
					codaTO[d].await();
				inO[d]++; 
			}
			else
			{
				while(inO[OVEST] > 0)
					codaTO[d].await();
				inO[d]++;
				dentro--;
				if(inE[OVEST] == 0)
					codaTE[EST].signal();
			}

			System.out.println(Thread.currentThread().getName() + ": entrato nel tratto O con provenienza " + ((d == 0) ? "EST." : "OVEST."));
			stampa();
		} finally {
			lock.lock();
		}
	}

	/* 
	 * Il metodo EsciTrattoE() viene invocato sia dai visitatori che devono accedere alla terrazza (cioè quelli provenienti dalla
	 * riva est e che si sono fatti la coda) sia da quelli che escono dalla terrazza (cioè quelli che provengono dalla riva ovest e 
	 * hanno terminato la visita della terrazza -> rimane loro solo da attraversare il tratto E per uscire dal parco).
	 */
	public void EsciTrattoE(int d) throws InterruptedException
	{
		try {
			// Realizzo la mutua esclusione -> acquisisco il lock:
			lock.lock();

			// Sezione critica.
			inE[d]--; // Poichè un visitatore ha acceduto alla terrazza il numero di persone presenti sul tratto E va decrementato di 1.

			if(d == EST) // Se il visitatore deve accedere alla terrazza...
			{
				dentro++;
				if(inE[d] == 0)
					codaTE[OVEST].signalAll(); // Sveglia dei visitatori che vogliono attraversare il tratto E per terminare la visita.
			}
			else		// ... altrimenti, se il visitatore deve uscire dal parco (d == OVEST)...
			{
				if(inE[d] == 0)
					codaTE[EST].signalAll(); // Sveglia dei visitatori da EST che vogliono iniziare la visita.
			}

			System.out.println(Thread.currentThread().getName() + ": uscito dal tratto E con provenienza " + ((d == 0) ? "EST." : "OVEST."));
			stampa();
		} finally {
			lock.unlock();
		}
	}

	// Il metodo EsciTrattoO() è speculare rispetto a EsciTrattoE().
	public void EsciTrattoO(int d) throws InterruptedException
	{
		try {
			lock.lock();

			inO[d]--;

			if(d == OVEST)
			{
				dentro++;
				if(inO[d] == 0)
					codaTO[EST].signalAll();
			}
			else
			{ 
				if(inO[d] == 0)
					codaTE[OVEST].signalAll();
			}

			System.out.println(Thread.currentThread().getName() + ": uscito dal tratto O con provenienza " + ((d == 0) ? "EST." : "OVEST."));
			stampa();
		} finally {
			lock.unlock();
		}
	}

	// totDentro() restituisce il numero totale delle persone presenti nel parco:
	private int totDentro()
	{
		// Il numero totale di persone presenti nel parco è dato da:
		// _ numero di persone presenti sulla terrazza -> dentro;
		// _ numero di persone presenti sul tratto O (in entrambi i versi) -> inO[0] e inO[1];
		// _ numero di persone presenti sul tratto E (in entrambi i versi) -> inE[0] e inE[1].
		return dentro + inO[0] + inO[1] + inE[0] + inE[1];
	}

	private void stampa()
	{
		System.out.println("\tVisitatori nel tratto O -> da EST: " + inO[0] + "; da OVEST: " + inO[1] + ".");
		System.out.println("\tVisitatori sulla terrazza: " + dentro + ".");
		System.out.println("\tVisitatori nel tratto E -> da EST: " + inE[0] + "; da OVEST: " + inE[1] + ".");
		System.out.println("\tNumero totale di visitatori nel parco: " + totDentro() + ".");
	}
}

package SingleLaneBridge_COMPLETO;

/*
 * I contatori waitred e waitblue hanno lo scopo di mantenere il conto del numero di auto in coda in attesa di passare.
 */
public class SafeBridge_Synchro implements Bridge
{
	private int nred; 		// Contatore di auto rosse in transito sul ponte.
	private int nblue;		// Contatore di auto blu in transito sul ponte.
	private int waitred;	// Contatore di auto rosse in attesa di entrare sul ponte.
	private int waitblue;	// Contatore di auto blu in attesa di entrare sul ponte.
	private boolean turn; 	// Flag per il passaggio sul ponte: true se è il turno delle blu, false se è il turno delle rosse.

	SafeBridge_Synchro()
	{
		// All'inizio il ponte è sgombro.
		this.nred = 0;
		this.nblue = 0;
		this.waitblue = 0;
		this.waitred = 0;
		this.turn = true; // Assumo che all'inizio sul ponte transitino le auto blu.
	}

	public synchronized void redEnter() throws InterruptedException
	{
		waitred++; // Una auto rossa è fuori dal ponte e desidera accedervi.

		// Una auto rossa può accedere al ponte solo a due condizioni:
		// 1) non ci siano già auto blu in transito;
		// 2) non ci siano auto blu in attesa.
		while(nblue > 0 || (waitblue > 0 && turn))
			wait();

		// Una auto rossa che era in coda è ora passata, quindi il contatore delle auto rosse in coda va decrementato:
		waitred--;

		// Poichè si ha una auto rossa sul ponte è necessario incrementare il contatore nred:
		nred++;

		// Stampa di debug:
		System.out.println(Thread.currentThread().getName() + " sta passandoo \t| \tnred: " + nred + "; \tnblue: " + nblue + "; \twred: " + waitred + "; \twblue: " + waitblue);
	}

	public synchronized void redExit()
	{
		nred--;

		System.out.println(Thread.currentThread().getName() + " sta uscendooo \t| \tnred: " + nred + "; \tnblue: " + nblue + "; \twred: " + waitred + "; \twblue: " + waitblue);
		
		turn = true;
		
		if(nred == 0)
			notifyAll(); // L'ultima auto rossa sveglia tutti i thread che gestiscono le auto blu.
	}

	public synchronized void blueEnter() throws InterruptedException
	{
		waitblue++;

		while(nred > 0 || (waitred > 0 && !turn))
			wait();	

		waitblue--;

		nblue++;

		System.out.println(Thread.currentThread().getName() + " sta passandoo \t| \tnred: " + nred + "; \tnblue: " + nblue + "; \twred: " + waitred + "; \twblue: " + waitblue);
	}

	public synchronized void blueExit()
	{
		nblue--;

		System.out.println(Thread.currentThread().getName() + " sta uscendooo \t| \tnred: " + nred + "; \tnblue: " + nblue + "; \twred: " + waitred + "; \twblue: " + waitblue);

		turn = false;
		
		if(nblue == 0)
			notifyAll(); // L'ultima auto blu sveglia tutti i thread che gestiscono le auto rosse.
	}
}

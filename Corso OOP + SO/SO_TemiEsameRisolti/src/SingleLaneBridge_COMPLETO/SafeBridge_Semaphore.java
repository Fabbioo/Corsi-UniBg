package SingleLaneBridge_COMPLETO;

import java.util.concurrent.Semaphore;

public class SafeBridge_Semaphore implements Bridge
{
	private int nRed; 			// Contatore di auto rosse in transito sul ponte.
	private int nBlue;			// Contatore di auto blu in transito sul ponte.

	private int waitRed;		// Contatore di auto rosse in attesa di entrare sul ponte.
	private int waitBlue;		// Contatore di auto blu in attesa di entrare sul ponte.

	private boolean turn; 		// Flag per il passaggio sul ponte: true se è il turno delle blu, false se è il turno delle rosse.

	private Semaphore mutex; 	// Semaforo (binario) mutex per la sezione critica.
	private Semaphore bTurn; 	// Semaforo da far acquisire alle auto blu.
	private Semaphore rTurn; 	// Semaforo da far acquisire alle auto rosse.

	SafeBridge_Semaphore()
	{
		// All'inizio il ponte è sgombro
		this.nRed = 0;
		this.nBlue = 0;
		this.waitBlue = 0;
		this.waitRed = 0;
		this.turn = true; 				// Assumo che all'inizio sul ponte transitino le auto blu.
		this.mutex = new Semaphore(1);
		this.bTurn = new Semaphore(1);
		this.rTurn = new Semaphore(0);
	}

	public void blueEnter() throws InterruptedException
	{
		try {
			mutex.acquire();

			while(nRed > 0 || !turn)
			{
				waitBlue++;
				mutex.release();
				bTurn.acquire();
				mutex.acquire();
				waitBlue--;
			}

			// auto blu sul ponte
			nBlue++;

			System.out.println(Thread.currentThread().getName() + " sta passandoo | nRed: " + nRed + "; nBlue: " + nBlue);
		} finally {
			mutex.release();
			rTurn.release();
		}
	}

	public void blueExit() throws InterruptedException
	{
		try {
			mutex.acquire();

			if(--nBlue == 0) // Se è l'ultima auto blu
			{
				turn = false;

				while(waitRed > 0)
				{
					// Se ci sono auto blu in attesa di entrare nel ponte, le svegliamo
					waitRed--;
					rTurn.release();
				}
			}

			System.out.println(Thread.currentThread().getName() + " sta uscendooo | nRed: " + nRed + "; nBlue: " + nBlue);
		} finally {
			mutex.release();
		}
	}

	public void redEnter() throws InterruptedException
	{
		try {
			mutex.acquire();

			while(nBlue > 0 || turn)
			{
				waitRed++;
				mutex.release();
				rTurn.acquire(); // l'auto aspetta il turno delle rosse
				mutex.acquire();
				waitRed--;
			}

			// auto rossa sul ponte
			nRed++;

			System.out.println(Thread.currentThread().getName() + " sta passandoo | nRed: " + nRed + "; nBlue: " + nBlue);
		} finally {
			mutex.release();
			bTurn.release();
		}
	}

	public void redExit() throws InterruptedException
	{
		try {
			mutex.acquire();

			if(--nRed == 0) // Se è l'ultima auto rossa
			{
				turn = true;
				while(waitBlue > 0)
				{
					// Se ci sono auto blu in attesa di entrare nel ponte, le svegliamo
					waitBlue--;
					bTurn.release();
				}
			}

			System.out.println(Thread.currentThread().getName() + " sta uscendooo | nRed: " + nRed + "; nBlue: " + nBlue);
		} finally {
			mutex.release();
		}
	}
}

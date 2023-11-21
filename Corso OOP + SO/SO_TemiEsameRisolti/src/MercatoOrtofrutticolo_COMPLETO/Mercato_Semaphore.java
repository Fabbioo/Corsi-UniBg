package MercatoOrtofrutticolo_COMPLETO;

import java.util.concurrent.Semaphore;

public class Mercato_Semaphore implements MercatoIF
{
	private final int PV;		 // Prezzo di vendita per i produttori (valore arbitrario)
	private final int PA;		 // Prezzo di acquisto per i grossisti (valore arbitrario)
	private final int capacity;   // Capacità massima del mercato (valore arbitrario)

	private int merce;			 // Contatore del mumero di merci presenti nel mercato
	private int cassa;		 	 // Soldi disponibili in cassa

	private Semaphore mutex;
	private Semaphore full;
	private Semaphore empty;

	Mercato_Semaphore(int merce, int cassa)
	{
		this.PV = 10;
		this.PA = 12;
		this.capacity = 1000;
		this.merce = merce;
		this.cassa = cassa;
		this.mutex = new Semaphore(1);					// Inizialmente la risorsa è libera
		this.full = new Semaphore(merce);				// Inizialmente il numero di locazioni piene corrisponde ai quintali di merce presente (quintali di merce PRESENTE)
		this.empty = new Semaphore(capacity - merce);	// Inizialmente il numero di locazioni vuote corrisponde al valore capacity - merce (quintali di merce ASSENTE)
	}

	public void compra(int q, float budget) throws InterruptedException
	{
		try {
			full.acquire();
			mutex.acquire();

			if((q <= merce) && (q * PA <= budget))
			{
				merce = merce - q;
				cassa = cassa + q * PA;
			}

			System.out.println(Thread.currentThread().getName() + " ha comprato " + q + " mele al mercato al costo di " + (q * PA) + "   \t| \tMele rimanenti: " + merce + "; Cassa: " + cassa);
		} finally {
			mutex.release();
			empty.release();
		}
	}

	public void vendi(int q) throws InterruptedException
	{
		try {
			empty.acquire();
			mutex.acquire();

			if(((q + merce) <= capacity) && (q * PV <= cassa))
			{
				merce = merce + q;
				cassa = cassa - q * PV;
			}

			System.out.println(Thread.currentThread().getName() + " ho comprato " + q + " mele dal contadino e ho speso " + (q * PV) + " \t| \tMele presenti: " + merce + "; Cassa: " + cassa);
		} finally {
			mutex.release();
			full.release();
		}
	}
}

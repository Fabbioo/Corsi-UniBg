package Sincronizzazione;

/*
 * In questa classe vengono creati:
 * 1) il buffer (cioè l'oggetto condiviso);
 * 2) il thread relativo al produttore;
 * 3) il thread relativo al consumatore.
 */

public class Factory
{
	public static void main(String args[])
	{
		// Nel metodo main, il thread main crea l'oggetto condiviso buffer:
		// Buffer buffer = new BoundedBuffer_01_SynchroDI_NONGUARDARE();
		// Buffer buffer = new BoundedBuffer_02_SynchroDI();
		 Buffer buffer = new BoundedBuffer_02_Semaphore();
		// Buffer buffer = new BoundedBuffer_04_LockVarCond();

		 // Una volta creato l'oggetto condiviso, il thread main crea gli altri due thread:
		Thread producerThread = new Thread(new Producer(buffer), "Produttore"); // Viene creato un oggetto producerThread di tipo Thread sfruttando la classe Producer
		Thread consumerThread = new Thread(new Consumer(buffer), "Consumatore"); // Viene creato un oggetto consumerThread di tipo Thread sfruttando la classe Consumer
		// Ad entrambi gli oggetti creati viene passato il riferimento all'oggetto condiviso buffer

		// Avvio i due thread figli:
		producerThread.start();
		consumerThread.start();
	}
}

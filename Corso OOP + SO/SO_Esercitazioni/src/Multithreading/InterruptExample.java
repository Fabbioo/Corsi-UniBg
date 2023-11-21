package Multithreading;

// Questo programma illustra il comportamento del metodo interrupt().

public class InterruptExample
{
	public static void main(String[] args)
	{
		Thread worker = new Thread(new InterruptibleThread(), "Fabio");

		worker.start();

		System.out.println("Quì è il thread " + Thread.currentThread().getName() + " che parla: a breve manderò il segnale di interruzione a mio figlio!");

		//Faccio aspettare al thread main 3 secondi prima di interrompere il figlio
		// try { Thread.sleep(3000); } catch (InterruptedException ie) { }

		worker.interrupt();
	}
}

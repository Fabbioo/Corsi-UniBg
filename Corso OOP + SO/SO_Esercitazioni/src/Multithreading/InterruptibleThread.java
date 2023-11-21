package Multithreading;

public class InterruptibleThread implements Runnable
{
	public void run()
	{
		int i = 0;
		
		while(true)
		{
			i++; // La i verrà incrementata di 1 ad opera del thread figlio fintantochè non giungerà al thread figlio il segnale di interruzione dal padre.
			
			if(Thread.currentThread().isInterrupted() == true)
			{
				System.out.println("\nSono il thread figlio " + Thread.currentThread().getName() + ": mi è giunto il segnale dopo aver eseguito " + i + " istruzioni!");
				break;
			}
		}
	}
}

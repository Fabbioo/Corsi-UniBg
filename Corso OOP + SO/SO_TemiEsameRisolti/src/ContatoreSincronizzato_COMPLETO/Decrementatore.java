package ContatoreSincronizzato_COMPLETO;

public class Decrementatore extends Thread
{
	private ContatoreSincronizzato counterSynchro;

	Decrementatore(ContatoreSincronizzato counterSynchro)
	{
		this.counterSynchro = counterSynchro;
	}

	public void run()
	{
		while(true)
		{	
			SleepUtilities.nap();

			System.out.println(Thread.currentThread().getName() + ": rimuovo un numero");

			try {
				counterSynchro.decrement();
			} catch (InterruptedException e) { }
		}
	}
}

package ContatoreSincronizzato_COMPLETO;

public class Incrementatore extends Thread
{
	private ContatoreSincronizzato counterSynchro;

	Incrementatore(ContatoreSincronizzato counter)
	{
		this.counterSynchro = counter;
	}

	public void run()
	{
		while(true)
		{
			SleepUtilities.nap();

			System.out.println(Thread.currentThread().getName() + ": aggiungo un numero");

			try {
				counterSynchro.increment();
			} catch (InterruptedException e) { }
		}
	}
}

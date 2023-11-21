package Idromassaggio_COMPLETO;

public class Donna extends Thread
{
	Idromassaggio_LockVarCond t; 	// Riferimento alla risorsa condivisa idromassaggio.
	int id;				// Identificativo numerico del thread.

	Donna(Idromassaggio_LockVarCond t, int id)
	{
		this.t = t;
		this.setName("Donna" + String.valueOf(id));
	}

	public void run()
	{
		while(true)
		{
			try {
				t.donnaEntra();
				
				SleepUtilities.nap();
				
				t.donnaEsce();
				
				SleepUtilities.nap();
			} catch(InterruptedException e) { }
		}
	}
}

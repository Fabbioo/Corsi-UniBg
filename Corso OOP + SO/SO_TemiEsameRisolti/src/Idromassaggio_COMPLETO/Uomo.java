package Idromassaggio_COMPLETO;

public class Uomo extends Thread
{
	Idromassaggio_LockVarCond t; // Riferimento alla risorsa condivisa idromassaggio.
	int id; 		 // Identificativo numerico del thread.

	Uomo(Idromassaggio_LockVarCond t, int id)
	{
		this.t = t;
		this.setName("Uomo" + String.valueOf(id));
	}

	public void run()
	{
		while(true)
		{
			try {
				t.uomoEntra();
				
				SleepUtilities.nap();
				
				t.uomoEsce();
				
				SleepUtilities.nap();
			} catch(InterruptedException e) { }
		}
	}
}

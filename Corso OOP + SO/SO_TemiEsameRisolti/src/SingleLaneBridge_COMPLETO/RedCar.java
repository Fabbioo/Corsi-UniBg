package SingleLaneBridge_COMPLETO;

public class RedCar extends Thread
{
	Bridge ponte;

	RedCar(Bridge p, String name)
	{
		this.ponte = p;
		this.setName(name);
	}

	public void run() 
	{
		try {
			ponte.redEnter();
			
			// Ciascuna macchina impiega un certo tempo ad attraversare il ponte -> simulo questa differenza di percorrenza con una dormita.
			SleepUtilities.nap();
			
			ponte.redExit();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}



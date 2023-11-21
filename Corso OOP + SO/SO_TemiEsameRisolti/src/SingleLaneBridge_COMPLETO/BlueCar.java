package SingleLaneBridge_COMPLETO;

public class BlueCar extends Thread
{
	Bridge ponte;

	BlueCar(Bridge p, String name)
	{
		this.ponte = p;
		this.setName(name);
	}

	public void run()
	{	
		try {
			ponte.blueEnter();
			
			// Ciascuna macchina impiega un certo tempo ad attraversare il ponte -> simulo questa differenza di percorrenza con una dormita.
			SleepUtilities.nap();
			
			ponte.blueExit();
		} catch(InterruptedException e) {	
			e.printStackTrace();
		}
	}
}

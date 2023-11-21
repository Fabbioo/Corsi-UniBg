package SingleLaneBridge_COMPLETO;

public class Test
{
	public static void main(String[] args)
	{
		// Creo l'oggetto condiviso ponte sfruttando l'interfaccia Bridge.
		//Bridge ponte = new SafeBridge();
		//Bridge ponte = new FairBridge();
		Bridge ponte = new SafeBridge_Semaphore();

		for(int i = 0; i < 9; i++)
		{
			new RedCar(ponte, "R" + (i+1)).start();  // Passo a RedCar il riferimento all'oggetto condiviso ponte e un nome e faccio partire il thread.
			new BlueCar(ponte, "B" + (i+1)).start(); // Passo a BlueCar il riferimento all'oggetto condiviso ponte e un nome e faccio partire il thread.
		}
	}
}

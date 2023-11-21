package TribuCannibali_COMPLETO;

public class Cuoco extends Thread
{
	Pentola_LockVarCond pentola;
	
	Cuoco(Pentola_LockVarCond pentola)
	{
		this.pentola = pentola;
		this.setName("Cuoco");
	}
	
	public void run()
	{
		while(true)
		{
			try {
				sleep((int)Math.random() * 3000);
				pentola.riempi();
				sleep((int)Math.random() * 3000);
			} catch(InterruptedException ie) { }
		}
	}
}

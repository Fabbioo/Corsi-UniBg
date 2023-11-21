package TribuCannibali_COMPLETO;

public class Cannibale extends Thread
{
	Pentola_LockVarCond pentola;
	
	Cannibale(Pentola_LockVarCond pentola, int d)
	{
		this.pentola = pentola;
		this.setName("Cannibale-" + String.valueOf(d));
	}
	
	public void run()
	{
		while(true)
		{
			try {
				sleep((int)Math.random() * 3000);
				pentola.serviti();
				sleep((int)Math.random() * 3000);
			} catch(InterruptedException e) { }
		}
	}
}

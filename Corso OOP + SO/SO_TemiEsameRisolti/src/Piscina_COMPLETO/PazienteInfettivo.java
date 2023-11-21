package Piscina_COMPLETO;

public class PazienteInfettivo extends Thread
{
	Piscina_LockVarCond piscina;
	int d;
	
	PazienteInfettivo(Piscina_LockVarCond piscina, int d)
	{
		this.piscina = piscina;
		this.setName("PI-" + String.valueOf(d));
	}
	
	public void run()
	{
		while(true)
		{
			try {
				piscina.entraI();
				sleep((int)Math.random() * 3000);
				piscina.esceI();
				sleep((int)Math.random() * 3000);
			} catch (InterruptedException e) { }
		}
	}
}

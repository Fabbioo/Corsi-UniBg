package Piscina_COMPLETO;

public class PazienteOrtopedico extends Thread
{
	Piscina_LockVarCond piscina;
	int d;
	
	PazienteOrtopedico(Piscina_LockVarCond piscina, int d)
	{
		this.piscina = piscina;
		this.setName("PO-" + String.valueOf(d));
	}
	
	public void run()
	{
		while(true)
		{
			try {
				piscina.entraO();
				sleep((int)Math.random() * 3000);
				piscina.esceO();
				sleep((int)Math.random() * 3000);
			} catch (InterruptedException e) { }
		}
	}
}

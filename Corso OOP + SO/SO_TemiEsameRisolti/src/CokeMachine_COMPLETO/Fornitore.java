package CokeMachine_COMPLETO;

public class Fornitore extends Thread
{
	CokeMachineIF c;

	Fornitore(CokeMachineIF c)
	{
		this.c = c;
		this.setName("Fornitore");
	}

	public void run()
	{
		while(true)
			try {
				c.deposit();
			} catch(InterruptedException e) { }
	}
}

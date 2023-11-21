package CokeMachine_COMPLETO;

public class Utente extends Thread
{
	CokeMachineIF c;

	Utente(CokeMachineIF c, int id)
	{
		this.c = c;
		this.setName("Utente " + id);
	}

	public void run()
	{
		while(true)
		{
			try	{
				c.remove(); // L'utente prova a bere una lattina
				sleep((int)(Math.random()*5000)); // Simulo l'azione di bere la lattina (attesa di 5s) prima di prenderne un'altra
			} catch(InterruptedException e) { }
		}
	}
}

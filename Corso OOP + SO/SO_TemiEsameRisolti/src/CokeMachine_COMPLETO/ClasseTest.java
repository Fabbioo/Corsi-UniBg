package CokeMachine_COMPLETO;

public class ClasseTest 
{
	public static void main(String[] Args)
	{
		// Creo l'oggetto condiviso:
		
		//CokeMachineIF c = new CokeMachine1(); // FUNZIONANTE

		CokeMachineIF c = new CokeMachine_2_Semaphore(); // FUNZIONANTE

		// Creo un oggetto Fornitore (è un thread)
		new Fornitore(c).start();

		for(int i = 0; i < 5; i++)
			new Utente(c,i+1).start();
	}
}

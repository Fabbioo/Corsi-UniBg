package Multithreading;

public class MyThreadImplements implements Runnable
{
	// Override del metodo run():
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + ": Ciao mondo! (implements)");

		/*
		 * ATTENZIONE:
		 * Da notare che se non ci fosse il metodo statico currentThread() Java segnalerebbe errore:
		 * poichè la classe MyThreadImplements non estende la classe Thread, non possiede il metodo getName() della classe stessa.
		 * Alla luce di ciò, si rende necessario invocare il metodo statico currentThread() della classe Thread prima di eseguire il metodo getName().
		 */
	}
}

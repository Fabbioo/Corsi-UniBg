package Multithreading;

// Questo programma illustra il funzionamento del metodo join().

public class JoinExample
{
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName() + " : I'm creating a thread Worker");

		Thread task = new Thread(new JoinableWorker(), "Worker");

		task.start();

		try {
			task.join(); // Il metodo join() mette in attesa il thrad main fino alla terminazione del thread Worker.
		} catch(InterruptedException ie) { }
		/*
		 *  è come se il thread figlio Worker chiedesse al padre main "papà, puoi aspettare che io finisca il mio compito?".
		 *  Il main thread viene bloccato fin quando non gli arriva il segnale di terminazione dal thread figlio.
		 *  Quando il thread figlio termina di eseguire con successo il metodo run(), manda in automatico un segnale al padre.
		 */

		// Come passaggio finale, il thread MAIN stampa la seguente scritta:
		System.out.println(task.getName() + ": done!"); // Il thread main chiede al thread figlio di stampare il suo nome seguito dalla scritta : done!
			/*
			 * Poichè potrebbe creare problemi quest'ultima osservazione, commenta la riga 25 e togli il commento da queste due successive:
			 * System.out.println(Thread.currentThread().getName() + ": done!");
			 * System.out.println(task.getName() + ": done!");
			 */

		/* 
		 * ATTENZIONE:
		 * Si può notare come la scritta "Worker: done" venga SEMPRE stampata alla fine:
		 * questo perchè l'istruzione task.join() fa sì che il padre si sincronizzi sulla terminazione del figlio.
		 * 
		 * Togliendo l'intero blocco try-catch, la stampa "Worker done!" NON SEMPRE viene stampata per ultima:
		 * questo perchè non è possibile fare alcuna assunzione circa le velocità relative dei thread.
		 */
	}
}

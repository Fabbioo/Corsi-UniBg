package Multithreading;

public class HelloWorld
{
	public static void main(String[] args)
	{
		// 1) SFRUTTO IL THREAD main:
		System.out.println(Thread.currentThread().getName() + ": Ciao mondo!"); // Osservazioni 3 e 4.

		// 2) CREO UN THREAD ESTENDENDO LA CLASSE THREAD:
		Thread t_extends = new MyThreadExtends(); // Creo un oggetto t_extends di tipo Thread (thread figlio del thread main) usando la classe MyThreadExtends.
		t_extends.setName("Pippo"); // Osservazione 5.

		/*
		 * Il metodo seguito presenta un limite non da poco: UNA CLASSE PUò ESTENDERE SOLO UN'ALTRA CLASSE.
		 * Procedendo in questa direzione tale grado di libertà viene perso.
		 * Inconveniente: dovendo scrivere una classe particolarmente complicata, se questa dovesse estendere un'altra classe, non potrebbe!
		 */

		// 3) CREO UN THREAD IMPLEMENTANDO LA CLASSE RUNNABLE:
		Thread t_implements = new Thread(new MyThreadImplements()); // Creo un oggetto t_implements di tipo Thread (thread figlio del thread main) usando la classe MyThreadImplements.
		t_implements.setName("Caio"); // Osservazione 5.

		/*
		 * OCCORRE NOTARE CHE I DUE THREAD APPENA CREATI NON SONO ANCORA STATI AVVIATI:
		 * sono stati creati e i loro parametri interni sono stati settati ai valori di default (ad eccezione del nome), ma sono passivi.
		 */

		// AVVIO I DUE THREAD APPENA CREATI:
		t_extends.start();
		t_implements.start();

		/*
		 * OSSERVAZIONI:
		 * 1) Ho creato un programma multithread con 3 thread: main, Pippo e Caio;
		 * 2) main è il nome del thread che esegue il metodo main della classe HelloWorld;
		 * 3) currentThread() è un metodo statico della classe Thread e restituisce il riferimento al thread corrente;
		 * 4) getName() è un metodo della classe Thread che restituisce il nome del thread attualmente in esecuzione;
		 * 5) setName() è un metodo della classe Thread che cambia il nome del thread in quello specificato nella stringa (il nome di default è "Thread-i"), dove la i indica il thread i-esimo;
		 * 6) Per sapere il nome del thread che ha in carico il ruolo di stampare la stringa "Ciao mondo" sfrutto il metodo getName() della classe Thread;
		 * 7) Non appena il thread viene AVVIATO, viene eseguito il metodo run(): il comportamento del thread coincide con il corpo del metodo run();
		 * 8) Qualunque "cosa" si voglia far fare agli oggetti di tipo Thread, il codice di questa "cosa" deve essere specificato nel metodo run().
		 */
	}
}

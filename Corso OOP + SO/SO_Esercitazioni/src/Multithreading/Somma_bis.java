package Multithreading;

/**
 * Esempio Somma: Programma multithread in Java che esegue una somma tra due numeri interi inseriti dall'utente. 
 * Creare un thread separato per effettuare la somma e restituire il risultato in una variabile (globale) condivisa con il main thread.
 * Il thread principale deve stampare il risultato a video.
 * 
 * Seconda soluzione: Sommatore è dichiarata come classe interna a Somma_bis e pertanto  vede (e condivide) tutto ciò che è dichiarato 
 * all'interno della classe Somma_bis.
 */

// Il docente sconsiglia questo procedimento perchè non le piacciono le Inner Class
public class Somma_bis
{
	private int result;

	// Creazione e avvio del thread figlio "on the fly" per fare la somma.
	// Il risultato viene posto direttamente dal thread figlio nell'attributo privato result di Somma_bis.
	public void doSomma(int a, int b)
	{
		Thread sommatore = new Thread(new Sommatore(a, b)); //Passo alla classe Sommatore il valore dei soli interi da sommare
		// Dal punto di vista dei thread, ho creato un thread figlio (nome default Thread-0).

		sommatore.start();

		// Sincronizzo il thread main sulla terminazione del thread figlio (il quale esegue il metodo run() della classe Sommatore
		try { sommatore.join(); } catch(InterruptedException ex) { ex.printStackTrace(); }
	}

	//Inner class:
	public class Sommatore implements Runnable
	{		
		int a, b;

		public Sommatore(int a, int b)
		{
			this.a = a;
			this.b = b;
		}

		public void run()
		{
			System.out.println("Ciao! Sono il thread figlio " + Thread.currentThread().getName() + " e ora svolgo il mio compito!");
			result = a + b;
			System.out.println("Ho finito! Il controllo passa a mio padre!");
		}
	}

	public static void main(String[] args)
	{
		//Creiamo un oggetto di tipo Somma_bis ed invochiamo su di esso il metodo doSomma(a,b) per eseguire la somma e stamparla a video
		Somma_bis e = new Somma_bis();
		e.doSomma(3,6);
		System.out.println("Eccomi! Quì parla il thread " + Thread.currentThread().getName() + " e il risultato del compito di mio figlio è " + e.result + ".");
	}
}
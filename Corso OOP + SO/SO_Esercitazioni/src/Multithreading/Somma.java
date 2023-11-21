package Multithreading;

/**
 * Programma multithread che esegue una funzione di somma tra due numeri interi inseriti dall'utente. 
 * Creare un thread separato per effettuare la somma e restituire il risultato in una variabile (globale) condivisa con il thread main.
 * Il thread principale deve stampare il risultato a video.
 *
 * Prima soluzione: Somma e Sommatore sono due classi distinte e separate
 */

//Secondo i principi della buona programmazione, le classi HoldInteger e Sommatore dovrebbero essere scritte in un altro file .java
class HoldInteger // La classe HoldInteger è stata concepita per essere la classe involucro del tipo primitivo int
{
	int val;

	// Il metodo setVal prende in input un intero (newVal) e lo assegna alla variabile val.
	void setVal(int newVal)
	{
		this.val = newVal;
	}

	// Il metodo getVal non riceve alcun parametro in input e ritorna il valore della variabile val.
	int getVal()
	{
		return val;
	}
}

class Sommatore implements Runnable
{
	private HoldInteger result; // variabile (privata) destinata ad essere il riferimento allo shared object
	int a, b;

	// Per costruire un oggetto Sommatore necessito di un riferimento a HoldInteger e due interi int
	public Sommatore(HoldInteger result, int a, int b)
	{
		this.result = result;
		this.a = a;
		this.b = b;
	}

	public void run()
	{
		System.out.println("Ciao! Sono il thread figlio " + Thread.currentThread().getName() + " e tra 3 secondi svolgerò il mio compito!");
		try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
		result.setVal(a + b);
		System.out.println("Ho finito!");
		// Passo in input al metodo setVal il valore di a+b con l'effetto di assegnare a result il valore della somma.
		// A questo punto del codice perciò result punta ad un oggetto di tipo HoldInteger al cui interno vi è val di valore 8.
	}
}

public class Somma
{
	public static void main(String[] args)
	{
		// Definizione dello shared object che conterrà un intero (vedi definizione sotto della classe involucro HoldInteger)
		HoldInteger result = new HoldInteger();
			// Creo una variabile riferimento di nome result che punta ad un oggetto di tipo HoldInteger, al cui interno vi è memorizzata una variabile int.

		int a = 3;
		int b = 5;

		// I due valori int da sommare ed il riferimento allo shared object in cui ci si aspetta il risultato,
		// vengono passati come parametri al costruttore della classe Sommatore.
		Thread doSum = new Thread(new Sommatore(result, a, b));
		// Creo un oggetto di nome doSum di tipo Thread.
		// A questo punto del codice:
		// _ result punta ad un oggetto al cui interno vi è un intero di nome val e di valore (di default) 0;
		// _ a = 3, b = 5.
		// Dal punto di vista dei thread, ho creato un thread figlio (il cui nome è Thread-0).

		doSum.start();
		// L'esecuzione del metodo start() COINCIDE con l'esecuzione del metodo run(), di cui è stato fatto l'override nella classe Sommatore

		//Faccio in modo che il thread padre main si sincronizzi sulla terminazione del figlio
		try	{ doSum.join(); } catch (InterruptedException e) { e.printStackTrace(); }

		System.out.println("Il controllo è ripassato al " + Thread.currentThread().getName() + " thread -> Somma: " + a + " + " + b + " = " + result.getVal());
	}
}


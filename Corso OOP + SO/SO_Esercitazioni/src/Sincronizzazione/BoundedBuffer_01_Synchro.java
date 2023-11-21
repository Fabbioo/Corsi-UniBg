package Sincronizzazione;

/*
 * This program implements the bounded buffer using Java synchronization.
 *
 * L'implementazione dell'oggetto condiviso cambia al variare dell'implementazione.
 *
 * Bounded buffer = buffer limitato.
 *
 * In questa "copia" di BoundedBuffer_01 mi preoccupo di realizzare:
 * _ la mutua esclusione (dato che entrambi i thread accedono in maniera concorrente a count e al buffer);
 * _ la cooperazione.
 * Sfrutto il meccanismo del synchronized sui metodi insert() e remove() per realizzare la mutua esclusione.
 * Elimino l'attesa attiva sostituendo i ; dentro i cicli while con wait() per realizzare la cooperazione.
 * 
 * Mandando in esecuzione questa versione, il programma NON FINIRà MAI, dove l'accesso all'oggetto condiviso avviene in modo mutuamente esclusivo:
 * un solo thread alla volta è attivo dentro l'oggetto BoundedBuffer_02: o il produttore (eseguendo insert) o il consumatore (eseguendo remove).
 * insert e remove vengono invocate in modo mutuamente esclusivo sull'oggetto condiviso. 
 */

public class BoundedBuffer_01_Synchro implements Buffer
{
	private static final int BUFFER_SIZE = 5; // Poichè sto considerando un buffer a capacità limitata, occorre definirne il limite: dichiaro BUFFER_SIZE = 5.

	private Object[] buffer; 				 // Realizzo il buffer modellandolo come se fosse un array dinamico.

	private int count; 						 // Contatore del numero di oggetti presenti nel buffer.
	private int in; 						 // Indice a cui guarda il produttore: rappresenta l'indice della successiva locazione libera nell'array in cui il produttore può inserire un oggetto.
	private int out; 						 // Indice a cui guarda il consumatore: rappresenta l'indice delle successiva locazione piena nell'array in cui il consumatore può consumare/rimuovere un oggetto.

	BoundedBuffer_01_Synchro()
	{
		this.buffer = new Object[BUFFER_SIZE];
		this.count = 0;	// Inizialmente ipotizzo che nessuno dei due thread sia attivo e, pertanto, che l'array (cioè il buffer) sia vuoto.
		this.in = 0; // Inizialmente in punta alla prima locazione dell'array (nella locazione 0 il produttore può inserire un elemento).
		this.out = 0;	// Inizialmente out punta alla prima locazione dell'array (dalla locazione 0 il consumatore può rimuovere un elemento).
	}

	public synchronized void insert(Object item) throws InterruptedException
	{
		while(count == BUFFER_SIZE)	// Se il buffer è pieno occorre sospendere momentaneamente il produttore.
			wait(); // poichè il metodo insert() viene sfruttato dal produttore, il metodo wait() ha come effetto quello di bloccare il thread produttore

		// Arrivato a questo punto, so per certo che il buffer NON è PIENO (cioè count != BUFFER_SIZE), perciò il produttore può aggiungere un elemento:
		count++;
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		/*
		 * Realizzo il buffer in maniera circolare: non appena viene raggiunta l'ultima posizione utile (indice BUFFER_SIZE - 1), lo faccio ripartire da 0.
		 * Utilizzo l'aritmetica modulare: operatore % (resto della divisione) -> spiegazione con 3%5, 4%5 e 5%5:
		 * si divide un numero intero per un altro numero intero ottenendo come risultato un terzo numero intero corrispondente allo "scarto" dell'operazione.
		 * Sfrutto 3 % 5 -> 3/5 = 0.6 -> 3 - 0 = 3;
		 * Sfrutto 4 % 5 -> 4/5 = 0.8 -> 4 - 0 = 4;
		 * Sfrutto 5 % 5 -> 5/5 = 1 resto 0 -> 5 - 1 = 4 -> posizione già occupata.
	 	 *		Noto che fino a quando viene effettuata una divisione il cui risultato è un numero decimale, l'operazione ritorna il numero a sinistra di %.
		 */

		if(count == BUFFER_SIZE)
			System.out.println(Thread.currentThread().getName() + ": ho inserito \"" + item + "\" -> Il buffer è ora pieno");
		else
			System.out.println(Thread.currentThread().getName() + ": ho inserito \"" + item + "\" -> Nel buffer ci sono " + count + " elementi");

		notify();
	}

	public synchronized Object remove() throws InterruptedException
	{
		Object item;

		while(count == 0) // Se il buffer è vuoto, occorre sospendere momentaneamente il consumatore.
			wait();

		count--;
		item = buffer[out];	// "Rimuovo" l'elemento alla posizione out
		out = (out + 1) % BUFFER_SIZE;	// Incremento modulare dell'indice out

		if(count == 0)
			System.out.println(Thread.currentThread().getName() + ": ho rimosso \"" + item + "\" -> Il buffer è ora vuoto");
		else
			System.out.println(Thread.currentThread().getName() + ": ho rimosso \"" + item + "\" -> Nel buffer ci sono " + count + " elementi");

		notify();

		return item;
	}
}

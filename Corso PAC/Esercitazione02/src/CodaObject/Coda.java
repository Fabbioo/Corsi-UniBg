package CodaObject;

/**
 * Una coda è una struttura dati lineare nella quale gli accessi avvengono
 * secondo uno schema di tipo FIFO. Questo implica che gli inserimenti
 * aggiungono elementi alla fine della sequenza, mentre le cancellazioni ne
 * rimuovono sempre il primo elemento. In una coda, gli accessi avvengono quindi
 * ad entrambe le estremità della sequenza di elementi, e nessun elemento
 * interno può essere estratto prima che tutti quelli che lo precedono siano
 * stati estratti.
 */

public interface Coda {

	/**
	 * Verifica se la coda è vuota.
	 * 
	 * @return True se la coda è vuota. False altrimenti.
	 */
	public boolean isEmpty();

	/**
	 * Aggiungo l'elemento e al termine della sequenza di elementi presenti nella
	 * coda. In altre parole, aggiungo l'elemento e in coda alla coda.
	 * 
	 * @param e è l'elemento da mantenere nella coda.
	 */
	public void enqueue(Object e);

	/**
	 * Restituisco il primo elemento della sequenza di elementi presenti nella coda.
	 * 
	 * @return il primo elemento della coda.
	 */
	public Object first();

	/**
	 * Cancello il primo elemento della sequenza di elementi presenti nella coda.
	 * 
	 * @return l'elemento rimosso.
	 */
	public Object dequeue();
}

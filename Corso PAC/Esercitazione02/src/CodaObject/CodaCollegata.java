package CodaObject;

/**
 * La classe CodaCollegata implementa il tipo di dato Coda mediante una
 * collezione di n record contenenti ciascuno una coppia (elem, next), dove elem
 * è un elemento della coda e next è il puntatore al successivo record della
 * coda. La classe mantiene, inoltre, un puntatore (inizio) al primo record
 * della coda e un puntatore (fine) all'ultimo record della coda.
 */

public class CodaCollegata implements Coda {

	// Puntatore al primo record della coda.
	private Record inizio = null;

	// Puntatore all'ultimo record della coda.
	private Record fine = null;

	/*
	 * Classe definita localmente al tipo CodaCollegata per il mantenimento dei
	 * record contenenti le coppie (elem, next).
	 */
	private class Record {

		// Elemento da conservare nel record.
		public Object elem;

		// Puntatore al prossimo record nella coda.
		public Record next;

		/**
		 * Costruttore per l'allocazione di un nuovo record
		 * 
		 * @param e l'elemento da conservare nel record
		 */
		public Record(Object e) {
			this.elem = e;
			this.next = null;
		}
	}

	/**
	 * Verifica se la coda è vuota.
	 * 
	 * @return True se la coda è vuota. False altrimenti.
	 */
	public boolean isEmpty() {
		return this.inizio == null;
	}

	/**
	 * Aggiungo l'elemento e al termine della sequenza di elementi presenti nella
	 * coda.
	 * 
	 * @param e l'elemento da mantenere nella coda.
	 */
	public void enqueue(Object e) {
		if (this.isEmpty())
			this.inizio = this.fine = new Record(e);
		else {
			this.fine.next = new Record(e);
			this.fine = this.fine.next;
		}
	}

	/**
	 * Restituisce il primo elemento della sequenza di elementi presenti nella coda.
	 * 
	 * @return il primo elemento della coda.
	 * @throws EccezioneStrutturaVuota se la coda è vuota.
	 */
	public Object first() throws EccezioneStrutturaVuota {
		if (this.isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		return this.inizio.elem;
	}

	/**
	 * Cancella il primo elemento della sequenza di elementi presenti nella coda.
	 * 
	 * @return l'elemento rimosso.
	 * @throws EccezioneStrutturaVuota se la coda è vuota.
	 */
	public Object dequeue() {
		if (this.isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		Object e = this.inizio.elem;
		this.inizio = this.inizio.next;
		return e;
	}
}

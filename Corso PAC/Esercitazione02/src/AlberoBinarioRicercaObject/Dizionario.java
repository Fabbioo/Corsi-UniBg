package AlberoBinarioRicercaObject;

/**
 * Un dizionario è una collezione di elementi a cui sono associate delle chiavi.
 * 
 * Operazioni tipiche su un dizionario sono:
 * _ inserimento di un elemento a partire dal valore della chiave ad esso associata;
 * _ cancellazione di un elemento data la chiave;
 * _ ricerca dell'elemento associato ad una data chiave.
 * 
 * L'interfaccia presentata supporta le tre operazioni insert(), search() e delete() assumendo che
 * gli elementi da conservare nel dizionario siano oggetti di tipo Object e che le chiavi usate
 * per indicizzarle siano oggetti di tipo Comparable.
 */

public interface Dizionario {
	
	/**
	 * Aggiunge al dizionario la coppia (e,k).
	 * 
	 * @param e elemento da inserire nel dizionario.
	 * @param k chiave associata all'elemento.
	 */
	public void insert(Object e, Comparable k);	
	
	/**
	 * Rimuove dal dizionario l'elemento associato alla chiave k.
	 * 
	 * @param k chiave associata all'elemento.
	 */
	public void delete(Comparable k);
	
	/**
	 * Restituisce l'elemento associato alla chiave k.
	 * In caso di duplicati, l'elemento restituito viene scelto arbitrariamente tra quelli
	 * con chiave k.
	 * 
	 * @param k chiave dell'elemento da ricercare.
	 * @return elemento associato alla chiave k, null se assente.
	 */	
	public Object search(Comparable k);	
}

package AlberoBinarioRicercaObject;

import AlberoBinarioObject.*;

public class DizionarioImplements extends AlberoBinarioImplements implements Dizionario {

	protected Comparable returnChiave(NodoBinario nodo) {
		if (nodo == null)
			return null;
		else
			return ((Record) nodo.elem).chiave;
	}

	protected Object returnElemento(NodoBinario nodo) {
		if (nodo == null)
			return null;
		else
			return ((Record) nodo.elem).elemento;
	}

	/**
	 * Aggiunge all'albero la coppia (e,k).
	 * 
	 * @param e elemento da inserire nel dizionario.
	 * @param k chia)ve associata all'elemento.
	 */
	public void insert(Object elemento, Comparable chiave) {

		NodoBinario nb = new NodoBinario(new Record(elemento, chiave));

		if (radice == null)
			this.radice = nb;
		else {
			NodoBinario nodoCorrente = radice;
			NodoBinario nodoSuccessivo = null;
			while (nodoCorrente != null) {
				nodoSuccessivo = nodoCorrente;
				if (chiave.compareTo(returnChiave(nodoCorrente)) <= 0)
					nodoCorrente = nodoCorrente.sinistro;
				else
					nodoCorrente = nodoCorrente.destro;
			}

			// y e' il padre du z, e z sara' figlio sx o dx di y a seconda delle chiavi
			nodoCorrente.padre = nodoSuccessivo;
			if (chiave.compareTo(returnChiave(nodoSuccessivo)) <= 0)
				nodoSuccessivo.sinistro = nodoCorrente;
			else
				nodoSuccessivo.destro = nodoCorrente;
		}
	}

	/**
	 * Restituisce l'elemento <code>e</code> con chiave <code>k</code>. In caso di
	 * duplicati, l'elemento restituito &egrave; il record scelto arbitrariamente
	 * tra quelli con chiave <code>k</code>.
	 * 
	 * @param k chiave dell'elemento da ricercare
	 * @return elemento (l'intero record) di chiave k, null se assente o l'albero �
	 *         vuoto
	 */
	public Object search(Comparable k) {
		NodoBinario nodo = searchNodo(k, radice);
		if (nodo == null)
			return null;
		else
			return nodo.elem;
	}

	// Trova un nodo di chiave data
	private NodoBinario searchNodo(Comparable chiave, NodoBinario nodo) {
		while (nodo != null) {
			if (chiave.compareTo(returnChiave(nodo)) == 0)
				return nodo;// chiave trovata
			if (chiave.compareTo(returnChiave(nodo)) < 0)
				nodo = nodo.sinistro;// ricerca procede a sinistra
			else
				nodo = nodo.destro;// ricerca procede a destra
		}
		return null; // chiave non trovata o albero vuoto (v==radice==null)
	}

	/**
	 * Rimuove l'elemento di chiave k.
	 * 
	 * @param k chiave dell'elemento da ricercare
	 */
	public void delete(Comparable chiave) {
		// Ricerca del nodo u di chiave k da cancellare.
		NodoBinario nodo = searchNodo(chiave, radice);
		if (nodo != null) {
			// u ha al piu' un figlio (o e' foglia o ha un unico figlio)
			if (nodo == null || nodo.destro == null) {
				contraiNodo(nodo); // cancellazione effettiva di un nodo con al più un figlio
			} else {// u ha 2 figli
					// Si individua il predecessore v di u (il max del sottoalbero sinistro di u)
				NodoBinario v = max(nodo.sinistro);
				scambiaInfo(nodo, v);
				contraiNodo(v); // cancellazione effettiva di un nodo con al pi� un figlio
			}
		}
	}

	// cancella un nodo con al piu' un figlio
	private void contraiNodo(NodoBinario u) {
		NodoBinario v = null; // figlio (unico) del rimosso
		if (u.sinistro != null)
			v = u.sinistro;
		else if (u.destro != null)
			v = u.destro;
		if (v == null) // rimosso e' una foglia, la rimuovo
			pota(u);
		else {
			scambiaInfo(u, v); // rimpiazziamo il contenuto informativo del nodo con quello del figlio
			AlberoBinarioIF albf = pota(v); // potiamo il sottoalbero radicato nel figlio e lo restituiamo
			// riattacchiamo i sottoalberi sin e des del figlio nel nodo
			innestaSin(u, albf.pota(v.sinistro));
			innestaDes(u, albf.pota(v.destro));
		}
	}

	/**
	 * Ricerca del nodo con valore max della chiave nel sottoalbero radicato in u
	 * 
	 * @param u Nodo radice del sottoalbero
	 */
	public NodoBinario max(NodoBinario u) {
		NodoBinario v = u;
		while (v.destro != null)
			v = v.destro;// mi sposto piu' a destra possibile
		return v;
	}
}

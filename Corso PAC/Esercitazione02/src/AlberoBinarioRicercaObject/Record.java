package AlberoBinarioRicercaObject;

// Ogni nodo dell'albero è un oggetto Record.

class Record {

	public Object elemento;
	public Comparable chiave;

	public Record(Object elemento, Comparable chiave) {
		this.elemento = elemento;
		this.chiave = chiave;
	}

	public Object getElemento() {
		return elemento;
	}

	public Comparable getChiave() {
		return chiave;
	}

	public String toString() {
		return "(Elemento: " + elemento + ", chiave: " + chiave + ")";
	}
}
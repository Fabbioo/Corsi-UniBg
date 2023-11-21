package AlberoBinarioObject;

import java.util.List; // Per l'output delle visite.
import java.util.LinkedList; // Per l'output delle visite.
import java.util.Stack; // Per la visita DFS.

import CodaObject.*;

public class AlberoBinarioImplements implements AlberoBinarioIF {

	protected NodoBinario radice;

	// Costruttore di default.
	public AlberoBinarioImplements() {
		radice = null;
	}

	// Metodi costruttori: due varianti (uno con l'info ed uno direttamente con il
	// nodo)
	public AlberoBinarioImplements(Object e) {
		radice = new NodoBinario(e);
	}

	public AlberoBinarioImplements(NodoBinario rad) {
		radice = rad;
	}

	public NodoBinario radice() {
		return radice;
	}

	public int numNodi() {
		return numNodi(radice);
	}

	/**
	 * Restituisce il numero di nodi dell'albero radicato in un nodo r. Tale informazione viene definita
	 * conteggiando ricorsivamente il numero di nodi dei sottoalberi radicati nei figli di r.
	 * 
	 * @return Numero di nodi presenti nell'albero radicato in r.
	 */
	private int numNodi(NodoBinario r) {
		return r == null ? 0 : numNodi(r.sinistro) + numNodi(r.destro) + 1;
	}

	public int grado(NodoBinario v) {
		int grado = 0;
		if (v == null)
			return grado;
		if (v.sinistro != null)
			grado++;
		if (v.destro != null)
			grado++;
		return grado;
	}

	public Object info(NodoBinario v) {
		return v.elem;
	}

	public NodoBinario padre(NodoBinario v) {
		return v.padre;
	}
	
	public NodoBinario sin(NodoBinario v) {
		return v.sinistro;
	}

	public NodoBinario des(NodoBinario v) {
		return v.destro;
	}
	
	// Restituisce true se v è un figlio sinistro.
	public boolean figlioSinistro(NodoBinario v) {
		if (v.equals(v.padre.sinistro))
			return true;
		else
			return false;
	}

	// Restituisce true se v è un figlio destro.
	public boolean figlioDestro(NodoBinario v) {
		if (v.equals(v.padre.destro))
			return true;
		else
			return false;
	}

	public void cambiaInfo(NodoBinario v, Object info) {
		v.elem = info;
	}

	public void scambiaInfo(NodoBinario v1, NodoBinario v2) {
		Object app = v1.elem;
		v1.elem = v2.elem;
		v2.elem = app;
	}

	// Aggiungo "albero" come sottoalbero sinistro di "padre".
	public void innestaSin(NodoBinario padre, AlberoBinarioIF albero) {
		NodoBinario figlio = albero.radice();
		if (figlio != null)
			figlio.padre = padre;
		padre.sinistro = figlio;
	}

	// Aggiungo "albero" come sottoalbero destro di "padre".
	public void innestaDes(NodoBinario padre, AlberoBinarioIF albero) {
		NodoBinario figlio = albero.radice();
		if (figlio != null)
			figlio.padre = padre;
		padre.destro = figlio;
	}

	// Elimino il sottoalbero sinistro di "padre" e lo restituisco.
	public AlberoBinarioIF potaSinistro(NodoBinario padre) {
		NodoBinario figlio = padre.sinistro;
		figlio.padre = null;
		AlberoBinarioIF newalbero = new AlberoBinarioImplements(figlio);
		padre.sinistro = null;
		return newalbero;
	}

	// Elimino il sottoalbero destro di "padre" e lo restituisco.
	public AlberoBinarioIF potaDestro(NodoBinario padre) {
		NodoBinario figlio = padre.destro;
		figlio.padre = null;
		AlberoBinarioImplements newalbero = new AlberoBinarioImplements(figlio);
		padre.destro = null;
		return newalbero;
	}

	// Stacco e restituisco il sottoalbero radicato in un certo nodo "rimosso" dell'albero.
	public AlberoBinarioIF pota(NodoBinario rimosso) {
		
		if (rimosso == null)
			return new AlberoBinarioImplements(); // Albero vuoto.
		
		if (rimosso.padre == null) { // "rimosso" è la radice dell'albero.
			radice = null;
			return new AlberoBinarioImplements(rimosso); // restituiamo l'intero albero
		}

		NodoBinario pad = rimosso.padre;
		if (figlioSinistro(rimosso)) { // Se "rimosso" è figlio sinistro.
			AlberoBinarioIF newalbero = potaSinistro(pad);
			return newalbero;
		} else { // "rimosso" è figlio destro.
			AlberoBinarioIF newalbero = potaDestro(pad);
			return newalbero;
		}
	}

	// Restituisco la lista degli elementi in una visita DFS (iterativa).
	public List visitaDFS() {
		List output = new LinkedList(); // Lista di elementi in output.
		Stack<NodoBinario> pila = new Stack<NodoBinario>();
		if (radice != null)
			pila.push(radice);
		while (!pila.isEmpty()) {
			NodoBinario u = pila.pop(); // Richiederebbe il casting se usassimo la classe Stack non generica
			output.add(u.elem); // Metto in output corrente.
			// Inserisco in pila il figlio destro e poi quello sinistro.
			if (u.destro != null)
				pila.push(u.destro);
			if (u.sinistro != null)
				pila.push(u.sinistro);
		}
		return output;
	}

	// Restituisco la lista degli elementi in una visita BFS.
	public List visitaBFS() {
		List output = new LinkedList();
		Coda coda = new CodaCollegata();
		if (radice != null)
			coda.enqueue(radice);
		while (!coda.isEmpty()) {
			NodoBinario u = (NodoBinario) coda.dequeue();
			output.add(u.elem); // Il metodo add di LinkedList aggiunge il nuovo elemnto alla fine.
			// Inserisco in coda il figlio sinistro e poi quello destro.
			if (u.sinistro != null)
				coda.enqueue(u.sinistro);
			if (u.destro != null)
				coda.enqueue(u.destro);
		}
		return output;
	}
}

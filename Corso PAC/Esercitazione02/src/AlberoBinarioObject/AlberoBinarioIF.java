package AlberoBinarioObject;

import java.util.List;

/*
 * Il tipo di dato astratto Albero Binario, descritto dall'interfaccia AlberoBinario, rappresenta alberi 
 * radicati in cui il grado di ogni nodo è al più 2 (ovvero: ogni nodo possiede al massimo 2 figli).
 * I figli di un albero binario hanno pertanto un ordine e sono distinti in figlio sx e figlio dx. 
 * In un albero binario un nodo potrebbe avere un figlio sx, ma essere privo del dx e viceversa.
 * 
 * Le operazioni supportate permettono di recuperare informazioni sull'albero (radice, numero di nodi,
 * grado, padre, figlio sx, figlio dx e contenuto informativo di un nodo), di modificarne il contenuto 
 * informativo e la struttura (aggiungendo nodi oppure aggiungendo o rimuovendo interi sottoalberi come 
 * figli sinistri o destri di nodi preesistenti), o di visitarne i nodi in un ordine sistematico. 
 * 
 * Per riferirci ai nodi di un albero binario si usa il tipo NodoBinario. I riferimenti ai nodi vengono
 * generati dalle operazioni che creano nodi (aggiungiRadice, aggiungiFiglioSin e aggiungiFiglioDes) ed 
 * essi possono essere utilizzati in seguito per riferirsi ai nodi dell'albero.
 * 
 * Quando un sottoalbero viene staccato da un albero mediante l'operazione pota, esso diventa una istanza
 * di albero a sè stante, ma i riferimenti ai nodi rimangono gli stessi. 
 * In modo simile, quando un albero viene innestato in un altro, smette di essere un'istanza di albero a 
 * sè stante, ma conserva gli stessi riferimenti ai suoi nodi.
 */

public interface AlberoBinarioIF {

	/**
	 * Restituisce la radice dell'albero.
	 * 
	 * @return Radice dell'albero. Null se l'albero è vuoto.
	 */
	public NodoBinario radice();

	/**
	 * Restituisce il numero di nodi presenti nell'albero.
	 * 
	 * @return Numero di nodi presenti nell'albero.
	 */
	public int numNodi();

	/**
	 * Restituisce il numero di figli del nodo passato in input al metodo.
	 * 
	 * @param v è il nodo di cui si vuole conoscere il numero di figli.
	 * @return Numero di figli di v.
	 */
	public int grado(NodoBinario v);

	/**
	 * Restituisce il contenuto informativo del nodo passato in input al metodo.
	 * 
	 * @param v è il nodo di cui si vuole conoscere il contenuto informativo.
	 * @return Contenuto informativo di v.
	 */
	public Object info(NodoBinario v);

	/**
	 * Restituisce il padre del nodo passato in input al metodo.
	 * 
	 * @param v è il nodo di cui si vuole conoscere il padre.
	 * @return Padre del nodo v. Null se v è la radice.
	 */
	public NodoBinario padre(NodoBinario v);

	/**
	 * Restituisce il figlio sinistro del nodo passato in input al metodo.
	 * 
	 * @param v è il nodo di cui si vuole conoscere il figlio sinistro.
	 * @return Figlio sinistro del nodo v. Null se il figlio sinistro non è presente.
	 */
	public NodoBinario sin(NodoBinario v);

	/**
	 * Restituisce il figlio destro del nodo passato in input al metodo.
	 * 
	 * @param v è il nodo di cui si vuole conoscere il figlio destro.
	 * @return Figlio destro del nodo v. Null se il figlio destro non è presente.
	 */
	public NodoBinario des(NodoBinario v);

	/**
	 * Restituisce true se il nodo passato in input al metodo è davvero figlio sinistro.
	 * 
	 * @param v è il nodo di cui si vuole valutare se è davvero figlio sinistro.
	 * @return True se il nodo v è effettivamente figlio sinistro. False altrimenti.
	 */
	public boolean figlioSinistro(NodoBinario v);

	/**
	 * Restituisce true se il nodo passato in input al metodo è davvero figlio destro.
	 * 
	 * @param v è il nodo di cui si vuole valutare se è davvero figlio destro.
	 * @return True se il nodo v è effettivamente figlio destro. False altrimenti.
	 */
	public boolean figlioDestro(NodoBinario v);

	/**
	 * Cambia il contenuto informativo di un nodo.
	 * 
	 * @param v    è il nodo di cui si vuole cambiare il contenuto informativo.
	 * @param info è il nuovo contenuto informativo per il nodo v.
	 */
	public void cambiaInfo(NodoBinario v, Object info);

	/**
	 * Scambia il contenuto informativo di due nodi.
	 * 
	 * @param v1 e v2 sono i due nodi di cui si vuole scambiare il contenuto informativo.
	 */
	public void scambiaInfo(NodoBinario v1, NodoBinario v2);

	/**
	 * Inserisce un sottoalbero nell'albero come figlio sinistro di un nodo preesistente.
	 * 
	 * @param u      è il nodo a cui "attaccare" il sottoalbero.
	 * @param albero è l'albero la cui radice diventa figlio sinistro di u.
	 */
	public void innestaSin(NodoBinario u, AlberoBinarioIF sottoalbero);

	/**
	 * Inserisce un sottoalbero nell'albero come figlio destro di un nodo preesistente.
	 * 
	 * @param u      è il nodo a cui "attaccare" il sottoalbero.
	 * @param albero è l'albero la cui radice diventa figlio destro di u.
	 */
	public void innestaDes(NodoBinario u, AlberoBinarioIF sottoalbero);

	/**
	 * Stacca e restituisce il sottoalbero sinistro di un certo nodo dell'albero.
	 * 
	 * @param padre è il nodo padre da cui staccare il sottoalbero sinistro.
	 * @return Sottoalbero sinistro di padre.
	 */
	public AlberoBinarioIF potaSinistro(NodoBinario padre);

	/**
	 * Stacca e restituisce il sottoalbero destro di un certo nodo dell'albero.
	 * 
	 * @param padre è il nodo padre da cui staccare il sottoalbero destro.
	 * @return Sottoalbero destro di padre.
	 */
	public AlberoBinarioIF potaDestro(NodoBinario padre);

	/**
	 * Stacca e restituisce il sottoalbero radicato in un certo nodo dell'albero.
	 * 
	 * @param v è la radice del sottoalbero da staccare.
	 * @return Sottoalbero radicato in v.
	 */
	public AlberoBinarioIF pota(NodoBinario v);

	/**
	 * Restituisce la lista dei nodi dell'albero nell'ordine in cui vengono
	 * incontrati da una visita in profondità (Depth First Search, DFS).
	 * 
	 * @return la lista dei nodi incontrati durante la visita DFS.
	 */
	public List visitaDFS();

	/**
	 * Restituisce la lista dei nodi dell'albero nell'ordine in cui vengono
	 * incontrati da una visita in ampiezza (Breadth First Search, BFS).
	 * 
	 * @return la lista dei nodi incontrati durante la visita BFS.
	 */
	public List visitaBFS();
}

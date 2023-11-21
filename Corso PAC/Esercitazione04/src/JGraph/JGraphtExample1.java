package JGraph;

/*
 * Per utilizzare correttamente tutto ciò che riguarda la libreria JGraph segui:
 * File > New > Java project;
 * Inserisci il nome che vuoi > Next >
 * Nella sezione Libraries posizionati esplicitamente su Classpath > Add External JARs...
 * Da lì selezioni i vari file .jar da inserire.
 * Per inserire la documentazione javadoc puoi tranquillamente seguire la guida di GitHub.
 * Fai solo attenzione che per inserire la documentazione devi stare sempre in Classpath (quello dei
 * punti precedenti, espandere le tre librerie e da lì inserire i percorsi SIA per "Sourch attachment"
 * SIA per Javadoc location.
 */

import org.jgrapht.graph.*;
import org.jgrapht.*;
import java.util.List; 
import java.util.Set;

public class JGraphtExample1 {
	
	public static void main(String[] args) { 
		
		// Creo un grafo semplice orientato di stringhe:
        Graph<String, DefaultEdge> grafo =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        	// I vertici sono di tipo String.
        	// Gli archi sono rappresentati mediante la classe DefaultEdge, la quale, per essere
        	// utilizzata, richiede che venga specificato all'interno di parentesi tonde anche la
        	// clausola DefaultEdge.class.
        
		// Aggiungo i vertici invocando il metodo addVertex() sull'oggetto grafo:
		grafo.addVertex("1");
		grafo.addVertex("2");
		grafo.addVertex("3");
		grafo.addVertex("4");
		grafo.addVertex("5");
		grafo.addVertex("6");
		grafo.addVertex("7");
		
		// Una volta aggiunti i vertici, devo aggiungere anche gli archi che li connettono.
		// Per aggiungere un archi sfrutto il metodo addEdge() invocato sull'oggetto grafo.
		// I parametri di input sono i vertici che voglio collegare tramite l'arco.
		grafo.addEdge("1", "2");
		grafo.addEdge("2", "5");
		grafo.addEdge("5", "1");
		grafo.addEdge("5", "4");
		grafo.addEdge("4", "3");
		grafo.addEdge("4", "6");
		grafo.addEdge("6", "4");
		grafo.addEdge("3", "6");
		grafo.addEdge("7", "3");
		
		// Stampo il grafo:
		System.out.println(grafo.toString());
			// Il metodo toString() stampa sia i singoli vertici che compongono il grafo sia i vertici
			// che sono connessi mediante archi.

		// Visita sistematica delle liste di adiacenza.
		// Per ogni nodo scorro tutti i suoi archi uscenti e li stampo.
		// Restituisce l'insieme di vertici presenti nel grafo.
		Set<String> vertici = grafo.vertexSet();
		
		// Esploro tutti gli elementi (vertici) contenuti in vertici e stampo la lista di adiacenza:
		for(String s : vertici) {
			
			System.out.print(s + ":");
			
			// Per accedere alla lista di adiacenza sfrutto il metodo statico successorListOf():
			List<String> succ = Graphs.successorListOf(grafo, s);
				// Il parametro di input s è il vertice di cui voglio conoscere la lista di adiacenza.
			
			for(String l : succ)
				System.out.print(" " + l);
			
			 System.out.println(""); // Serve solo per andare a capo.
		}
	}
}
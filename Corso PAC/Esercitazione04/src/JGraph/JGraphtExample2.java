package JGraph;

import org.jgrapht.graph.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class JGraphtExample2 {
	
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
		
		// Per applicare l'algoritmo di Dijkstra innanzitutto devo creare un oggetto DijkstraShortestPath.
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg =
            new DijkstraShortestPath<>(grafo);
        
        // Suppongo di voler stampare il cammino minimo che va dal nodo che contiene 1 a quello che contiene 3.
        System.out.println("\nShortest path from 1 to 3:");
        
        // Computa tutti i cammini minimi da un certo nodo sorgente verso tutti i vertici del grafo.
        SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("1");
        	// Da notare che non è stato specificato alcun peso per gli archi. Questo perchè gli archi in
        	// questione sono DefaultEdge, ovvero senza peso.
        	// Se il peso non viene specificato come in questo caso, sia assume che sia unitario.
        
        System.out.println(iPaths.getPath("3"));
        	// L'oggetto iPaths contiene tutti tutti i cammini minimi che partono dal vertice che contiene "1".
        	// Tramite il metodo getPath() posso richiedere all'oggetto iPaths di restituire il cammino minimo
        	// che congiunge il vertice che contiene "1" con quello che contiene "3".
        
        // Stampa il peso del cammino minimo.
        System.out.println("Peso del cammino minimo: " + iPaths.getWeight("3") + "\n");

        // Suppongo di voler stampare le stesse informazioni di cui sopra, però facendo riferimento ad un
        // cammino minimo che non esiste.
        System.out.println("Shortest path from 1 to 7:");
        	// So già che non esiste un cammino minimo che possa congiungere il vertice che contiene "1" con
        	// quello che contiene "7".
        
        SingleSourcePaths<String, DefaultEdge> cPaths = dijkstraAlg.getPaths("1");
        
        System.out.println(cPaths.getPath("7"));
        	// Dato che non esiste un cammino minimo, il metodo getPath() restituisce null.
        
        System.out.println(iPaths.getWeight("7") + "\n");
        	// Dato che non esiste un cammino minimo, il peso del cammino è impostato per default a
        	// Double.POSITIVE_INFINITY.
	}
}
package JGraph;

import org.jgrapht.graph.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class JGraphtExample2bis {
	
	public static void main(String[] args) {
		
		// Creo un grafo semplice orientato PESATO di stringhe:
        Graph<String, DefaultWeightedEdge> grafo =
            new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        
        // Aggiungo i vertici invocando il metodo addVertex() sull'oggetto grafo:
		grafo.addVertex("1");
		grafo.addVertex("2");
		grafo.addVertex("3");
		grafo.addVertex("4");
		grafo.addVertex("5");
		grafo.addVertex("6");
		grafo.addVertex("7");
		
		// Dichiaro un arco come oggetto della classe DefaultWeightedEdge e definisco un arco che connette i
		// vertici che contengono rispettivamente "1" e "2":
		DefaultWeightedEdge arco = grafo.addEdge("1", "2");
		
		// grafo.setEdgeWeight(arco, -4.0);//java.lang.IllegalArgumentException: Negative edge weight not allowed
		
		// Tramite il metodo setEdgeWeight() posso aggiungere un peso all'arco passato in input.
		grafo.setEdgeWeight(arco, 4.0);
		
		arco = grafo.addEdge("2", "5");
		grafo.setEdgeWeight(arco, 3.4);
		
		arco = grafo.addEdge("5", "1");
		grafo.setEdgeWeight(arco, 1);
		
		arco = grafo.addEdge("5", "4");
		grafo.setEdgeWeight(arco, 23.0);
		
		arco = grafo.addEdge("4", "3");
		grafo.setEdgeWeight(arco, 1);
		
		arco = grafo.addEdge("4", "6");
		grafo.setEdgeWeight(arco, 1);
		
		arco = grafo.addEdge("6", "4");
		grafo.setEdgeWeight(arco, 12);
		
		arco = grafo.addEdge("3", "6");
		grafo.setEdgeWeight(arco, 5);
		
		grafo.setEdgeWeight(grafo.addEdge("7", "3"),1); // In forma compatta!
		
		// Stampo il grafo:
		System.out.println(grafo.toString());
		    
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
            new DijkstraShortestPath<>(grafo);
        
        // Suppongo di voler stampare il cammino minimo che va dal nodo che contiene 1 a quello che contiene 3.
        System.out.println("\nShortest path from 1 to 3:");
        
        // Computa tutti i cammini minimi da un certo nodo sorgente verso tutti i vertici del grafo.
        SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths("1");
        
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
        
        SingleSourcePaths<String, DefaultWeightedEdge> cPaths = dijkstraAlg.getPaths("1");
        
        System.out.println(cPaths.getPath("7"));
        	// Dato che non esiste un cammino minimo, il metodo getPath() restituisce null.
        
        System.out.println(iPaths.getWeight("7") + "\n");
        	// Dato che non esiste un cammino minimo, il peso del cammino è impostato per default a
        	// Double.POSITIVE_INFINITY.
	}
}
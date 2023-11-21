package JGraph;

import org.jgrapht.graph.*;
import org.jgrapht.*;
import org.jgrapht.traverse.*;

import java.util.Iterator;


public class JGraphtExample1_bis {
	
	public static void main(String[] args) {
		
		// Creo un grafo semplice orientato di stringhe:
        Graph<String, DefaultEdge> grafo =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        
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
		
		// Visita in profondità con un iteratore.
		// Creo un iteratore che itera sulle stringhe sfruttando la classe DepthFirstIterator.
		Iterator<String> iterator = new DepthFirstIterator<>(grafo, "1");
			// DepthFirstIterator restituisce un iteratore che implementa la logica di visita in profondità.
		
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s); // Mi limito a stampare a video solo i vertici.
        }
	}
}
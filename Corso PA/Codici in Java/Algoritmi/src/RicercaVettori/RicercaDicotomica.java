package RicercaVettori;

public class RicercaDicotomica {
	
	static <T extends Comparable<T>, E extends T> boolean ricercaDicotomicaBoolean(E[] array, T indice) {
		
		int i = 0; // Indice che scorre da sinistra verso destra.
		int j = array.length - 1; // Indice che scorre da destra verso sinistra.
		int m = 0;

		for (;;) { // Sfrutto un for infinito per scorrere tutto l'array.
			
			m = (i + j) / 2; // Calcolo elemento centrale dell'array.
			
			if (array[m].equals(indice))
				return true;
			
			if (array[m].compareTo(indice) < 0)
				i = m + 1;
			else
				j = m - 1;
			
			if (j < i)
				// Nel momento in cui j < i si configura la situazione per cui l'indice sinistro
				// ha superato la metà e quindi non è stato trovato l'elemento.
				return false;
		}
	}
	
	static <T extends Comparable<T>, E extends T> Integer ricercaDicotomicaPosizione(E[] array, T indice) {
		
		int i = 0; // Indice che scorre da sinistra verso destra.
		int j = array.length - 1; // Indice che scorre da destra verso sinistra.
		int m = 0;

		for (;;) { // Sfrutto un for infinito per scorrere tutto l'array.

			m = (i + j) / 2; // Calcolo elemento centrale dell'array.
			
			if (array[m].equals(indice))
				return (m + 1);
			
			if (array[m].compareTo(indice) < 0)
				i = m + 1;
			else
				j = m - 1;
			
			if (j < i)
				// Nel momento in cui j < i si configura la situazione per cui l'indice sinistro
				// ha superato la metà e quindi non è stato trovato l'elemento.
				return null;
		}
	}
}

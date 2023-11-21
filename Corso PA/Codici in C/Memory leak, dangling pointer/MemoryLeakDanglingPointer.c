#include <stdio.h>
#include <stdlib.h>

void memoryLeak() {

	/*
	 * Un memory leak è un particolare tipo di consumo non voluto di memoria dovuto alla mancata
	 * deallocazione della stessa da variabili e dati che non devono essere più utilizzati.
	 * Operativamente, una mancata free() a seguito di una malloc() causa problemi di memory leak.
	 *
	 * Per "perdita di memoria" si intende una zona di memoria a cui non si può più accedere
	 * perchè risulta essere occupata.
	 */

	int *bufferLeak = (int*) malloc(10 * sizeof(int));
	/*
	 * bufferLeak è una variabile puntatore a intero che risiede nello stack e che punta ad
	 * una zona di memoria dello heap di dimensione 10*sizeof(int). In altre parole, la
	 * memoria istanziata tramite malloc() ha una capacità di 10 interi.
	 */
	bufferLeak[0] = 9;
	bufferLeak[1] = 5;
	printf("Memory leak: %d\n", *bufferLeak);
	printf("Memory leak: %d\n", *(bufferLeak + 1));

	/*
	 * Quando termina l'esecuzione della funzione memoryLeak() il suo record di attivazione nello
	 * stack viene cancellato. Attenzione: SOLO IL CONTENUTO DELLO STACK VIENE ELIMINATO!
	 * NON ESSENDO ESPLICITATA UNA free() SI HA CHE LA MEMORIA HEAP CONTINUA A RIMANERE ISTANZIATA
	 * PERCHè VIENE PUNTATA "DA QUALCOSA".
	 */

	// Guarda il record di attivazione su OneNote per capire la dinamica del codice.
}

void danglingPointer() {

	int *danglingPointer = (int*) malloc(10 * sizeof(int));
	/*
	 * danglingPointer è una variabile puntatore a intero che risiede nello stack e che punta ad
	 * una zona di memoria dello heap di dimensione 10*sizeof(int). In altre parole, la
	 * memoria istanziata tramite malloc() ha una capacità di 10 interi.
	 */

	danglingPointer[0] = 7;
	danglingPointer[2] = 71;

	printf("\nDangling pointer pre: %d\n", *danglingPointer);
	printf("Dangling pointer pre: %d\n", *(danglingPointer + 1));
	printf("Dangling pointer pre: %d\n", *(danglingPointer + 2));

	free(danglingPointer);

	/*
	 * A seguito dell'esecuzione di free(danglingPointer) si ha che dalla memoria heap viene
	 * liberato lo spazio precedentemente allocato per mezzo di malloc(10 * sizeof(int)).
	 *
	 * Attenzione: IL PUNTATORE danglingPointer RISIEDE NELLO STACK E CONTINUA AD ESISTERE ANCHE
	 * DOPO L'ESECUZIONE DI free(danglingPointer). LA free(danglingPointer) ha il solo effetto di
	 * cancellare il contenuto puntato dal puntatore, MA IL PUNTATORE CONTINUA AD ESISTERE.
	 * In altre parole, la free() ha l'effetto di liberare dai dati la memoria heap, ma il
	 * puntatore che viene specificato nella free(), dato che risiede nello stack e non nella
	 * memoria heap, non ne risente e continua ad esistere in memoria.
	 *
	 * In altre parole, a questo punto danglingPointer è un dangling pointer.
	 */

	printf("\nDangling pointer post: %d", *danglingPointer);
}

int main() {

	memoryLeak();
	danglingPointer();

	return 0;
}

#ifndef COUNTER_H_
#define COUNTER_H_

// Per semplicità definisco un nuovo tipo di dato, così da non dover per forza utilizzare tutte le volte
// la notazione "struct counter *".
typedef struct counter *counterRef;
	// Le variabili di tipo counterRef sono puntatori che puntano a oggetti di tipo struct counter.

/*
 * Nota: dato che counter_ref è definito come puntatore non devo passare alle funzioni dei parametri
 * formali di tipo counterRef*, bensì di tipo counterRef.
 */

// Dichiaro il costruttore di oggetti di tipo struct counter.
counterRef makeCounter();

/*
 * Avendo definito il tipo dell'oggetto da creare e il suo costruttore, posso passare alla definizione
 * dei prototipi delle operazioni che gli oggetti di tipo struct counter devono essere in grado di fare.
 */

// Nota che quando si definisce un prototipo si può non esplicitare il nome dei parametri formali.
void reset(counterRef);
void incremento(counterRef);
void decremento(counterRef);
int getValue(counterRef);
void delete(counterRef);
	/*
	 * Per i tipi opachi è buona norma creare dei distrutturi di memoria. Nel costruttuore makeCounter()
	 * ho utilizzato malloc, ma la memoria allocata dinamicamente non viene liberata in automatico quando
	 * il programma termina. Il metodo delete() è presente per sopperire a questa mancanza.
	 */

#endif /* COUNTER_H_ */

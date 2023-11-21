/*
 * Nel file counter.c devo fornire l'implementazione di tutti i metodi il cui prototipo è definito
 * all'interno del file header counter.h
 */

#include <stdlib.h>
#include "counter.h"

/*
 * Come prima cosa devo definire il corpo del tipo struct counter, ovvero il tipo dell'oggetto che
 * risiede nella memoria heap e che viene puntato da una variabile allocata sullo stack di tipo
 * counterRef.
 */
struct counter {
	int valore;
} Counter; // In questo modo mi posso riferire al tipo struct counter sfruttando solo Counter.

// Definisco il costruttore makeCounter().
counterRef makeCounter() {

	// Dato che counterRef è un tipo puntatore, prima di memorizzare dati è necessario allocare
	// dinamicamente la memoria.
	counterRef contatore = (counterRef) malloc(sizeof(Counter));
	// contatore è un puntatore che risiede nello stack e che punta alla regione dello heap in cui
	// è stata allocata una memoria di dimensione struct counter.

	// Inizializzo i campi dell'oggetto contatore:
	contatore->valore = 0;

	return contatore;
}

// Definisco il metodo reset().
void reset(counterRef c) {
	c->valore = 0;
}

// Definisco il metodo incremento().
void incremento(counterRef c) {
	c->valore++;
}

// Definisco il metodo decremento().
void decremento(counterRef c) {
	c->valore--;
}

// Definisco il metodo getValue().
int getValue(counterRef c) {
	return c->valore;
}

void delete(counterRef c) {
	free(c);
	// c è un puntatore di tipo counterRef e la free() dealloca la memoria occupata da c.
	// Il metodo delete() è una sorta di distruttore del tipo opaco struct counter.
}

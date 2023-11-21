#include <stdlib.h>
#include <stdio.h>
#include "bitvector.h"

struct bitvector {
	int dimensione; // Dimensione del vettore.
	char *data; // Contenuto vero e proprio del vettore di bit.
} BitVector;

bitVector makeBitVector(int n) {

	bitVector result = (bitVector) malloc(sizeof(BitVector));

	result->dimensione = n;

	result->data = (char*) malloc(sizeof(char) * n);

	// Decido di riempire il vettore di bit con metà 0 e metà 1:
	for (int i = 0; i < n; i++)
		if (i < n / 2)
			result->data[i] = 0;
		else
			result->data[i] = 1;

	return result;
}

bitVector AND(bitVector b1, bitVector b2) {

	if (b1->dimensione == b2->dimensione) {
		bitVector risultato = makeBitVector(b1->dimensione);
		for (int i = 0; i < b1->dimensione; i++)
			risultato->data[i] = b1->data[i] && b2->data[i];
		return risultato;
	} else {
		printf("I bitvector non sono confrontabili.");
		return NULL;
	}
}

bitVector OR(bitVector b1, bitVector b2) {

	if (b1->dimensione == b2->dimensione) {
		bitVector result = makeBitVector(b1->dimensione);
		for (int i = 0; i < b1->dimensione; i++)
			result->data[i] = b1->data[i] || b2->data[i];
		return result;
	} else {
		printf("I bitvector non sono confrontabili.");
		return NULL;
	}
}

bitVector NOT(bitVector b) {

	bitVector result = makeBitVector(b->dimensione);

	for (int i = 0; i < b->dimensione; i++)
		result->data[i] = !b->data[i];

	return result;
}

char* toString(bitVector b) {

	char *stringa = (char*) malloc(sizeof(char) * (b->dimensione + 1)); // + 1 serve per il terminatore.
	stringa[0] = '\0';

	for (int i = 0; i < b->dimensione; i++)
		if (b->data[i] == 0)
			stringa[i] = '0';
		else
			stringa[i] = '1';

	// Aggiungo esplicitamente il carattere terminatore:
	stringa[b->dimensione] = '\0';

	return stringa;
}

void delete(bitVector *b) { // b è un puntatore a puntatore
	free((*b)->data);
	free(*b);
	*b = NULL;
}

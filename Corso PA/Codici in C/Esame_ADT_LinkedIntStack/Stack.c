#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "Stack.h"

#define DIM 1000 // Dimensione array interno

struct stackk {
	int numElem;
	int vettore[DIM];
} Stack;

stackRef creaStack() {
	stackRef pila = (stackRef) malloc(sizeof(Stack));
	pila->numElem = 0;
	return pila;
}

void push(stackRef sr, int numero) {
	sr->vettore[sr->numElem] = numero;
	sr->numElem++;
}

int pop(stackRef sr) {
	if (sr->numElem == 0) {
		printf("\nStack vuoto!");
		exit(1);
	} else {
		int ultimoElementoAggiunto = sr->vettore[sr->numElem - 1];
		sr->numElem--;
		return ultimoElementoAggiunto;
	}
}

bool isEmpty(stackRef sr) {
	return sr->numElem == 0;
}

char* toString(stackRef sr) {
	char *stringa = (char*) malloc(sizeof(char) * (sr->numElem + 50));
	sprintf(stringa, "[");
	for (int i = 0; i < sr->numElem; i++) {
		sprintf(stringa, "%s%d", stringa, sr->vettore[i]);
		if (i < sr->numElem - 1)
			sprintf(stringa, "%s, ", stringa);
	}
	sprintf(stringa, "%s]", stringa);
	return stringa;
}

void cancellaStack(stackRef sr) {
	sr->numElem = 0;
}

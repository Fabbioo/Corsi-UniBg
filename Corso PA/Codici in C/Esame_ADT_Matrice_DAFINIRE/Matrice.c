#include "Matrice.h"
#include <stdlib.h>
#include <stdio.h>

struct matrice {
	int n;
	int *puntatoreMatrice;
} Matrice;

matriceRef creaMatrice(int dimensione) {
	matriceRef nuovaMatrice = (matriceRef) malloc(sizeof(Matrice));
	nuovaMatrice->puntatoreMatrice = (int*) malloc(sizeof(int) * dimensione);
	nuovaMatrice->n = dimensione;
	for (int i = 0; i < dimensione; i++) {
		nuovaMatrice->puntatoreMatrice[i] = *(int*) malloc(
				sizeof(int) * dimensione);
		for (int j = 0; j < dimensione; j++)
			*nuovaMatrice->puntatoreMatrice = 0;
	}
	return nuovaMatrice;
}

char* toString(matriceRef mr) {
	char *stringa = (char*) malloc(sizeof(char) * (mr->n * mr->n));
	for (int i = 0; i < mr->n; i++) {
		for (int j = 0; j < mr->n; j++)
			sprintf(stringa, "%s%d ", stringa, *mr->puntatoreMatrice);
		sprintf(stringa, "%s\n", stringa);
	}
	return stringa;
}

void sett(matriceRef mr, int numero, int ascissa, int ordinata) {
	// TODO
}

matriceRef somma(matriceRef mr1, matriceRef mr2) {
	matriceRef matriceSomma = (matriceRef) malloc(sizeof(Matrice));
	// TODO
	return matriceSomma;
}

void cancella(matriceRef *mr) {
	free((*mr)->puntatoreMatrice);
	free(*mr);
	*mr = NULL;
}

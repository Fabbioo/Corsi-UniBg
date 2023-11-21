/*
 Scrivi una funzione in C che data un array di numeri,
 restituisce la stringa contenente concatenati solo i numeri
 dispari e positivi (>0) della lista. Esempio {-6,1,3,2,9} -> �139�
 Scrivi tre versioni: una non ricorsiva e una ricorsiva
 senza e una con tail recursion. Scrivi anche un main di
 esempio in cui chiami la funzione con almeno
 i seguenti array: {-6,1,3,2,9}, {0,0,0,10}, {1,3}.
 Non usare alcuna variabile globale.
 Puoi assumere che un numero intero abbia al massimo 10 cifre */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* f_iterativa(int *vettore, int dimensione) {

	char *risultato = (char*) malloc(sizeof(char) * (dimensione + 1));
	risultato[0] = '\0';

	for (int i = 0; i < dimensione; i++) {
		if (vettore[i] > 0 && vettore[i] % 2 != 0)
			sprintf(risultato, "%s%d", risultato, vettore[i]);
	}
	return risultato;
}

char* f_ricorsiva(int *vettore, int dimensione) {

	if (dimensione == 0) {
		char *risultato = (char*) malloc(sizeof(char));
		risultato[0] = '\0';
		return risultato;
	}

	char *elemento = f_ricorsiva(vettore + 1, dimensione - 1);

	if (*vettore <= 0 || *vettore % 2 == 0)
		return elemento;

	char *risultato = (char*) malloc(sizeof(char) * (dimensione + 1));

	sprintf(risultato, "%d%s", *vettore, elemento);

	return risultato;
}

char* f_tailrecursion(int *vettore, int dimensione, char *risultato) {

	if (dimensione == 0)
		return risultato;

	if (*vettore > 0 && *vettore % 2 != 0)
		sprintf(risultato, "%s%d", risultato, *vettore);

	return f_tailrecursion(vettore + 1, dimensione - 1, risultato);
}

char* f_rico_tail(int *vettore, int dimensione) {
	char *risultato = (char*) malloc(sizeof(char) * (dimensione + 1));
	risultato[0] = '\0';
	return f_tailrecursion(vettore, dimensione, risultato);
}

int main() {

	int a1[] = { 5, 4, -7, 1, 3, 2, 9 };
	int dimensione1 = sizeof(a1) / sizeof(int);

	int a2[] = { 0, 0, 0, 10 };
	int dimensione2 = sizeof(a2) / sizeof(int);

	int a3[] = { 1, 3 };
	int dimensione3 = sizeof(a3) / sizeof(int);

	printf("risultato iter: %s\n", f_iterativa(a1, dimensione1));
	printf("risultato rico: %s\n", f_ricorsiva(a1, dimensione1));
	printf("risultato tail: %s\n", f_rico_tail(a1, dimensione1));

	printf("risultato iter: %s\n", f_iterativa(a2, dimensione2));
	printf("risultato rico: %s\n", f_ricorsiva(a2, dimensione2));
	printf("risultato tail: %s\n", f_rico_tail(a2, dimensione2));

	printf("risultato iter: %s\n", f_iterativa(a3, dimensione3));
	printf("risultato rico: %s\n", f_ricorsiva(a3, dimensione3));
	printf("risultato tail: %s\n", f_rico_tail(a3, dimensione3));

	return 0;
}

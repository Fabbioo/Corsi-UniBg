#include <stdio.h>

/*
 * Traccia.
 * Fa un esempio in C in cui usi il puntatore a puntatore per definire una funzione del1Int che serve per
 * togliere il primo intero in un puntatore a buffer di interi (int*). Nota che del1Int dovrà modificare
 * il puntatore e non il buffer. Esempio se ho int a[] = {1,2,3}; int* p = a; e faccio del1Int(p), p punterà
 * a {2,3} ma a sarà invariato.
 */

void del1Int(int **p) {
	(*p)++;
}

int main() {

	int buffer[] = { 1, 2, 3 };
	int dimensione = sizeof(buffer) / sizeof(int);

	printf("Buffer iniziale: ");
	for (int i = 0; i < dimensione; i++)
		printf("%d ", buffer[i]);

	int *p = buffer;

	printf("\nInizialmente p punta a: %d", *p);

	del1Int(&p);

	printf("\n\nIl buffer non è stato modificato, infatti: ");
	for (int i = 0; i < dimensione; i++)
		printf("%d ", buffer[i]);

	printf("\nIl puntatore p è stato modificato, infatti punta a: %d", *p);

	return 0;
}

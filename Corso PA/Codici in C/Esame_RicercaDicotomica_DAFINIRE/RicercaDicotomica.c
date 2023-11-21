#include <stdio.h>
#include <stdbool.h>

#define btoa(x) ((x) ? "True" : "False")

/*
 * Traccia.
 * Scrivi una funzione in C che dato in ingresso un array ordinato di numeri interi ricerca in esso mediante
 * la ricerca dicotomica un numero passato e restituisce true se lo trova, false altrimenti.
 * Scrivi tre versioni: una non ricorsiva e una ricorsiva senza e una con tail recursion.
 * Scrivi anche un main di esempio in cui chiami la funzione con almeno i seguenti array:
 * {-6,1,3,7,9} - > cerco 0, 3, 10 (mi aspetto false, true, false);
 * {1,3} -> cero 1 e -1 (mi aspetto true e false);
 * {} -> cerco 10 e 20.  (mi aspetto false e false).
 * Non usare alcuna variabile globale.
 */

// HO IMPLEMENTATO LA VERSIONE ITERATIVA E QUELLA RICORSIVA SENZA TAIL.

bool ricercaDicotomica_iter(int array[], int size, int target) {
	bool trovato = false;
	if (size == 0)
		return trovato;
	int sx = 0;
	int dx = size - 1;
	while (sx <= dx) {
		int centro = (sx + dx) / 2;
		if (array[centro] == target) {
			trovato = true;
			break;
		}
		if (target > array[centro])
			sx = centro + 1;
		else
			dx = centro - 1;
	}
	return trovato;
}

bool ricercaDicotomica_rico_notail(int array[], int size, int target, int sx, int dx) {
	if (sx > dx)
		return false;
	int centro = (sx + dx) / 2;
	if (array[centro] == target)
		return true;
	else {
		if (array[centro] > target)
			return ricercaDicotomica_rico_notail(array, size, target, sx, centro - 1);
		else
			return ricercaDicotomica_rico_notail(array, size, target, centro + 1, size);
	}
}

bool ricercaDicotomica_rico(int array[], int size, int target) {
	return ricercaDicotomica_rico_notail(array, size, target, 0, size - 1);
}

int main() {

	int array[] = { -6, 1, 3, 7, 9 };

	printf("Numero 0? %s\n", btoa(ricercaDicotomica_iter(array, sizeof(array) / sizeof(int), 0)));
	printf("Numero 3? %s\n", btoa(ricercaDicotomica_iter(array, sizeof(array) / sizeof(int), 3)));
	printf("Numero 10? %s\n", btoa(ricercaDicotomica_iter(array, sizeof(array) / sizeof(int), 10)));

	printf("\nNumero 0? %s\n", btoa(ricercaDicotomica_rico(array, sizeof(array) / sizeof(int), 0)));
	printf("Numero 3? %s\n", btoa(ricercaDicotomica_rico(array, sizeof(array) / sizeof(int), 3)));
	printf("Numero 10? %s\n", btoa(ricercaDicotomica_rico(array, sizeof(array) / sizeof(int), 10)));

//printf("\nIl numero 0 è presente nell'array? %s\n",
//		btoa(ricercaDicotomica_tail(array, sizeof(array) / sizeof(int), -6)));
//printf("Il numero 3 è presente nell'array? %s\n",
//		btoa(ricercaDicotomica_tail(array, sizeof(array) / sizeof(int), 3)));
//printf("Il numero 10 è presente nell'array? %s\n",
//		btoa(ricercaDicotomica_tail(array, sizeof(array) / sizeof(int), 10)));

	return 0;
}

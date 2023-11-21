#include <stdio.h>
#include <stdbool.h>

void stampaVettore(int *vettore, int dimensione) {
	for (int i = 0; i < dimensione; i++)
		printf("%d ", vettore[i]);
}

void bubbleSort_iter(int *vettore, int dimensione) {
	bool scambiato = false;
	int temp;
	do {
		scambiato = false;
		for (int i = 1; i < dimensione; i++)
			if (vettore[i - 1] > vettore[i]) {
				temp = vettore[i - 1];
				vettore[i - 1] = vettore[i];
				vettore[i] = temp;
				scambiato = true;
			}
	} while (scambiato);
}

int main() {

	int vettore[] = { -6, 7, -9, 1, 3 };
	int dimensione = sizeof(vettore) / sizeof(int);

	printf("Vettore di partenza: ");
	stampaVettore(vettore, dimensione);

	printf("\nVettore ordinato iter: ");
	bubbleSort_iter(vettore, dimensione);
	stampaVettore(vettore, dimensione);

	return 0;
}

#include <stdio.h>

// Versione iterativa:
int somma_iter(int *vettore, int dimensione) {
	int result = 0;
	for (int i = 0; i < dimensione; i++)
		if (vettore[i] % 2 == 0)
			result += vettore[i];
	return result;
}

// Versione ricorsiva senza tail:
int somma_rico(int *vettore, int dimensione) {
	if (dimensione == 0)
		return 0;
	int temp = somma_rico(vettore + 1, dimensione - 1);
	return ((*vettore % 2 == 0) ? *vettore : 0) + temp;
}

// Versione tail ricorsiva:
int somma_rico_tail(int *vettore, int dimensione, int accumulatore) {
	if (dimensione == 0)
		return accumulatore;
	int temp = ((*vettore % 2 == 0) ? *vettore : 0);
	return somma_rico_tail(vettore + 1, dimensione - 1, accumulatore + temp);
}

int somma_tail(int *vettore, int dimensione) {
	return somma_rico_tail(vettore, dimensione, 0);
}

int main() {

	int vettore[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 };
	int dimensione = sizeof(vettore) / sizeof(int);

	printf("Somma dei numeri pari iter: %d\n", somma_iter(vettore, dimensione));
	printf("Somma dei numeri pari rico: %d\n", somma_rico(vettore, dimensione));
	printf("Somma dei numeri pari tail: %d\n", somma_tail(vettore, dimensione));

	return 0;
}

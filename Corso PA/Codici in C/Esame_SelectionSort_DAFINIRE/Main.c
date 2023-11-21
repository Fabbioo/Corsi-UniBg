#include <stdio.h>
#include <stdlib.h>

int minIndice(int vettore[], int i, int j) {
	if (i == j)
		return i;
	int k = minIndice(vettore, i + 1, j);
	return (vettore[i] < vettore[k]) ? i : k;
}

void selectionSort_rico_notail(int *vettore, int dimensione, int indice) {
	if (indice == dimensione)
		return;
	int k = minIndice(vettore, indice, dimensione - 1);
	if (k != indice) {
		int temp = vettore[k];
		vettore[k] = vettore[indice];
		vettore[indice] = temp;
	}
	selectionSort_rico_notail(vettore, dimensione, indice + 1);
}

void selectionSort_rico(int *vettore, int dimensione) {
	selectionSort_rico_notail(vettore, dimensione, 0);
}

void selectionSort_iter(int *vettore, int dimensione) {
	for (int i = 0; i < dimensione; i++) {
		int minimo = i;
		for (int j = i + 1; j < dimensione; j++)
			if (vettore[minimo] > vettore[j])
				minimo = j;
		if (minimo != i) {
			int k = vettore[minimo];
			vettore[minimo] = vettore[i];
			vettore[i] = k;
		}
	}
}

void printArray(int *vettore, int dimensione) {
	for (int i = 0; i < dimensione; i++)
		printf("%d ", vettore[i]);
}

int main() {

	int v1[] = { -6, 7, -9, 1, 3 };
	int dim1 = sizeof(v1) / sizeof(int);

	printf("Vettore 1 prima dell'ordinamento: ");
	printArray(v1, dim1);

	selectionSort_iter(v1, dim1);
	//selectionSort_rico(v1, dim1);
	//selectionSort_tail(v1, dim1); // TODO

	printf("\nVettore 1 dopo l'ordinamento: ");
	printArray(v1, dim1);

	return 0;
}

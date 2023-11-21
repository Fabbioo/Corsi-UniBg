#include <stdio.h>

int contaPositivi_iter(int *vettore, int dimensione) {
	int risultato = 0;
	for (int i = 0; i < dimensione; i++)
		if (vettore[i] > 0)
			risultato++;
	return risultato;
}

int contaPositivi_rico(int *vettore, int dimensione) {
	if (dimensione == 0)
		return 0;
	int temp = contaPositivi_rico(vettore + 1, dimensione - 1);
	return ((*vettore > 0) ? 1 : 0) + temp;
}

int contaPositivi_rico_tail(int *vettore, int dimensione, int contatore) {
	if (dimensione == 0)
		return contatore;
	int temp = ((*vettore > 0) ? 1 : 0);
	return contaPositivi_rico_tail(vettore + 1, dimensione - 1, contatore + temp);
}

int contaPositivi_tail(int *vettore, int dimensione) {
	return contaPositivi_rico_tail(vettore, dimensione, 0);
}

int main() {

	int vettore[] = { 34, 1, -2, 3, -4, 5, -6, 48, -7, -8, 9, 10, -11 };
	int dimensione = sizeof(vettore) / sizeof(int);

	printf("Positivi iter: %d\n", contaPositivi_iter(vettore, dimensione));
	printf("Positivi rico: %d\n", contaPositivi_rico(vettore, dimensione));
	printf("Positivi tail: %d\n", contaPositivi_tail(vettore, dimensione));

	return 0;
}

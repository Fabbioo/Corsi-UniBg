/*
 *  Si scriva una funzione in C che prende un array di interi e restituisce il massimo numero
 *  pari in X se esiste, altrimenti restituisce -1.
 *
 *  Al solito, scrivi tre versioni: una iterativa non ricorsiva, una ricorsiva senza tail recursion e una
 *  ricorsiva con tail recursion.
 *  Specifica esattamente i parametri che passi alla procedura, il tipo di passaggio utilizzato e il loro
 *  significato con commenti prima della funzione.
 *  Scrivi anche un main di esempio in cui chiami la funzione massimo con diversi casi di test e lo stampa
 *  (cerca di coprire tutti i casi).r
 */

#include <stdio.h>

int maxIntPari_iter(int *vettore, int dimensione) {
	int max = -1;
	for(int i = 0; i < dimensione; i++)
		if(vettore[i] % 2 == 0 && vettore[i] > max)
			max = vettore[i];
	return max;
}

int maxIntPari_rico(int *vettore, int dimensione) {
	if(dimensione == 1)
		return -1;
	int temp = maxIntPari_rico(vettore + 1, dimensione - 1);
	return ((temp % 2 == 0 && temp > vettore[0]) ? temp : *vettore);
	// FIXME Sbagliato se nel vettore ci sono solo numeri dispari, ma non so come correggere.
}

int maxIntPari_rico_tail(int *vettore, int dimensione, int max) {
	if (dimensione == 0)
		return max;
	if (*vettore % 2 == 0 && *vettore > max)
		max = *vettore;
	return maxIntPari_rico_tail(vettore + 1, dimensione - 1, max);
}

int maxIntPari_tail(int *vettore, int dimensione) {
	return maxIntPari_rico_tail(vettore, dimensione, -1);
}

int main() {

	int vettore[] = { 18, 5, 13, -3, 7, 14, 78, 79, 6, -7, -8, 7, 16 };
	int dimensione = sizeof(vettore) / sizeof(int);

	printf("Massimo intero pari iter: %d\n", maxIntPari_iter(vettore, dimensione));
	printf("Massimo intero pari rico: %d\n", maxIntPari_rico(vettore, dimensione));
	printf("Massimo intero pari tail: %d\n", maxIntPari_tail(vettore, dimensione));

	return 0;
}

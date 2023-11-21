/*
 * Traccia.
 * Scrivi una funzione in C che dato in ingresso un array di int restituisce il numero minore.
 * Scrivi tre versioni: una non ricorsiva, una ricorsiva senza tail recursion e una ricorsiva con tail recursion
 * Specifica esattamente i parametri che passi alla procedura, il tipo di passaggio utilizzato e il loro
 * significato.
 * Descrivi anche le assunzioni che fai (ad esempio zero terminated o cose simili).
 * Scrivi anche un main di esempio in cui chiami le funzioni con un array di tua scelta con 2 elementi.
 * L'array deve essere dichiarato come variabile nel main.
 * La variabile locale MIN a cui assegnare nel main il risultato della funzione di cui sopra deve essere globale
 * Non usare altre variabili globali.
 */

#include <stdio.h>

int ricercaMin_iter(int *vettore, int dimensione) {
	int min = *vettore;
	for (int i = 0; i < dimensione; i++)
		if (vettore[i] < min)
			min = vettore[i];
	return min;
}

int ricercaMin_rico(int *vettore, int dimensione) {
	if(dimensione == 1)
		return *vettore;
	int min = ricercaMin_rico(vettore + 1, dimensione - 1);
	return ((*vettore < min) ? *vettore : min);
}

int ricercaMin_rico_tail(int *vettore, int dimensione, int temp) {
	int min = ((*vettore <= temp) ? *vettore : temp);
	if (dimensione == 1)
		return min;
	return ricercaMin_rico_tail(vettore + 1, dimensione - 1, min);
}

int ricercaMin_tail(int *vettore, int dimensione) {
	return ricercaMin_rico_tail(vettore, dimensione, *vettore);
}

int main() {

	int vettore[] = { -18, -14, 1, -2, -11, -15, -45, -17, 3, -7, -9, -13, -16, -19 };
	int dimensione = sizeof(vettore) / sizeof(int);

	printf("Minimo iter: %d\n", ricercaMin_iter(vettore, dimensione));
	printf("Minimo rico: %d\n", ricercaMin_rico(vettore, dimensione));
	printf("Minimo tail: %d\n", ricercaMin_tail(vettore, dimensione));

	return 0;
}

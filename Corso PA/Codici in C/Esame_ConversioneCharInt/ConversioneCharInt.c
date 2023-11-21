/*
 * Traccia.
 * Scrivi una funzione snis (somma numeri in stringa) che, data in ingresso una stringa S che possibilmente
 * contiene caratteri che rappresentano numeri, calcoli la somma dei numeri in essa (considerati come singole
 * cifre). I caratteri che non rappresentano numeri vengono ignorati.
 *
 * Ad esempio “a2r123” → 2 + 1 + 2 + 3 = 8
 *
 * Scrivi tre versioni: una non ricorsiva e una ricorsiva senza e una con tail recursion.
 * Per sapere se un carattere rappresenta una cifra numerica, usa int isdigit(int c) della libreria ctype.h
 *
 * Scrivi anche un main di esempio in cui chiami la funzione con le seguenti stringhe:
 * "1", "abc", "1and2", "000", "0punto12".
 *
 * Non usare alcuna altra variabile globale.
 * La stringa iniziale non viene modificata.
 */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

/*
 * La funzione isdigit può prendere in input sia un numero sia un char.
 * Nel caso dei char, questi vengono preventivamente convertiti al proprio valore ASCII.
 * La funzione isdigit considera il valore ASCII del carattere in questione e valuta che questo
 * sia compreso nell'intervallo tra 48 e 57 (vedi una qualunque tavola ASCII). Se il valore è
 * compreso in questo intervallo, allora il corrispondente char rappresenta un numero in
 * formato carattere. Affinchè un numero in formato carattere possa essere "convertito" in numero
 * in formato numerico è necessario utilizzare la scrittura "- '0'" dopo il carattere da convertire.
 */

int convCharInt_iter(char *stringa) {

	int somma = 0;

	// Opzione 1: ciclo for
	for (int i = 0; i < strlen(stringa); i++)
		if (isdigit(stringa[i]))
			somma += stringa[i] - '0';

//	Opzione 2: ciclo while
//	while (*stringa) {
//		if (isdigit(*stringa))
//			somma += *stringa - '0';
//		stringa++;
//	}

	return somma;
}

int convCharInt_rico(char *stringa) {
	if (*stringa == '\0')
		return 0;
	int elemento = convCharInt_rico(stringa + 1);
	return (isdigit(*stringa) ? (*stringa - '0') : 0) + elemento;
}

int convCharInt_rico_tail(char *stringa, int contatore) {
	if (*stringa == '\0')
		return contatore;
	if (isdigit(*stringa))
		contatore += *stringa - '0';
	return convCharInt_rico_tail(stringa + 1, contatore);
}

int convCharInt_tail(char *stringa) {
	return convCharInt_rico_tail(stringa, 0);
}

int main() {

	char stringa[] = "1and2or3sig5moide98";

	printf("Somma iter: %d\n", convCharInt_iter(stringa));
	printf("Somma rico: %d\n", convCharInt_rico(stringa));
	printf("Somma tail: %d\n", convCharInt_tail(stringa));

	return 0;
}

#include<stdio.h>

/*
 * La ricorsione Tail è un particolare tipo di ricorsione che si verifica quando in una funzione ricorsiva la
 * chiamata a se stessa avviene come ultima istruzione e il valore di ritorno non è coinvolto in nessuna
 * espressione. In questo modo non viene eseguita nessun'altra istruzione al ritorno dalla chiamata.
 */

int fattoriale(int numero, int valore) {
	if(numero == 0)
		return 1;
	else if (numero == 1)
		return valore;
	else
		return fattoriale(numero - 1, valore * numero);
}

int main() {
	printf("Fattoriale: %d", fattoriale(4, 1));
	return 0;
}

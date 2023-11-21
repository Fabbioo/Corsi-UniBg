/*
 * Un tipo di dato opaco è un tipo di dato la cui reale struttura non è definita nell'interfaccia.
 * Si tratta, in parole povere, di una struttura di cui non vengono forniti dettagli sui campi e, di
 * conseguenza, l'accesso alle informazioni può avvenire solo tramite l'utilizzo di una serie di funzioni,
 * ovvero di un'interfaccia ben delineata.
 * Teoricamente parlando, questa tecnica implementa il concetto di "information hiding" perchè permette di
 * nascondere all'utilizzatore di una libreria i dettagli del funzionamento della stessa. Nella pratica
 * permette di evitare che l'utilizzatore della libreria acceda impropriamente ai campi della struttura, che
 * rimangono pertanto strettamente ad uso e consumo della libreria, permettendo così allo sviluppatore di
 * modificare la struttura stessa a seconda delle esigenze.
 */

#include <stdio.h>
#include <stdlib.h>
#include "counter.h"

int main() {

	counterRef c = makeCounter();

	incremento(c);
	incremento(c);
	incremento(c);
	incremento(c);
	printf("Valore incrementato: %d\n", getValue(c)); // 1 + 1 + 1 + 1 = 4

	decremento(c);
	decremento(c);
	printf("Valore decrementato: %d\n", getValue(c)); // 4 - 1 - 1 = 2

	reset(c);
	printf("Valore resettato: %d\n", getValue(c)); // 0

	incremento(c);
	incremento(c);
	decremento(c);
	printf("Valore finale: %d", getValue(c)); // 0 + 1 + 1 - 1 = 1

	delete(c);

	return 0;
}

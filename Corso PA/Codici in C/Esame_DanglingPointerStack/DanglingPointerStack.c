#include <stdio.h>

char* itos(int x) {
	char buffer[5];
	sprintf(buffer, "%d", x);
	return &buffer;
}

int main() {

	char *dp1 = itos(1);
	printf("Stringa di 1: %s\n", dp1);

	char *dp2 = itos(2);
	printf("Stringa di 2: %s\n\n", dp2);

	printf("Nuovo valore di dp1: %s", dp1);

	return 0;
}

/*
 * Si tratta di un dangling pointer SULLO STACK perchè non viene creato lo spazio atto a contenere
 * ciò che deve essere puntato dal puntatore sfruttando la malloc. Si ha così che il puntatore
 * memorizzato sullo stack punta ad una zona di memoria sempre sullo stack. In questo caso il puntatore
 * diventa dangling perchè al momento dell'uscita dalla funzione itos() viene deallocato lo spazio
 * precedentemente allocato con char buffer[5]. In questo contesto una variabile sullo stack punta
 * ad una zona di memoria deallocata sempre sullo stack.
 *
 * Strategia risolutiva per non avere dangling pointers sullo stack: usare malloc().
 * Se si usa la malloc bisogna ricordarsi di usare anche la free() per non incorrere nel problema
 * del memory leak.
 */





#include <stdio.h>
#include <stdlib.h>

int main() {

	char *a = (char*) malloc(sizeof(char));
	*a = 'a'; // Dentro la cella puntata dal puntatore a ci metto il carattere 'a'.
	printf("Valore iniziale di a: %c\n", *a);
	free(a); // Lascio il puntatore dangling.
	printf("Valore di a dopo la free: %c\n\n", *a);

	char *b = (char*) malloc(sizeof(char));
	*b = 'b'; // Dentro la cella puntata dal puntatore b ci metto il carattere 'b'.
	printf("Valore iniziale di b: %c\n", *b);
	printf("Valore di a dopo l'inizializzazione di b: %c\n", *a); // Effetto del dangling pointer.
	free(b);
	b = NULL;

	return 0;
}

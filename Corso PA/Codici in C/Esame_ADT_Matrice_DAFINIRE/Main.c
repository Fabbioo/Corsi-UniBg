#include "Matrice.h"
#include <stdlib.h>
#include <stdio.h>

int main() {

	matriceRef matr1 = creaMatrice(3);
	matriceRef matr2 = creaMatrice(4);
	matriceRef matr3 = creaMatrice(5);

	printf("Matrice 1:\n%s", toString(matr1));
	printf("\nMatrice 2:\n%s", toString(matr2));
	printf("\nMatrice 3:\n%s", toString(matr3));

	// Non capisco quale sia l'errore
	cancellaMatrice(&matr1);
	cancellaMatrice(&matr2);
	cancellaMatrice(&matr3);

	matr1 = NULL;
	matr2 = NULL;
	matr3 = NULL;

	return 0;
}

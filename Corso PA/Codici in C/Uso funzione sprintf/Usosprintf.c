#include <stdio.h>

int main() {

	float x = 7.2345;
	char output[20] = ""; // Tutte le 20 posizioni vengono inizializzate a null.

	int dim = sprintf(output, "x vale %.3f", x);
	// La funzione sprintf() ha come effetto quello di posizionare la stringa "x vale 7.234" dentro output.
	// In pratica, tutto il secondo parametro viene posizionato all'interno del primo.

	printf("Stringa: %s.", output);
	printf("\nNumero di caratteri della stringa: %d.", dim);

	return 0;
}

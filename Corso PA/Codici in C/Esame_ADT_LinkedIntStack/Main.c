#include <stdio.h>
#include "Stack.h"

#define btoa(x) ((x) ? "True" : "False")

int main() {

	printf("Creazione stack.");
	stackRef stack = creaStack();

	printf("\n\nStack vuoto? %s", btoa(isEmpty(stack)));

	printf("\n\nValori presenti nello stack: %s", toString(stack));

	printf("\n\nInserisco valore 10.");
	push(stack, 10);
	printf("\nValori presenti nello stack: %s", toString(stack));

	printf("\n\nInserisco valore 5.");
	push(stack, 5);
	printf("\nValori presenti nello stack: %s", toString(stack));

	printf("\n\nInserisco valore 87.");
	push(stack, 87);
	printf("\nValori presenti nello stack: %s", toString(stack));

	printf("\n\nElimino ultimo elemento aggiunto: %d", pop(stack));

	printf("\nValori presenti nello stack: %s", toString(stack));

	printf("\n\nStack vuoto? %s", btoa(isEmpty(stack)));

	printf("\n\nCancellazione stack.");
	cancellaStack(stack);

	printf("\n\nStack vuoto? %s", btoa(isEmpty(stack)));

	return 0;
}

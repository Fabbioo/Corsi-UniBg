#include <stdio.h>
#include <stdlib.h>
#include "bitvector.h"

int main() {

	bitVector b1 = makeBitVector(10);
	bitVector b2 = makeBitVector(10);

	printf("b1: %s", toString(b1));
	printf("\nb2: %s", toString(b2));

	bitVector bAnd = AND(b1, b2);
	printf("\nb1 AND b2: \t%s", toString(bAnd));

	bitVector bOr = OR(b1, b2);
	printf("\nb1 OR b2: \t%s", toString(bOr));

	bitVector b1Not = NOT(b1);
	printf("\nNOT b1: %s", toString(b1Not));

	bitVector b2Not = NOT(b2);
	printf("\nNOT b2: %s", toString(b2Not));

	delete(&b1);
	delete(&b2);

	return 0;
}

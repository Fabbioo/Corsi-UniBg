#include "MiaStringa.h"
#include<stdio.h>

int main() {

	stringaRef s1 = makeMiaStringa("fabbio");

	add(s1, 'k');
	add(s1, 'z');

	printf("Stampa: %s", toString(s1));

	return 0;
}

#include "Data.h"
#include <stdio.h>

int main() {

	dataRef data1 = creaData(5, 1, 1997, "orarioghsdf");

	printf("%s\n", toString(data1));

	distruttore(&data1);

	return 0;
}

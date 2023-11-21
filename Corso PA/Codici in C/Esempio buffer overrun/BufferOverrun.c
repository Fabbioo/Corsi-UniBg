#include <stdio.h>

/*
 * Si ha un buffer overrun quando le stringhe non vengono terminate dal terminatore.
 * Il printf() può andare incontro a buffer overrun.
 */

int main() {
	char k1 = {'w'};
	char k2[] = {'o', 'z'};
	printf("%s\n", k2);
	return 0;
}

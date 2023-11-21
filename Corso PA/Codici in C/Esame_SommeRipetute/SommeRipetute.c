#include <stdio.h>

void sommeRipetute(int *a, int *b) {
	int c = *a;
	while(*b > 1) {
		*a = *a + c;
		(*b)--;
	}
}

int main() {

	int a = 5;
	int b = 4;

	printf("Valore di a pre: %d\n", a);
	printf("Valore di b pre: %d\n", b);

	sommeRipetute(&a, &b);

	printf("Valore di a post: %d\n", a);
	printf("Valore di b post: %d\n", b);

	return 0;
}

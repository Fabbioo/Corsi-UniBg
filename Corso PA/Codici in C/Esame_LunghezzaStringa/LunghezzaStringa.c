#include <stdio.h>
#include <string.h>

int LUNG = 0;

int lunghezzaStringa_iter(char *parola) {
	int contatore = 0;
	for(int i = 0; i < strlen(parola); i++)
		contatore += 1;
	return contatore;
}

int lunghezzaStringa_rico(char *parola) {
	if(*parola == '\0')
		return 0;
	else
		return 1 + lunghezzaStringa_rico(parola + 1);
}

int lunghezzaStringa_rico_tail(char *parola, int contatore) {
	if(*parola == '\0')
		return contatore;
	else
		return lunghezzaStringa_rico_tail(parola + 1, contatore + 1);
}

int lunghezzaStringa_tail(char *parola) {
	return lunghezzaStringa_rico_tail(parola, 0);
}

int main() {

	char parola[] = "kf2faat0bbii1ool";

	LUNG = lunghezzaStringa_iter(parola);
	printf("Lunghezza iter: %d\n", LUNG);

	LUNG = lunghezzaStringa_rico(parola);
	printf("Lunghezza rico: %d\n", LUNG);

	LUNG = lunghezzaStringa_tail(parola);
	printf("Lunghezza tail: %d\n", LUNG);

	return 0;
}

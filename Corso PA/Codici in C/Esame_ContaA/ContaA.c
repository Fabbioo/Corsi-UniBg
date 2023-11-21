#include <stdio.h>
#include <string.h>

int cercaA_iter(char *parola) {
	int result = 0;
	for (int i = 0; i < strlen(parola); i++)
		if (parola[i] == 'a')
			result += 1;
	return result;
}

int cercaA_rico(char *parola) {
	if (*parola == '\0')
		return 0;
	int temp = cercaA_rico(parola + 1);
	return ((*parola == 'a') ? 1 : 0) + temp;
}

int cercaA_rico_tail(char *parola, int contatore) {
	if (*parola == '\0')
		return contatore;
	int temp = ((*parola == 'a') ? 1 : 0);
	return cercaA_rico_tail(parola + 1, contatore + temp);
}

int cercaA_tail(char *parola) {
	return cercaA_rico_tail(parola, 0);
}

int main() {

	char parola[] = "naabaaavawaa";

	printf("Numero di 'a' in '%s' iter: %d\n", parola, cercaA_iter(parola));
	printf("Numero di 'a' in '%s' rico: %d\n", parola, cercaA_rico(parola));
	printf("Numero di 'a' in '%s' tail: %d\n", parola, cercaA_tail(parola));

	return 0;
}

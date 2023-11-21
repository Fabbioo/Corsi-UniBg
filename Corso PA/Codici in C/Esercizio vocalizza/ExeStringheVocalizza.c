#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Versione iterativa:
char* vocalizza_iter(char *s) {
	char *result = (char*) malloc((strlen(s) + 1) * sizeof(char)); // Il +1 vale per il terminatore.
	result[0] = '\0'; // Inizializzo result alla stringa vuota.
	while (*s) {
		if (*s == 'a' || *s == 'e' || *s == 'i' || *s == 'o' || *s == 'u')
			sprintf(result, "%s%c", result, *s);
		s++;
	}
	return result;
}

// Versione ricorsiva no tail:
char* vocalizza_rico(char *s) {
	if (strlen(s) == 0) {
		// Per ritornare la stringa vuota bisogna necessariamente seguire questa procedura:
		char *result = (char*) malloc(sizeof(char));
		result[0] = '\0';
		return result; // NON USARE return ""; PERCHè NON VA BENE!
	} else {
		char *temp = vocalizza_rico(s + 1);
		if (*s != 'a' && *s != 'e' && *s != 'i' && *s != 'o' && *s != 'u')
			return temp;
		char *result = (char*) malloc((strlen(temp) + 2) * sizeof(char)); // +2 perchè 1 serve per includere il terminatore e 1 per la vocale.
		sprintf(result, "%c%s", *s, temp);
		free(temp);
		return result;
	}
}

char* vocalizza_tail(char *s, char *buff, int i) {
	if (!s[0]) {
		buff[i] = '\0';
		return buff;
	}
	if (*s == 'a' || *s == 'e' || *s == 'i' || *s == 'o' || *s == 'u') {
		buff[i] = *s;
		return vocalizza_tail(s + 1, buff, i + 1);
	} else
		return vocalizza_tail(s + 1, buff, i);

}
int main() {

	char s[] = "fabbiomandalari";

	printf("Parola: %s\n", s);
	printf("\nVocalizza iter: %s", vocalizza_iter(s));
	printf("\nVocalizza rico: %s", vocalizza_rico(s));
	char *buff = (char*) malloc((strlen(s) + 1) * sizeof(char));
	printf("\nVocalizza tail: %s", vocalizza_tail(s, buff, 0));
	free(buff);
	buff = NULL;

	return 0;
}

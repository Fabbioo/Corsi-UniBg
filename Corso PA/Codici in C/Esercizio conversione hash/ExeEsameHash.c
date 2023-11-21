#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Versione iterativa:
int hash_it(char *s) {
	int result = 0;
	for (int i = 0; i < strlen(s); i++)
		result += s[i] * (i + 1);
	return result;
}

int hash_ric_notail(char *s, int i) {
	// Base della ricorsione:
	if (i > strlen(s))
		return 0;
	int temp = hash_ric_notail(s, i + 1);
	return temp + (s[i - 1] * i);
}

// Versione ricorsiva senza tail:
int hash_ric(char *s) {
	return hash_ric_notail(s, 1);
}

int hash_ric_tail(char *s, int i, int accumulatore) {
	if (i > strlen(s))
		return accumulatore;
	else
		return hash_ric_tail(s, i + 1, accumulatore + s[i - 1] * i);
}

// Versione ricorsiva con tail:
int hash_tail(char *s) {
	return hash_ric_tail(s, 1, 0);
}

int main() {

	char s1[] = "fabbio";

	// Chiamata alla funzione iterativa:
	printf("Hash di '%s' iter:  %d", s1, hash_it(s1));

	// Chiamata alla funzione ricorsiva senza tail:
	printf("\nHash di '%s' rico: %d", s1, hash_ric(s1));

	// Chiamata alla funzione ricorsiva con tail:
	printf("\nHash di '%s' tail:  %d", s1, hash_tail(s1));

	return 0;
}

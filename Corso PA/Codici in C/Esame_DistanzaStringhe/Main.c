#include <stdio.h>
#include <string.h>

int distanza_iter(char s1[], char s2[]) {

	int distanzaParziale = 0;
	int distanzaTotale = 0;

	if (strlen(s1) >= strlen(s2)) {
		for (int i = 0; i < strlen(s2); i++) {
			distanzaParziale = s1[i] - s2[i];
			if (distanzaParziale < 0)
				distanzaParziale = -distanzaParziale;
			distanzaTotale += distanzaParziale;
		}
	} else {
		for (int i = 0; i < strlen(s1); i++) {
			distanzaParziale = s2[i] - s1[i];
			if (distanzaParziale < 0)
				distanzaParziale = -distanzaParziale;
			distanzaTotale += distanzaParziale;
		}
	}

	int differenzaDistanza = strlen(s1) - strlen(s2);

	if (differenzaDistanza < 0)
		differenzaDistanza = -differenzaDistanza;

	distanzaTotale += differenzaDistanza * 100;

	return distanzaTotale;
}

int distanza_rico_notail(char *s1, char *s2, int dimensione) {
	if (dimensione == 0)
		return 0;
	int parziale = *s1 - *s2;
	if (parziale < 0)
		parziale = -parziale;
	return parziale + distanza_rico_notail(s1 + 1, s2 + 1, dimensione - 1);
}

int distanza_rico(char *s1, char *s2) {
	if (strlen(s1) >= strlen(s2)) {
		int contatoreParziale = (strlen(s1) - strlen(s2)) * 100;
		return contatoreParziale + distanza_rico_notail(s1, s2, strlen(s2));
	} else {
		int contatoreParziale = (strlen(s2) - strlen(s1)) * 100;
		return contatoreParziale + distanza_rico_notail(s2, s1, strlen(s1));
	}
}

int distanza_rico_tail(char *s1, char *s2, int dimensione, int contatore) {
	if (dimensione == 0)
		return contatore;
	int parziale = *s1 - *s2;
	if (parziale < 0)
		parziale = -parziale;
	contatore += parziale;
	return distanza_rico_tail(s1 + 1, s2 + 1, dimensione - 1, contatore);
}

int distanza_tail(char *s1, char *s2) {
	/*
	 * Ritorno in ordine:
	 * _ stringa più lunga;
	 * _ stringa più corta;
	 * _ lunghezza della stringa più corta;
	 * _ contatore iniziale.
	 */
	if (strlen(s1) >= strlen(s2)) {
		int contatoreParziale = (strlen(s1) - strlen(s2)) * 100;
		return distanza_rico_tail(s1, s2, strlen(s2), contatoreParziale);
	} else {
		int contatoreParziale = (strlen(s2) - strlen(s1)) * 100;
		return distanza_rico_tail(s2, s1, strlen(s1), contatoreParziale);
	}

}

int main() {

	char s1[] = "aaaabzzq";
	char s2[] = "abcdaap";

	printf("Distanza iter: %d", distanza_iter(s1, s2));
	printf("\nDistanza rico: %d", distanza_rico(s1, s2));
	printf("\nDistanza tail: %d", distanza_tail(s1, s2));

	return 0;
}

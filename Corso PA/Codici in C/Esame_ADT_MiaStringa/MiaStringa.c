#include "MiaStringa.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

struct miastringa {
	char *s;
} MiaStringa;

stringaRef makeMiaStringa(char *stringa) {
	stringaRef miaStringa = (stringaRef) malloc(sizeof(MiaStringa));
	miaStringa->s = (char*) malloc(sizeof(char) * strlen(stringa) + 1);
	strcpy(miaStringa->s, stringa);
	return miaStringa;
}

void add(stringaRef stringa, char carattere) {
	char *ausiliaria = (char*) malloc(sizeof(char) * (strlen(stringa->s) + 1 + 1));
	sprintf(ausiliaria, "%s%c", stringa->s, carattere);
	free(stringa->s);
	stringa->s = ausiliaria;
	printf("Carattere '%c' aggiunto\n", carattere);
}

char* toString(stringaRef stringa) {
	char *data = (char*) malloc(sizeof(char) * (strlen(stringa->s) + 1));
	sprintf(data, "%s", stringa->s);
	return data;
}

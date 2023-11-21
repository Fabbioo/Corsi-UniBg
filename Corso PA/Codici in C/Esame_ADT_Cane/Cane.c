#include "Cane.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct cane {
	char *nome;
};

caneRef creaCane(char *nome) {
	caneRef newCane = (caneRef) malloc(sizeof(struct cane));
	newCane->nome = (char*) malloc(sizeof(char) * (strlen(nome) + 1));
	strcpy(newCane->nome, nome);
	return newCane;
}

void abbaia(caneRef cane) {
	printf("%s, abbaia! -> Bau :@\n", cane->nome);
}

void distruggiCane(caneRef *cane) {
	free((*cane)->nome);
	free(*cane);
	*cane = NULL;
}

#include <stdlib.h>
#include <stdio.h>

typedef struct Persona {
	char nome[20];
} Persona;

int main() {
	Persona *persona = (Persona*) malloc(sizeof(Persona));
	sprintf(persona->nome, "fabio");
	printf("%s\n", persona->nome);
	free(persona);
	printf("%s\n", persona->nome);
	return 0;
}

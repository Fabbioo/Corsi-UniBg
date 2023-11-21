#include <stdio.h>

typedef struct Persona {
	char nome[20];
} Persona;

Persona* makePersona() {
	Persona p;
	sprintf(p.nome, "fabio");
	printf("io sono %s\n", p.nome);
	return &p;
}

int main() {
	Persona *persona = makePersona();
	printf("io sono %s\n", persona->nome);
	return 0;
}

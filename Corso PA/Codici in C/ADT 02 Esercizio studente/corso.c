#include "corso.h"
#include<stdlib.h>
#include<string.h>

#define MAX_CHAR_CORSO 40

struct nodo {
	studenteRef s;
	struct nodo* next;
};

struct corso {
	char nome[MAX_CHAR_CORSO];
	struct nodo* lista;
};

corsoRef makeCorso(char *nome){
	corsoRef newCorso = malloc(sizeof(struct corso));
	strncpy(newCorso->nome, nome, MAX_CHAR_CORSO);
	newCorso->lista = NULL;
	return newCorso;
}

void addStudent(corsoRef corso, studenteRef studente){
	struct nodo *newNodo = malloc(sizeof(struct nodo));
	newNodo->s = studente;
	// Inserimento in testa
	newNodo->next = corso->lista;
	corso->lista = newNodo;
}

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "studente.h"

#define NUMVOTI 5 // Decido arbitrariamente che uno studente può possedere al massimo 5 voti.

static int matricola = 0;

/*
 * ATTENZIONE.
 *
 * La struttura è composta da 30 caratteri per il nome, un puntatore al cognome e un intero per la matricola.
 *
 * Quando alloco la memoria per studente viene "automaticamente" allocata sia la memoria necessaria al
 * contenimento dei 30 caratteri del nome sia quella necessaria al contenimento della matricola.
 * Perchè lo sto specificando? Perchè il cognome, trattandosi di un puntatore, necessita di una ulteriore
 * allocazione di memoria.
 */

struct studente {
	char nome[30];
	char *cognome;
	int matricola;
	int voti[NUMVOTI];
} Studente;

// Implemento il costruttore.
studenteRef makeStudente(char *nome, char *cognome) {
	return makeStudenteMatr(nome, cognome, ++matricola);
}

studenteRef makeStudenteMatr(char *nome, char *cognome, int matricola) {

	// Come prima cosa bisogna creare lo studente. Il processo di creazione di uno studente
	// prevede che, innanzitutto, venga istanziata la memoria necessaria al contenimento
	// della struttura.
	studenteRef studente = (studenteRef)malloc(sizeof(Studente));

	strcpy(studente->nome, nome);

	// Per il cognome, trattandosi di un puntatore, devo preventivamente allocargli la memoria necessaria.
	// La memoria necessaria è proprio la lunghezza di c incrementata di 1 perchè, trattandosi di una
	// stringa, devo tenere da conto anche del carattere terminatore.
	studente->cognome = (char *)malloc(sizeof(char) * (strlen(cognome) + 1));

	// A questo punto posso riempire il campo cognome:
	strcpy(studente->cognome, cognome);

	studente->matricola = matricola;

	for(int i = 0; i < NUMVOTI; i++)
		studente->voti[i] = 0;

	return studente;
}

void printStudente(studenteRef s) {
	printf("Nome: %s;\t\tCognome: %s;\t\tMatricola: %d.\n", s->nome, s->cognome, s->matricola);
}

char* studentData(studenteRef s) {
	// Devo innanzitutto allocare in memoria lo spazio necessario per la stringa.
	// Alloco un char moltiplicato per (lunghezza nome + lunghezza cognome + 2 spazi + 38 caratteri).
	// Il valore 38 tiene conto di tutti i possibili caratteri aggiuntivi (ad esempio il ;).
	char *stringa = (char *)malloc(sizeof(char) * (strlen(s->nome) + strlen(s->cognome) + 40));
	stringa[0] = '\0';

	sprintf(stringa, "Nome: %s;\t\tCognome: %s;\t\tMatricola: %d.", s->nome, s->cognome, s->matricola);

	stringa[strlen(s->nome) + strlen(s->cognome) + 39] = '\0'; // Per non saper nè leggere nè scrivere...

	return stringa;
}

void addVoto(studenteRef s, int voto) {
	for(int i = 0; i < NUMVOTI; i++)
		if(s->voti[i] == 0) {
			s->voti[i] = voto;
			break;
		}
	printf("\nVoto %d aggiunto correttamente!", voto);
}

void stampaMedia(studenteRef s) {
	int contatore = 0;
	float somma = 0;
	for(int i = 0; i < NUMVOTI; i++) {
		if(s->voti[i] != 0) {
			somma += s->voti[i];
			contatore++;
		}
	}
	printf("\n\nMedia di %s: %.2f", s->nome, somma/contatore);
}

void deleteStudente(studenteRef *p) {

	/*
	 * Attenzione: p è un puntatore a puntatore. In particolare, p è una variabile che risiede nello
	 * stack e che punta ad una variabile nello stack (stando a quanto riportato nel main(), prima
	 * punta a stud1, poi a stud2 e infine a stud3), la quale, a sua volta, punta ad un oggetto nello heap.
	 */

	// Per capire la logica delle due free() guarda il file RappresentazioneDeleteStudente.pdf

	// Come prima cosa devo eliminare la zona dello heap puntata da cognome:
	free((*p)->cognome);

	// Solo successivamente posso eliminare la zona dello heap che contiene tutte le altre informazioni:
	free(*p);

	/*
	 * Giunge così il momento di esplicitare il vantaggio di cui si è parlato nel file studente.h.
	 * A questo punto ho un dangling pointer. Mi riferisco al puntatore che parte da Piero nello stack e
	 * punta allo heap. Per "annullare" tale dangling pointer lo devo trasformare in NULL (ovvero devo fare
	 * in modo che Piero non punti più allo heap, ma punti a NULL). Questo assegnamento non è scontato da
	 * fare, ma in questo caso lo posso fare perchè il distruttore opera su un puntatore ad un puntatore.
	 * Ecco svelato il vantaggio. In pratica nel distruttore si passa un puntatore ad un puntatore per poter
	 * poi modificare il puntatore stesso.
	 */
	*p = NULL;

	// Il contesto di riferimento finale è quello presente nel file RappresentazioneFinaleDeleteStudente.pdf
}

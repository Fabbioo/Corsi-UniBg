#ifndef STUDENTE_H_
#define STUDENTE_H_

typedef struct studente *studenteRef;

studenteRef makeStudente(char*, char*);
studenteRef makeStudenteMatr(char* , char*, int); // Overload del costruttore.

// Metodo che stampa nome, cognome e matricola:
void printStudente(studenteRef);

// Metodo che restituisce i dati dello studente in una stringa:
char *studentData(studenteRef); // è l'equivalente del classico toString().

// Metodo per aggiungere un voto ad uno studente:
void addVoto(studenteRef, int);

//Metodo che serve per stampare la media dei voti dello studente:
void stampaMedia(studenteRef);

void deleteStudente(studenteRef *); // Questo studenteRef è un puntatore a puntatore.
	// C'è un vantaggio nel definire un distruttore che prende in input un puntatore ad un puntatore.
	// Per capire a cosa mi riferisco guarda l'implementazione di deleteStudente in studente.c

#endif /* STUDENTE_H_ */

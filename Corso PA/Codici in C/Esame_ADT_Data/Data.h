#ifndef DATA_H_
#define DATA_H_

/*
 * Traccia.
 * Si vuole realizzare una struttura dati per memorizzare una data composta da tre interi giorno, mese e anno
 * e da una stringa di lunghezza variabile che rappresenta il fuso.
 * I metodi che la libreria mette a disposizione sono:
 * _ creazione di una data passati tre interi (giorno, mese, anno) e la stringa per il fuso -> se non sono
 * validi (giorni o mesi non possibile), li mette a 1;
 * _ toString che restituisce una stringa (char*) contenente la data in formato GG-MM-YYYY - fuso. Usa la
 * funzione sprintf;
 * _ distruzione: fa il free della data.
 * Scrivi l'orario usando i puntatori opachi in C.
 * Fai un esempio ben commentato in cui utilizzi tutti i metodi sopra.
 */

typedef struct data *dataRef;

dataRef creaData(int, int, int, char*);
char* toString(dataRef);
void distruttore(dataRef*);

#endif /* DATA_H_ */

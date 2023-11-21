#include <iostream>
using namespace std;

// TRACCIA: SCRIVERE UNA FUNZIONE CHE TOGLIE IL PRIMO CARATTERE DA UNA STRINGA.

// Sfrutto le stringhe.
void togli1carattere_v1(char *c) {
    while(*c != '\0') {
        *c = *(c+1);
        c++;
    }
}

// Sfrutto i puntatori a puntatori.
void togli1carattere_v2(char **c) { // c è un puntatore che punta ad un puntatore di char (quindi nome2).
    (*c)++;
}

int main() {

    char nome1[] = "fabio"; // Dato che lo stack cresce in altezza e nome1 è la prima variabile ad essere dichiarata, dato che nome1 è un array viene automaticamente aggiunto il \0 al termine di pippo.
    char *nome2 = nome1;

    cout << "Nome1 pre:\t" << nome1 << endl;
    cout << "Nome2 pre:\t" << nome2 << endl;

    togli1carattere_v1(nome1);
    cout << "Nome1 dopo v1:\t" << nome1 << endl;

    togli1carattere_v2(&nome2);
    cout << "Nome2 dopo v2:\t" << nome2 << endl;

    return 0;
}


/*
 * CON I PUNTATORI A PUNTATORI NON SI MODIFICA IL VALORE DEL PUNTATORE A PUNTATORE, MA IL VALORE DEL
 * PUNTATORE CHE VIENE PUNTATO DAL PUNTATORE A PUNTATORE.
 */

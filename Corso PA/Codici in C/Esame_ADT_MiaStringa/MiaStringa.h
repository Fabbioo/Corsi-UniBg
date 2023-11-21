/*
 * Traccia.
 * Scrivi la definizione di un tipo di dato astratto MiaStringa che rappresenta una stringa mediante i tipi
 * opachi. A questa stringa si possono aggiungere dei caratteri alla fine. Scrivi le seguenti funzioni:
 * _ makeMiaStringa che prende in ingresso una stringa classica char * e costruisce una miastringa;
 * _ add che aggiunge un carattere alla fine della miastringa. Se non c'è spazio la miastringa va allungata;
 * _ toString che restituisce una stringa classica char* contenente i carattere della miastringa compresi
 * quelli aggiunti dopo.
 * Scrivi un main in cui fai alcune prove.
 */
#ifndef MIASTRINGA_H_
#define MIASTRINGA_H_

typedef struct miastringa *stringaRef;

stringaRef makeMiaStringa(char*);
void add(stringaRef, char);
char* toString(stringaRef);

#endif /* MIASTRINGA_H_ */

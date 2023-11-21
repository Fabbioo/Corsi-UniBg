/*
 * Traccia.
 * Scrivi una funzione togliA in C che dato in ingresso una stringa restituisce una stringa uguale tranne
 * che toglie le 'a' se ci sono.
 * Al solito, scrivi tre versioni: una non ricorsiva, una ricorsiva senza tail recursion e una ricorsiva
 * con tail recursion.
 * Specifica esattamente i parametri che passi alla procedura, il tipo di passaggio utilizzato e il loro
 * significato.
 * Scrivi anche un main di esempio in cui chiami la funzione con qualche string di esempio e stampi il risultato.
 * Non usare alcuna altra variabile globale.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* togliA_iter(char *parola) {
	char *nuovaParola = (char *)malloc(sizeof(char) * (strlen(parola) + 1));
	nuovaParola[0] = '\0';
	int i = 0;
	while(*parola != '\0') {
		if(*parola != 'a') {
			nuovaParola[i] = *parola;
			i++;
		}
		parola++;
	}
	return nuovaParola;
}

char *togliA_rico(char *parola) {
	if(strlen(parola) == 0) {
		char *risultato = (char*) malloc(sizeof(char));
		risultato[0] = '\0';
		return risultato;
	}
	char *elemento = togliA_rico(parola + 1);
	if(*parola == 'a')
		return elemento;
	char *risultato = (char*) malloc(sizeof(char) * (strlen(parola) + 1));
	sprintf(risultato, "%c%s", *parola, elemento);
	return risultato;
}

char* togliA_rico_tail(char *parola, char *nuovaParola) {
	if(*parola == '\0')
		return nuovaParola;
	if(*parola != 'a')
		sprintf(nuovaParola, "%s%c", nuovaParola, *parola);
	return togliA_rico_tail(parola + 1, nuovaParola);
}

char* togliA_tail(char *parola) {
	char *nuovaParola = (char *)malloc(sizeof(strlen(parola + 1) * sizeof(char)));
	nuovaParola[0] = '\0';
	return togliA_rico_tail(parola, nuovaParola);
}

int main() {

	char stringa[] = "aaopafababiaoa";

	printf("Iterativa: %s\n", togliA_iter(stringa));
	printf("Ricorsiva: %s\n", togliA_rico(stringa));
	printf("Rico tail: %s\n", togliA_tail(stringa));

	return 0;
}

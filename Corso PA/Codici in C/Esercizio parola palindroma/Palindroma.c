#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define btoa(x) ((x) ? "True" : "False")

bool verificaPal_iter(char *parola) {
	for (int i = 0; i < strlen(parola); i++)
		if (parola[i] != parola[strlen(parola) - (i + 1)])
			return false;
	return true;
}

bool verificaPal_ric_notail(char *parola, int sx, int dx) {
	if (sx >= dx)
		return true;
	else if (parola[sx] == parola[dx])
		return verificaPal_ric_notail(parola, sx + 1, dx - 1);
	else
		return false;
}

bool verificaPal_ric(char *parola) {
	return verificaPal_ric_notail(parola, 0, strlen(parola) - 1);
}

bool verificaPal_ric_tail(char *parola, int sx, int dx) {
	if (sx >= dx)
		return true;
	else if (parola[sx] != parola[dx])
		return false;
	else
		return verificaPal_ric_tail(parola, sx + 1, dx - 1);
}

bool verificaPal_tail(char *parola) {
	return verificaPal_ric_tail(parola, 0, strlen(parola) - 1);
}

int main() {

	char nopal[] = "fabbienne";
	char pal[] = "tellet";

	printf("La stringa '%s' è palindroma iter? %s\n", nopal, btoa(verificaPal_iter(nopal)));
	printf("La stringa '%s' è palindroma iter? %s\n\n", pal, btoa(verificaPal_iter(pal)));

	printf("La stringa '%s' è palindroma rico? %s\n", nopal, btoa(verificaPal_ric(nopal)));
	printf("La stringa '%s' è palindroma rico? %s\n\n", pal, btoa(verificaPal_ric(pal)));

	printf("La stringa '%s' è palindroma tail? %s\n", nopal, btoa(verificaPal_tail(nopal)));
	printf("La stringa '%s' è palindroma tail? %s\n\n", pal, btoa(verificaPal_tail(pal)));

	return 0;
}

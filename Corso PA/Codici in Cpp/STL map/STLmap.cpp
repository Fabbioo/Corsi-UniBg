#include <iostream>
#include <map>

using namespace std;

int main() {

	// Creo una mappa tra interi e char*:
	map<int, char*> nomi;

	// Aggiungo una stringa in posizione 0:
	nomi[0] = (char*) "anna"; // Nella posizione con chiave 0 vi è l'elemento "anna".

	// Stampo l'elemento di chiave 0:
	cout << nomi[0];

	return 0;
}

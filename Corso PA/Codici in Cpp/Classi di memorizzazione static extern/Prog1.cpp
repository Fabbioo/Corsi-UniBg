#include <iostream>

using namespace std;

// la keyword extern viene utilizzata per dichiarare un oggetto senza definirlo. Serve per poter utilizzare
// all'interno di un sorgente un oggetto che è stato definito in un altro sorgente.
// Anche se non esplicitamente scritto, il compilatore assume la presenza della keyword extern davanti alla
// dichiarazione della funzione sommaExtern. Io in questo caso lo aggiungo, ma è ridondante.
extern int sommaExtern(int x, int y);

int main() {

	int a = sommaExtern(5, 10);

	cout << "Somma: " << a << endl;

	//int b = sommaStatic(5, 10); // Errore perchè la funzione sommaStatic è stata esplicitamente dichiarata
								  // come static, perciò risulta visibile solo all'interno del sorgente Prog2.

	return 0;
}

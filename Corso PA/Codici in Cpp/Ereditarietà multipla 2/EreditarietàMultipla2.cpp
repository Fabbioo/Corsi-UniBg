#include <iostream>

using namespace std;

/*
 * Nel momento in cui si dichiara una ereditarietà multipla si può andare incontro a due tipi di problemi:
 * 1) name clash (ambiguità di nome);
 * 2) problema del diamante.
 *
 * In questo file verrà trattato il problema del diamante.
 *
 * Problema del diamante: una classe base può essere ereditata più volte.
 */

class Titolare {
public:
	char *getTitolare;
};

class Furgone: public Titolare {};
class Negozio: public Titolare {};

class Ambulante: public Furgone, public Negozio {}; // Ambulante possiede due campi getTitolare ereditati.


int main() {

	Ambulante a;

	//a.getTitolare = new string[70]; // Questa linea di codice dà errore perchè il campo getTitolare è
	// presente sia nella classe Furgone sia nella classe Negozio -> vi è ambiguità.

	// Soluzione 1 (soluzione più semplice da implementare):
	a.Furgone::getTitolare = new char[10];
	a.Negozio::getTitolare = new char[20];

	// Soluzione 2: costruzione a diamante (soluzione più complessa e meno chiara).
	// Al vertice del diamante vi è la classe base.
	// Questo diamante deriva dal concetto di ereditarietà virtuale.
	// Con l'ereditarità virtuale si dice "non duplicare le classi base".
	// Con le seguenti due nuove righe di codice:
	// class Furgone: virtual public Titolare {};
	// class Negozio: virtual public Titolare {};
	// andrebbe in esecuzione anche a.getTitolare = new char[10];

	return 0;
}

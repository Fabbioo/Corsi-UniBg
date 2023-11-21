#include <iostream>

using namespace std;

/*
 * Nel momento in cui si dichiara una ereditarietà multipla si può andare incontro a due tipi di problemi:
 * 1) name clash (ambiguità di nome);
 * 2) problema del diamante.
 *
 * In questo file verrà trattato il problema del name clash.
 *
 * Il problema del name clash si verifica nel momento in cui una classe eredita da più classi non legate
 * tra loro da legami di ereditarietà e queste presentano un metodo con lo stesso nome. Il compilatore
 * non sa quale metodo eseguire. Vi è ambiguità.
 * Per risolvere il problema del name clash esistono due vie. Vedi il main().
 */

class Furgone {
public:
	void targa() {
		cout << "Targa Furgone" << endl;
	}
	void nome() {
		cout << "Nome Furgone" << endl;
	}
};

class Negozio {
public:
	void pIva() {
		cout << "Partita iva Negozio" << endl;
	}
	void nome() {
		cout << "Nome Negozio" << endl;
	}
};

// Ereditarietà multipla:
class Ambulante: public Negozio, public Furgone {
	// La class Ambulante eredita un metodo nome() sia dalla classe Furgone sia dalla classe Negozio.
	// Come fare per risolvere il problema? Vedi il main().
};

int main() {

	Ambulante a;

	a.targa();
	a.pIva();
	//a.nome(); // Problema -> name clash (ambiguità di nome).

	/*
	 * Esistono due soluzioni per risolvere il name clash:
	 * 1) il programmatore esplicita la classe da cui reperire il metodo corretto da eseguire, come nel
	 * caso di "a.Furgone::nome();" (secondo me è la soluzione migliore perchè così non si vincolano gli
	 * oggetti della classe ad un particolare metodo, ma si può decidere di volta in volta all'interno
	 * del main() quale dei tanti utilizzare);
	 * 2) si utilizza "using Negozio::nome;" all'interno della classe soggetta a ereditarietà multipla. In
	 * questo modo si specifica all'interno della classe stessa quale metodo dei tanti ereditati usare.
	 */

	// Soluzione 1:
	a.Furgone::nome();
	a.Negozio::nome();

	return 0;
}

#include <iostream>

using namespace std;

class Figura {

public:

	Figura() {
		cout << "Costruzione figura" << endl;
	}

	void paint() {
		cout << "Paint figura" << endl;
	}

	virtual void print() {
		cout << "Print figura" << endl;
	}

	// Se nella classe sono stati definiti metodi virtuali, allora bisogna
	// definire come virtual anche il distruttore (però non è obbligatorio):
	virtual ~Figura() {
		cout << "Distruzione figura" << endl;
	}
	/*
	 * Nota: è sempre buona norma definire il distruttore come virtual, a prescindere
	 * dalla presenza di metodi virtuali.
	 */

};

class Rettangolo: public Figura {

public:

	Rettangolo() {
		cout << "Costruzione rettangolo" << endl;
	}

	void paint() { // Ridefinizione del metodo paint().
		cout << "Paint rettangolo" << endl;
	}

	// Se un metodo viene definito virtual all'interno della superclasse, allora conserva la sua natura
	// anche all'interno delle sottoclassi. Questo è il motivo per cui nell'override del metodo print()
	// non è presente la keyword virtual.
	void print() { // Overriding del metodo print() di Figura dato che il print() di Figura è virtual.
		cout << "Print rettangolo" << endl;
	}

	// Se il distruttore di oggetti all'interno della superclasse viene definito come virtual, allora
	// conserva la sua natura anche all'interno delle sottoclassi. Questo è il motivo per cui non è
	// presente la keyword virtual prima del simbolo ~.
	~Rettangolo() {
		cout << "Distruzione rettangolo" << endl;
	}
};

int main() {

	Figura *f = new Rettangolo();

	f->paint();
		// Dato che questa chiamata a paint() non è soggetta a binding dinamico (dato che la funzione
		// paint() non è esplicitamente dichiarata come virtual), il metodo paint che viene eseguito
		// non viene deciso in run-time, ma in compilazione.
		// In compilazione f punta ad un oggetto della classe Figura, quindi viene eseguito il paint()
		// definito all'interno della classe Figura.

	f->print();
		// Dato che la funzione print() è definita come virtuale all'interno della superclasse, tale
		// funzione è soggetta a binding dinamico: in compilazione viene selezionato il print presente
		// all'interno della classe Figura, ma in run-time il compilatore switcha alla funzione print()
		// definita all'interno della classe Rettangolo.

	delete f;
	f = NULL;

	return 0;
}

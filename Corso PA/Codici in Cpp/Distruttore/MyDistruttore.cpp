#include <iostream>

using namespace std;

int y1; // Variabile globale visibile a tutti i moduli del progetto.
static int y2 = 0; // Variabile globale visibile solo all'interno di questo modulo MyDistruttore.cpp
// I moduli in C++ sono l'equivalente dei packages in Java.

class A {

	int *data;

public:
	A() {
		cout << "costruisco classe A" << endl;
		this->data = new int[100];
	}

	// Definisco il distruttore di classe:
	virtual ~A() { // Il distruttore non prende mai argomenti.
		cout << "distruggo classe A" << endl;
		// Il distruttore serve per deallocare ciò che viene allocato col costruttore, quindi devo anche
		// eliminare l'array data:
		delete[] this->data; // Per eliminare gli array si scrive il delete in questo modo.
	}
};

void foo1() {
	// Il distruttore viene chiamato implicitamente dal compilatore ogni volta che si deve deallocare
	// un oggetto che risiede sullo stack, come nel caso di a1.
	A a1;
}

void foo2() {
	// Per le variabili che vengono dichiarate con l'operatore new viene stanziata un certo quantitativo
	// di memoria all'interno dello heap. Per le variabili che risiedono nello heap, come nel caso di a2,
	// il distruttore non viene implicitamente chiamato dal compilatore.
	A *a2 = new A;
}

void foo3() {
	// Per poter liberare la memoria dello heap devo utilizzare la keyword delete. La keyword delete fa in
	// modo che il compilatore chiami il distruttore di classe.
	A *a3 = new A;
	delete a3;

	// Attenzione: dopo la delete è buona norma inserire anche una inizializzazione a NULL del puntatore
	// su cui è stata effettuata la delete. Questo è per evitare che ci siano dei dangling pointer.
	a3 = NULL;
}

int main() {

	cout << endl << "Chiamata foo1():" << endl;
	foo1(); // Per questa funzione il compilatore chiama implicitamente il distruttore.

	cout << endl;

	cout << "Chiamata foo2():" << endl;
	foo2(); // Per questa funzione il compilatore NON chiama implicitamente il distruttore.

	cout << endl;

	cout << "Chiamata foo3():" << endl;
	foo3(); // Per questa funzione il compilatore chiama implicitamente il distruttore.

	return 0;
}

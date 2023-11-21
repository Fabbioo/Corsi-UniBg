#include <iostream>

using namespace std;

/*
 * Il distruttore in C++ serve per deallocare la memoria precedentemente allocata dal costruttore.
 *
 * Nel contesto di una gerarchia:
 * _ l'ordine di chiamata dei costruttori prevede che si parta da quello della classe base e che
 *   si scenda poi lungo tutta la gerarchia fino ad arrivare al tipo della variabile allocata;
 * _ l'ordine di chiamata dei distruttori è inverso: si parte da quello della classe derivata e si
 *   risale la gerarchia fino ad arrivare al distruttore di oggetti della classe base.
 *
 * Nel caso di oggetti allocati sullo stack, il distruttore viene automaticamente invocato nel
 * momento in cui il programma termina la propria esecuzione.
 *
 * Nel caso di puntatori, affinchè il distruttore venga invocato è necessario specificare la keyword
 * delete nel momento in cui il puntatore non servirà più.
 *
 * è consigliabile dichiarare sempre il distruttore virtuale. Questo consiglio deriva da un particolare
 * comportamento inatteso nel momento in cui si hanno variabili polimorfiche.
 * Nel caso di variabili polimorfiche il comportamento dei costruttori rimane invariato rispetto a
 * quanto scritto precedentemente. Il discorso cambia per i distruttori. Infatti, se il distruttore
 * della classe base è virtuale, allora il comportamento dei distruttori è esattamente quello che è stato
 * specificato nel terzo paragrafo. Se il distruttore della classe base non è virtuale, allora nel
 * momento in cui viene eseguita la delete viene invocato solo ed esclusivamentre il distruttore della
 * classe base e nessuno di quelli delle classi intermedie.
 */

class A {
public:
	A() {
		cout << "Costruisco oggetto A" << endl;
	}

	virtual ~A() {
		cout << "Distruggo oggetto A" << endl;
	}
};

class B: public A {
public:
	B() {
		cout << "Costruisco oggetto B" << endl;
	}
	~B() {
		cout << "Distruggo oggetto B" << endl;
	}
};

class C {
public:
	C() {
		cout << "Costruisco oggetto C" << endl;
	}

	~C() {
		cout << "Distruggo oggetto C" << endl;
	}
};

class D: public C {
public:
	D() {
		cout << "Costruisco oggetto D" << endl;
	}
	~D() {
		cout << "Distruggo oggetto D" << endl;
	}
};

int main() {

	// VARIABILI SULLO STACK:
	cout << "VARIABILI SULLO STACK: " << endl << endl;

	A a; // Vengono invocati sia il costruttore sia il distruttore di A.
	B b; // Vengono invocati sia il costruttore sia il distruttore di A e B.
	C c; // Vengono invocati sia il costruttore sia il distruttore di C.
	D d; // Vengono invocati sia il costruttore sia il distruttore di C e D.

	// PUNTATORI NON POLIMORFICI:
	cout << endl << "VARIABILI NON POLIMORFICHE:" << endl << endl;

	A *a1 = new A; // Viene invocato solo il costruttore di A.
	delete a1; // Viene invocato il distruttore di A.

	B *b1 = new B; // Vengono invocati sia il costruttore di A sia il costruttore di B.
	delete b1; // Vengono invocati sia il distruttore di B sia il distruttore di A.

	C *c1 = new C; // Viene invocato solo il costruttore di C.
	delete c1; // Viene invocato il distruttore di C.

	D *d1 = new D; // Vengono invocati sia il costruttore di C sia il costruttore di D.
	delete d1; // Vengono invocati sia il distruttore di D sia il distruttore di C.

	// PUNTATORI POLIMORFICI:
	cout << endl << "VARIABILI POLIMORFICHE:" << endl << endl;

	A *a2 = new B; // Vengono invocati sia il costruttore di A sia il costruttore di B.
	delete a2; // Vengono invocati sia il distruttore di B sia il distruttore di A perchè il distruttore di A è virtuale.

	C *c2 = new D; // Vengono invocati sia il costruttore di C sia il costruttore di D
	delete c2; // Viene invocato solo ed esclusivamente il distruttore della classe base C perchè il distruttore di C non è virtuale.

	return 0;
}

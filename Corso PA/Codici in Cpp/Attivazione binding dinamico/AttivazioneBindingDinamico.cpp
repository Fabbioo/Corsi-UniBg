#include <iostream>

using namespace std;

/*
 * Attenzione:
 * NON basta che una funzione sia dichiarata come virtuale per attivare il binding dinamico!
 * Per attivare il binding dinamico bisogna accedere alla chiamata della funzione virtuale
 * sfruttando un puntatore o un riferimento.
 */

class Studente {

public:

	Studente() {
		cout << "Costruzione studente" << endl;
	}

	virtual ~Studente() {
			cout << "Distruzione studente" << endl;
	}

	void getMatricola() {
		cout << "Matricola" << endl;
	}

	virtual void print() {
		cout << "Studente" << endl;
	}

};

class StudenteMagistrale: public Studente {

public:

	StudenteMagistrale() {
		cout << "Costruzione studente magistrale" << endl;
	}

	~StudenteMagistrale() {
			cout << "Distruzione studente magistrale" << endl;
	}

	void getMatricola() { // Ridefinizione.
		cout << "Matricola magistrale" << endl;
	}

	void print() { // Overriding.
		cout << "Studente magistrale" << endl;
	}

};

int main() {

	Studente *s = new StudenteMagistrale();

	s->getMatricola(); // Il binding dinamico non si attiva perchè getMatricola() non è virtual nella classe Studente.
	s->print(); // Il binding dinamico si attiva perchè print() è virtual nella classe Studente.

	Studente ss; // La variabile ss viene posizionata nello stack e non nello heap!

	ss.getMatricola();
	// Il compilatore pensa (giustamente) che ss sia un oggetto della classe Studente.

	ss.print();
	// Il compilatore pensa che ss sia un oggetto della classe Studente e non uno della classe
	// StudenteMagistrale. Questo accade perchè la funzione print(), pur essendo virtuale, viene
	// chiamata da una variabile che non è un puntatore. Ne segue che print() non è soggetta a
	// binding dinamico.

	delete s;
	s = NULL;

	return 0;
}

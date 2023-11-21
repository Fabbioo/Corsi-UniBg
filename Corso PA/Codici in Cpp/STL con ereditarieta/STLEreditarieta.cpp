#include <iostream>
#include <vector>

using namespace std;

// STL e l'ereditarietà non vanno molto d'accordo.

class Persona {
public:
	virtual ~Persona() {}
	virtual void print() {
		cout << "Persona" << endl;
	}

};

class Studente: public Persona {
public:
	virtual void print() {
		cout << "Studente" << endl;
	}
};

int main() {

	Persona p;
	p.print();

	Studente s;
	s.print();

	Persona *ptr_p = &s; // Va bene perchè Studente è sottotipo di Persona e l'ereditarietà è pubblica.
	ptr_p->print();

	vector<Persona> amici1;

	amici1.push_back(p);
	amici1.push_back(s);

	cout << endl;
	amici1[0].print();
	amici1[1].print();
	// Viene stampato entrambe le volte Persona. Questo accade perchè il compilatore effettua
	// lo slicing: vector è del tipo Persona e quando si carica dentro un oggetto della
	// sottoclasse Studente, viene memorizzato al posto della classe Studente la classe Persona.

	// Per evitare lo slicing bisogna modificare il codice:
	vector<Persona*> amici2;

	amici2.push_back(&p);
	amici2.push_back(&s);

	cout << endl;
	amici2[0]->print();
	amici2[1]->print();

	return 0;
}

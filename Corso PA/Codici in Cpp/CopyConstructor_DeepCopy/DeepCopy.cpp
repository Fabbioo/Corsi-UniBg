#include <iostream>

using namespace std;

/*
 * Per risolvere il problema del copy constructor messo in evidenza nel file ShallowCopy.cpp bisogna
 * cambiare approccio, sfruttando quello della cosiddetta deep copy.
 *
 * La deep copy prevede che il contenuto della memoria allocata dinamicamente venga duplicato da un
 * puntatore all'altro -> viene duplicata l'area di memoria che viene assegnata ad ogni puntatore.
 */

class Persona {

public:

	char *nome;

	Persona(char *nome) {
		this->nome = new char[strlen(nome) + 1];
		strcpy(this->nome, nome);
	}

	/*
	 * Definisco un mio copy constructor che effettui una deep copy anzichè una shallow copy.
	 *
	 * Di fatto, un copy constructor è un costruttore che presenta lo stesso nome della classe.
	 * La particolarità sta nel fatto che un copy constructor user defined prende come parametro
	 * di input un riferimento ad un oggetto della stessa classe.
	 *
	 * In questo modo viene duplicata la memoria e non solo i puntatori che puntano allo stesso
	 * indirizzo di memoria.
	 */

	Persona(Persona &p) {
		this->nome = new char[strlen(nome) + 1];
		strcpy(this->nome, p.nome);
	}

	virtual ~Persona() {
		cout << nome << " distrutto" << endl;
		delete[] this->nome;
	}

	void saluta() {
		cout << "Ciao da " << nome << endl;
	}

};

int main() {

	Persona p1((char*) "Fabio");
	p1.saluta(); // Stampa: Ciao da Fabio -> OK.

	Persona p2 = p1; // Viene effettuata una deep copy.
	p2.saluta(); // Stampa: Ciao da Fabio -> OK.

	strcpy(p1.nome, "Antonio");

	p1.saluta(); // Stampa: Ciao da Antonio -> OK.
	p2.saluta(); // Stampa: Ciao da Fabio -> OK.

	return 0;
}

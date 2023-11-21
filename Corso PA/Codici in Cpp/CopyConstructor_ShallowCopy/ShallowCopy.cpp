#include <iostream>

using namespace std;

/*
 * Cosa succede se un oggetto appena istanziato viene assegnato ad un altro della medesima classe?
 * Il compilatore esegue la copia del primo oggetto nel secondo NON usando il costruttore di oggetti
 * della classe, ma sfruttando un particolare costruttore, detto copy constructor.
 * Il compilatore crea DA SOLO un copy constructor di default e lo esegue (a meno che non sia stato
 * preventivamente definito in modo esplicito un copy constructor dall'utente stesso).
 *
 * Com'è fatto il copy constructor di default? Perchè l'utente ne dovrebbe definire uno a parte?
 *
 * Il copy constructor di default copia uno per uno tutti gli attributi di un oggetto in un altro.
 * La copia che viene effettuata degli attributi è superficiale (shallow): la copia viene sempre
 * effettuata per valore da un valore ad un altro.
 *
 * Si hanno dei problemi nel momento in cui ad essere copiati sono dei puntatori. Attraverso la shallow copy
 * anche un attributo costituito da un puntatore viene copiato nel secondo oggetto per valore. Ciò implica
 * che il puntatore del nuovo oggetto punta alla stessa area di memoria del primo. Ne segue che i due
 * condividono la stessa area di memoria. Si tratta di un comportamento indesiderato perchè, in generale,
 * si vuole che ogni oggetto sia indipendente da tutti gli altri.
 */

class Persona {

public:

	char *nome;

	Persona(char *nome) {
		this->nome = new char[strlen(nome) + 1];
		strcpy(this->nome, nome);
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

	Persona p1((char*)"Fabio");

	p1.saluta(); // Stampa: Ciao da Fabio -> OK.

	// Eseguo il copy constructor di default generato dal compilatore:
	Persona p2 = p1; // Viene effettuata una shallow copy.

	p2.saluta(); // Stampa: Ciao da Fabio -> OK.

	strcpy(p1.nome, "Antonio");

	p1.saluta(); // Stampa: Ciao da Antonio -> OK.
	p2.saluta(); // Stampa: Ciao da Antonio -> PROBLEMA.

	// Il problema si è generato perchè anche l'attributo nome di p2 è stato cambiato.
	// La modifica al campo nome di p1 è stata propagata al campo nome di p2. Ciò è accaduto perchè
	// tutti e due i puntatori p1 e p2 condividono la stessa area di memoria per effetto della
	// shallow copy eseguita dal copy constructor di default.

	// Nota dalla stampa anche l'effetto dell'azione del distruttore!

	return 0;
}

#include "MyTime.hpp"

using namespace std;

// Non vi è alcun vincolo sul nome di questo file.

// In questo file .cpp si deve implementare tutto ciò che ho solo dichiarato nel file .hpp

// Esempio di sintassi per l'implementazione del costruttore di oggetti della classe MyTime SENZA argomenti.
// La prima riga si legge: implemento il costruttore MyTime() privo di argomenti della classe MyTime presente
// nel file MyTime.hpp
MyTime::MyTime() {
	this->hour = 0;
	this->min = 0;
	this->sec = 0;
	cout << "Costruttore privo di argomenti" << endl;
}

// Esempio di sintassi per l'implementazione del costruttore di oggetti della classe MyTime CON argomenti.
// La prima riga si legge: implemento il costruttore MyTime() che prende 3 input della classe MyTime presente
// nel file MyTime.hpp
MyTime::MyTime(int h, int m, int s) {
	this->hour = h;
	this->min = m;
	this->sec = s;
	cout << "Costruttore con argomenti" << endl;
}

void MyTime::printOrario() {
	cout << "Orario: " << hour << ":" << min << ":" << sec << endl;
}

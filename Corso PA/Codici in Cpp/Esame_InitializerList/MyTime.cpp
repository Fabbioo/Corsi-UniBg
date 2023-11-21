#include "MyTime.hpp"

using namespace std;

/*
 * Il contesto in cui si collocano le liste di inizializzazione è quello in cui si deve creare un
 * oggetto con i campi settati a valori ad-hoc. Nella fattispecie, le liste di inizializzazione
 * rappresentano un sistema che consente al compilatore di risparmiare del tempo in questa fase.
 *
 * Senza le liste di inizializzazione, un oggetto viene creato e, contestualmente, i suoi campi
 * vengono inizializzati ad un valore di default. Successivamente, i valori di default vengono
 * sovrascritti con quelli ad-hoc per la particolare implementazione. L'operazione di sovrascrittura
 * comporta una inutile perdita di tempo.
 *
 * Le liste di inizializzazione consentono di fare in modo che i valori dei campi non vengano settati
 * a valori di default al momento della creazione dell'oggetto, ma a valori specifici stabiliti dal
 * programmatore. In questo senso le liste di inizializzazione fanno risparmiare del tempo al compilatore.
 */

// Versioni SENZA lista di inizializzazione:

//MyTime::MyTime() {
//	this->hour = 0;
//	this->min = 0;
//	this->sec = 0;
//	cout << "Costruttore privo di argomenti" << endl;
//}

//MyTime::MyTime(int h, int m, int s) {
//	this->hour = h;
//	this->min = m;
//	this->sec = s;
//	cout << "Costruttore con argomenti" << endl;
//}

// Versioni CON lista di inizializzazione:

MyTime::MyTime(): hour(0), min(0), sec(0) {
	cout << "Costruttore privo di argomenti" << endl;
}

MyTime::MyTime(int h, int m, int s): hour(h), min(m), sec(s) {
	cout << "Costruttore con argomenti" << endl;
}

MyTime::~MyTime() {
	cout << "Distruzione" << endl;
}
void MyTime::printOrario() {
	cout << "Orario: " << hour << ":" << min << ":" << sec << endl;
}

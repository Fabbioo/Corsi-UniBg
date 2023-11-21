#include <iostream>

using namespace std;

class Counter {

private:

	int val;

public:
	// La keyword inline non cambia il significato della sintassi. Sta solo a significare che, laddove è
	// presente la chiamata alla funzione inc(), non si deve costruire tutto il record di attivazione.
	// Fondamentalmente, la inline dice al compilatore di eseguire solo quello che c'è scritto (in questo
	// caso si deve solo ed esclusivamente incrementare di 1 il valore di x ad ogni chiamata di inc()).
	// inline è dunque una funzione per cui la chiamata viene sostituita con il corpo della funzione.
	// Questo permette di eliminare tutto l'overhead associato alla chiamata della funzione.
	// è utile soprattutto nel caso di funzioni composte da poche istruzioni.
	Counter() {
		this->val = 0;
	}

	inline void inc(int *x) {
		(*x)++;
	}
};

int main() {

	int y = 0;
	Counter c;

	c.inc(&y);
	cout << "Valore: " << y << endl;

	c.inc(&y);
	cout << "Valore: " << y << endl;

	c.inc(&y);
	cout << "Valore: " << y << endl;

	c.inc(&y);
	cout << "Valore: " << y << endl;

	return 0;
}

#include <iostream>

using namespace std;

// Nel caso della funzione foo(), se nel main viene chiamata, allora bisogna necessariamente specificare
// il valore del primo parametro. Se il valore del secondo parametro non viene specificato, allora si
// assume automaticamente che questo valga 0. Se viene specificato, il valore scritto va a sovrascrivere
// il valore di default 0.

// Vincolo del C++: i default arguments vanno specificati al termine della dichiarazione della funzione.
void foo(int x, int y = 0) {
	cout << x << " " << y << endl;
}

int main() {

	foo(8); // Stampa: 8 0.
	foo(8, 10); // Stampa: 8 10.

	return 0;
}

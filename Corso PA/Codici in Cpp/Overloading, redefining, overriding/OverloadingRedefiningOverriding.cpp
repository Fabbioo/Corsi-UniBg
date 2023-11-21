#include <iostream>

using namespace std;

class Base {

public:

	virtual ~Base() {}

	// Dichiaro un metodo m() nella classe base per poter effettuare sia l'overloading sia la ridefinizione:
	void m() {
		cout << "BASE -> Metodo m() di cui effettuare sia l'overload sia la ridefinizione." << endl;
	}

	// Overload del metodo m():
	void m(int x) {
		cout << "BASE -> Overload del metodo m()." << endl;
	}

	// Dichiaro un metodo n() come virtual per poter effettuarne l'override nella classe derivata:
	virtual void n() {
		cout << "BASE -> Metodo n() di cui effettuare l'override nella classe DERIVATA." << endl;
	}
};

class Derived: public Base {
public:

	// In C++ la RIDEFINIZIONE di un metodo in una sottoclasse viene effettuata tenendo nel nuovo metodo
	// lo stesso nome di quello presente nella classe derivata. Non è necessario che la lista dei
	// parametri sia diversa.

	// Ridefinizione del metodo m() della classe base:
	void m() {
		cout << "DERIVATA -> Metodo m() (ridefinizione 1)." << endl;
	}

	// Un'altra ridefinizione del metodo m() della classe base:
	void m(int x) {
		cout << "DERIVATA -> Metodo m(int x) (ridefinizione 2)." << endl;
	}

	// Override del metodo n() dichiarato nella classe base:
	void n() {
		cout << "DERIVATA -> Override del metodo n() dichiarato nella classe BASE." << endl;
	}

};

int main() {

	Derived d;
	int x = 0;

	// Mi riferisco al metodo m() della classe Base:
	d.Base::m();

	// Mi riferisco al metodo overload:
	d.Base::m(x);

	// Mi riferisco ai metodi ridefiniti:
	d.m(); // Ridefinizione 1.
	d.m(x); // Ridefinizione 2.

	// Mi riferisco al metodo n() della classe Base:
	d.Base::n();

	// Mi riferisco al metodo override:
	d.n();

	return 0;
}

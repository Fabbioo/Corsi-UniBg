#include <iostream>

using namespace std;

class BaseNoArgomenti {
public:
	BaseNoArgomenti() {
		cout << "Costruisco la base (superclasse) senza argomenti" << endl;
	}
	~BaseNoArgomenti() {
		cout << "Distruggo la base (superclasse) senza argomenti" << endl;
	}
};

class DerivedNoArgomenti: public BaseNoArgomenti {
public:
	DerivedNoArgomenti() {
		cout << "Costruisco la derivata (sottoclasse) senza argomenti" << endl;
	}
	~DerivedNoArgomenti() {
		cout << "Distruggo la derivata (sottoclasse) senza argomenti" << endl;
	}
};

class Base {
public:
	Base(int x) {
		cout << "Costruisco la base (superclasse) con argomento " << x << endl;
	}
	~Base() {
		cout << "Distruggo la base (superclasse) con argomento" << endl;
	}
};

class Derived: public Base {
	int y;
public:
	Derived(): Base(4), y(0) {
		cout << "Costruisco la derivata (sottoclasse) con argomento " << y << endl;
	}
	~Derived() {
		cout << "Distruggo la derivata (sottoclasse) con argomento" << endl;
	}
};

int main() {

	DerivedNoArgomenti d1;

	Derived d2;

	return 0;
}

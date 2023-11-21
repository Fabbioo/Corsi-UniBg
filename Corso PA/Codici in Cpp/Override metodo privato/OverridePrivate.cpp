#include <iostream>

using namespace std;

class Figura {

private:

	virtual void calcolaPerimetro() {
		cout << "Calcola perimetro figura" << endl;
	}

public:

	Figura() {
		cout << "Costruzione oggetto figura" << endl;
	}

	virtual ~Figura() {
		cout << "Distruzione oggetto figura";
	}

	void calcolaArea() { // Metodo pubblico che utilizza un metodo privato.
		calcolaPerimetro(); // Va bene perchè entrambi i metodi appartengono alla classe Figura.
		cout << "Calcola area figura" << endl;
	}

};

class Cerchio: public Figura {

private:

	// Override di un metodo privato.
	void calcolaPerimetro() {
		cout << "Calcola perimetro cerchio" << endl;
	}

public:

	Cerchio() {
		cout << "Costruzione oggetto cerchio" << endl;
	}

	~Cerchio() {
		cout << "Distruzione oggetto cerchio" << endl;
	}

};

int main() {

	Cerchio c;

	c.calcolaArea();

	return 0;
}

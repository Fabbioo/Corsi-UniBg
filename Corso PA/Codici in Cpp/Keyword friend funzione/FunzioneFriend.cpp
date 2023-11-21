#include <iostream>

using namespace std;

class MyClass {

	int myAttr;

public:

	MyClass(int a) {
		this->myAttr = a;
	}

	int getMyAttr() {
		return myAttr;
	}

	/*
	 * Suppongo di voler dichiarare una funzione globale che, per un qualche motivo, ha la
	 * necessità di accedere direttamente ad un oggetto della classe MyClass per alterare
	 * il valore dell'attributo myAttr.
	 */

	friend void friendFunc(MyClass &myClass, int x);

	/*
	 * In questo modo la classe MyClass considera la funzione friendFunc una funzione amica
	 * e le permette di accedere ai suoi membri privati.
	 * Nota: è la classe stessa a concedere il titolo di amica e non viceversa!
	 */
};

void friendFunc(MyClass &myClass, int x) {
	myClass.myAttr = x;
}

int main() {
	MyClass mc(20);
	cout << mc.getMyAttr() << endl;
	friendFunc(mc, 87);
	cout << mc.getMyAttr() << endl;
	return 0;
}

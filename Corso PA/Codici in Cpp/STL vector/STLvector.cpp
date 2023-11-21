#include <iostream>
#include <vector>

using namespace std;

int main() {

	vector<int> vettore;

	// Il metodo push_back() aggiunge gli elementi in coda:
	vettore.push_back(5);
	vettore.push_back(8);
	vettore.push_back(2);

	cout << vettore[0] << " " << vettore[1] << " " << vettore[2] << endl;

	vettore[0] = 9;

	cout << vettore[0] << " " << vettore[1] << " " << vettore[2] << endl;

	cout << vettore.at(1) << endl;

	cout << endl << "Ciclo for: ";
	for(int i = 0; i < vettore.size(); i++)
		cout << vettore[i] << " ";

	// Sfrutto l'iterator:
	cout << endl << "Iteratore: ";
	for(vector<int>::iterator j = vettore.begin(); j != vettore.end(); j++)
		// Si deve pensare all'iteratore come se fosse un puntatore che scorre tutto il vettore, perciò per
		// accedere agli elementi del vettore bisogna dereferenziare:
		cout << *j << " ";

	return 0;
}

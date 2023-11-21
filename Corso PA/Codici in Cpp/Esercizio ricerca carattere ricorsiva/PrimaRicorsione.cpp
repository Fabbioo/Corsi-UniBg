#include <iostream>
using namespace std;

bool cerca(char carattere, char *array) {

	cout << "Cerco " << carattere << " in " << array << endl;

	// Se la stringa è vuota, sicuramente il carattere non è presente nella stringa.
	if (*array == '\0')
		return false;

	// Se il carattere è il primo elemento della stringa ritorna true.
	if (carattere == array[0]) // Equivalentemente: if (carattere == *array)
		return true;

	// Cerca il carattere nel resto della stringa.
	return cerca(carattere, array + 1);
}

// GUARDA IL RECORD DI ATTIVAZIONE SU ONENOTE

// Attenzione: questa è una tail recursion.
int main() {

	char nome[] = "Asdrubale";

	cout << cerca('d', nome) << endl;
	cout << cerca('k', nome) << endl;

	return 0;
}

#include<iostream>

using namespace std;

// Verifico la presenza di numeri pari all'interno di un array di interi.

// Versione iterativa.
bool contains_iter(int array[], int size) {
	for (int i = 0; i < size; i++)
		if (array[i] % 2 == 0)
			return true;
	return false;
}

// Versione ricorsiva con tail.
bool contains_tail(int array[], int size) {
	if (size == 0)
		return false;
	if (array[0] % 2 == 0)
		return true;
	return contains_tail(array + 1, size - 1);
}

int main() {

	int array1[] = { 1, 3, 5, 7, 8, 9 };
	int array2[] = { 1, 3, 5, 7, 9 };

	int dimensione1 = sizeof(array1) / sizeof(int);
	int dimensione2 = sizeof(array2) / sizeof(int);

	cout << "L'array 1 contiene numeri pari? Iter -> " << contains_iter(array1, dimensione1) << endl;
	cout << "L'array 1 contiene numeri pari? Tail -> " << contains_tail(array1, dimensione1) << endl;

	cout << "L'array 2 contiene numeri pari? Iter -> " << contains_iter(array2, dimensione2) << endl;
	cout << "L'array 2 contiene numeri pari? Tail -> " << contains_tail(array2, dimensione2);

	return 0;
}

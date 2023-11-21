#include <iostream>

using namespace std;

// Dichiaro un metodo swap che sia parametrico rispetto a T:
template<typename T> // Nota che usare <typename T> o <class T> produce lo stesso risultato.
void swapTemp(T &x, T &y) {
	T temp = x;
	x = y;
	y = temp;
}

/*
 * Se una funzione parametrica ritorna un risultato, quel risultato deve essere dello stesso tipo
 * degli input parametrici.
 */

int main() {

	int a = 3;
	int b = 4;

	cout << "Pre swap: " << a << " " << b << endl;
	swapTemp(a, b);
	cout << "Post swap: " << a << " " << b << endl;

	cout << endl;

	char *s1 = (char*) "ciao";
	char *s2 = (char*) "bella";

	cout << "Pre swap: " << s1 << " " << s2 << endl;
	swapTemp(s1, s2);
	cout << "Post swap: " << s1 << " " << s2 << endl;

	return 0;
}

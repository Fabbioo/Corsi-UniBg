#include "MyTime.hpp"

using namespace std;

int main() {

	// Chiamo il costruttore privo di argomenti:
	MyTime t1; // Chiama IMPLICITA al costruttore privo di argomenti.
	MyTime t2 = MyTime(); // Chiamata ESPLICITA al costruttore privo di argomenti.

	// Chiamo il costruttore con argomenti:
	MyTime t3(10,40,23); // Chiamata IMPLICITA al costruttore con argomenti.
	MyTime t4 = MyTime(12,54,10); // Chiamata ESPLICITA al costruttore con argomenti.

	cout << "t1 -> "; t1.printOrario();
	cout << "t2 -> "; t2.printOrario();
	cout << "t3 -> "; t3.printOrario();
	cout << "t4 -> "; t4.printOrario();

	/*
	 * NOTE IMPORTANTI.
	 *
	 * Le variabili che vengono dichiarate SENZA l'uso del new vengono allocate sullo stack.
	 * Le variabili che vengono dichiarate CON il new vengono allocate nello heap.
	 *
	 * Le variabili sullo stack vengono automaticamente distrutte quando il programma termina.
	 * Le variabili sullo heap necessitano di una distruzione esplicita per mano del programmatore.
	 *
	 * Gli oggetti puntatori vanno costruiti con il new, come ad esempio:
	 * TypeName *pointer = new TypeName;
	 * La clausola new invoca il costuttore di oggetti di tipo TypeName.
	 * In questo caso, non essendoci alcun parametro di input alla chiamata "new TypeName" viene
	 * invocato il costruttore TypeName(), ovvero il costruttore di oggetti della classe TypeName
	 * privo di argomenti.
	 *
	 * Se avessi, ad esempio, TypeName *pointer = new TypeName(1,1); verrebbe invocato il costruttore
	 * di oggetti della classe TypeName che prende in input due valori.
	 */

	return 0;
}

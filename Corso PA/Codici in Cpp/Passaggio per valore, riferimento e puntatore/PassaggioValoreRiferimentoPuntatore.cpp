#include <iostream>

using namespace std;

// Passaggio per valore:
int f_byvalue(int x) {
    x += 1;
    return x;
}

// Passaggio per riferimento:.
int f_byref(int &x) {
    x += 1;
    return x;
}

// Passaggio di un puntatore:
int f_bypunt(int *x) {
//    x += 1; // Questa istruzione incrementa il valore del puntatore, non il valore puntato (aritmetica dei puntatori).
    *x += 1; // Questa istruzione incrementa il valore puntato.
    return *x;
}

int main() {

    int y = 0;

    cout << "VALORE. \tValore di y restituito dalla funzione: " << f_byvalue(y)
    	 << ". Valore di y dopo l'esecuzione della funzione: " << y << endl;
    cout << "RIFERIMENTO. \tValore di y restituito dalla funzione: " << f_byref(y)
    	 << ". Valore di y dopo l'esecuzione della funzione: " << y << endl;
    cout << "PUNTATORE. \tValore di y restituito dalla funzione: " << f_bypunt(&y)
    	 << ". Valore di y dopo l'esecuzione della funzione: " << y << endl;
        /*
         * Alla funzione f_bypunt() non posso passare un intero, ma un puntatore ad un intero.
         * Quindi non posso passare semplicemente la variabile y, ma la devo referenziare sfruttando &.
        */

    return 0;
}

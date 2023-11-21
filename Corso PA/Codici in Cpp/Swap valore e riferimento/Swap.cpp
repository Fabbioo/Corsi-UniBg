#include<iostream>
using namespace std;

// Metodo che scambia i valori di due variabili passate per valore.
void swap_byvalue(int q, int w) {
    int temp = q;
    q = w;
    w = temp;
}

// Metodo che scambia i valori di due variabili passate per riferimento.
void swap_byref(int &q, int &w) {
    int temp = q;
    q = w;
    w = temp;
}

// Guarda i record di attivazione su OneNote.

int main() {

    int x = 2;
    int y = 3;

    cout << "PRE SWAP:" << endl;
    cout << "Valore di x: " << x << endl;
    cout << "Valore di y: " << y << endl;

    swap_byvalue(x,y);

    cout << endl << "POST SWAP BY VALUE:" << endl;
    cout << "Valore di x: " << x << endl;
    cout << "Valore di y: " << y << endl;

    swap_byref(x,y);

    cout << endl << "POST SWAP BY REF:" << endl;
    cout << "Valore di x: " << x << endl;
    cout << "Valore di y: " << y << endl;

    return 0;
}

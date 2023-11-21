#include <iostream>

using namespace std;

// Scrivo un metodo che calcola il valore x^y:
int power(int &a, int &b) {
    int res = 1;
    while(b-- > 0)
        res *= a;
    return res;
}

int main() {
    /* La seguente linea di codice non funziona perchè quando sfrutto il passaggio per
    riferimento non posso passare delle costanti (ovvero degli r-values), ma solo delle
    variabili (l-values).
    cout << power(2,2) << endl; */

    // Per evitare l'errore di cui sopra dichiaro due variabili.
    int x = 2;
    int y = 4;
    cout << "Valore di x prima dell'esecuzione della funzione: " << x << endl;
    cout << "Valore di y prima dell'esecuzione della funzione: " << y << endl;
    cout << endl << "Esecuzione della funzione: " << power(x, y) << endl << endl;
    cout << "Valore di x dopo l'esecuzione della funzione: " << x << endl;
    cout << "Valore di y dopo l'esecuzione della funzione: " << y << endl << endl;

    return 0;
}

#include <iostream>

using namespace std;

/*
 * Con i puntatori a puntatori non si modifica il valore del puntatore a puntatore, ma il valore del
 * puntatore che viene puntato dal puntatore a puntatore.
 */

int y = 10;

void styp(int *p) { // p punta a ciò che viene puntato da q (uguaglianza tra puntatori).
    p = &y; // A p viene assegnato l'indirizzo di memoria di y.
}

void stypp(int **p) { // p è un puntatore che punta ad un puntatore di interi (ovvero q). p non punta a ciò che viene puntato da q, ma punta a q dato che q è un puntatore a interi e p è un puntatore a puntatore di interi.
    *p = &y; // Assegno a ciò che viene puntato da p (ovvero q) l'indirizzo di memoria di y.
}

int main() {

    int m = 0;
    int *q = &m; // q è un puntatore a intero che punta all'indirizzo di memoria di m, non al contenuto di m.

    styp(q); // A styp sto passando l'indirizzo di memoria di m dato che a q è stato dichiarato come puntatore all'indirizzo di memoria di m.

    cout << "Valore puntato da q: " << *q << endl;

    stypp(&q); // A stypp passo l'indirizzo di memoria di q, non ciò che è puntato da q (ovvero l'indirizzo di memoria di m).

    cout << "Valore puntato da q: " << *q;

    return 0;
}

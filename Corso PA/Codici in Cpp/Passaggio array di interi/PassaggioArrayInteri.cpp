#include <iostream>
using namespace std;

/*
 * Suppongo di disporre di un metodo che calcola la media dei valori di un array.
 * In C/C++ il passaggio degli array avviene col passaggio del puntatore al primo elemento dell'array.
*/
double media(int numbers[3]) {

    double somma = 0;

    for(int i = 0; i < 3; i++)
        somma += numbers[i];

    return somma/3;

    /* ATTENZIONE.

    In questo caso, numbers è il puntatore al primo elemento dell'array y.
    Quando si passano degli array a delle funzioni si perde completamente l'informazione relativa
    alla dimensione dell'array, tant'è che il 3 in [3] di fianco a numbers nella firma del metodo media
    viene completamente ignorato. Si dice, infatti, che in C/C++ gli array decadono a puntatori.

    In virtù di quanto appena detto, ho che le seguenti firme sono del tutto equivalenti:
    double media(int numbers[3])
    double media(int numbers[])
    double media(int *numbers) (questa è quella che meglio riflette il concetto sopra esposto: numbers
    è un puntatore al primo intero della variabile che viene passata in input alla funzione media).

    Quello che si fa spesso per sopperire al fatto che il C/C++ non trasporti con sè l'informazione
    relativa alla dimensione dell'array è dichiarare la firma del metodo in modo che possa accettare
    due parametri. Come secondo parametro viene esplicitamente passata la dimensione dell'array.
    Esempio di implementazione: double media(int numbers[3], int n)
    Nel main dovrei scrivere: cout << ...SCRITTE VARIE... << media(y, sizeof(y)/sizeof(int)) << endl;

    Da notare che anche il 3 nell'intestazione del ciclo for e il /3 nella clausola return sono
    "inutili": sostituendo tali 3 con altri valori, C/C++ non protesterebbe in alcun modo.
    */
}


int main() {

    int y[] = { 1, 2, 4 };

    cout << "La media dei valori nell'array y è: " << media(y) << endl;
    cout << "L'array y occupa " << sizeof(y) << " bytes in memoria." << endl;
    cout << "L'array y è composto da " << sizeof(y)/sizeof(int) << " elementi." << endl;

    return 0;
}

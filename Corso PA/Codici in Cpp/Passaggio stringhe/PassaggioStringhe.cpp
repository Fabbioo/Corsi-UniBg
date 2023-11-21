#include <iostream>

using namespace std;

/*
 * Data una stringa, stampa le lettere con dei numeri crescenti.
 * Ad esempio, se la stringa è ciao, stampa 0c 1i 2a 3o.
 */

void stampa(char *s) {
    int i = 0;
    while (*s != '\0') {
        cout << i << *s << "\t";
        s++;
        i++;
    }

    /*
     * Col fatto che le stringhe terminano tutte con il carattere /0 non ho bisogno di passare in
     * input alla funzione stampa() la dimensione della stringa.
     */
}

int main() {

    char name1[] = "pippo";
    stampa(name1); // Viene automaticamente aggiunto il \0 dopo pippo.

    cout << endl;

    char name2[] = {'A', 'd', 'a'};
    stampa(name2);
    // Per capire il perchè di questo comportamento guarda il record di attivazione su OneNote.
    // Dato che lo stack cresce in altezza partendo dal basso, prima viene allocato lo spazio per pippo e poi
    // quello per Ada. Dato che dopo pippo non c'è più niente, viene automaticamente aggiunto il \0.

    // Se scrivessi char name1[] = "pippo\0"; non cambierebbe nulla.
    // char name2[] = {'A', 'd', 'a', '\0'}; alla seconda chiamata della funzione stampa() verrebbe stampato
    // solo tutto ciò che riguarda Ada (0A	1d	2a)

    return 0;
}

#ifndef MATRICE_H_
#define MATRICE_H_

typedef struct matrice *matriceRef;

matriceRef creaMatrice(int);
char* toString(matriceRef);
void sett(matriceRef, int, int, int); // TODO
matriceRef somma(matriceRef, matriceRef); // TODO
void cancellaMatrice(matriceRef*);

#endif /* MATRICE_H_ */

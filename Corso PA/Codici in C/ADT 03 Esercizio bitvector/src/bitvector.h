#ifndef BITVECTOR_H_
#define BITVECTOR_H_

// Definisco la struttura dati come tipo opaco:
typedef struct bitvector *bitVector;

// Definisco il prototipo del costruttore:
bitVector makeBitVector(int);

// Definisco il prototipo dei vari metodi:
bitVector AND(bitVector, bitVector);
bitVector OR(bitVector, bitVector);
bitVector NOT(bitVector);
char* toString(bitVector);
void delete(bitVector*);

#endif /* BITVECTOR_H_ */

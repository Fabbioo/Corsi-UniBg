#ifndef VETTORE_H_
#define VETTORE_H_

typedef struct vettore *vettoreRef;

vettoreRef creaVettore(int, float*);
char* toString(vettoreRef);
vettoreRef sommaVettori(vettoreRef, vettoreRef);
void cancellaVettore(vettoreRef*);

#endif /* VETTORE_H_ */

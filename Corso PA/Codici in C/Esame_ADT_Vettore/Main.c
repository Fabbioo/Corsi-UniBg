#include <stdio.h>
#include "Vettore.h"

int main() {

	float v1[2] = { 8, 12 };
	float v2[2] = { 13, 7 };
	float v3[3] = { 0, -1, 5 };

	vettoreRef vr1 = creaVettore(2, v1);
	vettoreRef vr2 = creaVettore(2, v2);
	vettoreRef vr3 = creaVettore(3, v3);

	printf("Vettore 1: %s", toString(vr1));
	printf("\nVettore 2: %s", toString(vr2));
	printf("\nVettore 3: %s", toString(vr3));

	vettoreRef vsomma1 = sommaVettori(vr1, vr2);
	printf("\n\nVettore somma tra 1 e 2: %s", toString(vsomma1));

	vettoreRef vsomma2 = sommaVettori(vr3, vr2);
	printf("\n\nVettore somma tra 2 e 3: %s", toString(vsomma2));

	cancellaVettore(&vr1);
	cancellaVettore(&vr2);
	cancellaVettore(&vr3);
	cancellaVettore(&vsomma1);
	cancellaVettore(&vsomma2);

	vr1 = NULL;
	vr2 = NULL;
	vr3 = NULL;
	vsomma1 = NULL;
	vsomma2 = NULL;

	return 0;
}

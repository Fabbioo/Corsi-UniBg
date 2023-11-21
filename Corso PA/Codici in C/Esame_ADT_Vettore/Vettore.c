#include <stdio.h>
#include <stdlib.h>
#include "Vettore.h"

struct vettore {
	int n;
	float *vett;
} Vettore;

vettoreRef creaVettore(int n, float vettoreDaCopiare[n]) {
	vettoreRef newVettore = (vettoreRef) malloc(sizeof(Vettore));
	newVettore->n = n;
	newVettore->vett = (float*) malloc(sizeof(float) * n);
	for (int i = 0; i < n; i++)
		newVettore->vett[i] = vettoreDaCopiare[i];
	return newVettore;
}

char* toString(vettoreRef vr) {
	char *stringa = (char*) malloc(sizeof(char) * (vr->n + 50));
	sprintf(stringa, "[");
	for (int i = 0; i < vr->n; i++) {
		sprintf(stringa, "%s%.0f", stringa, vr->vett[i]);
		if (i < vr->n - 1)
			sprintf(stringa, "%s, ", stringa);
	}
	sprintf(stringa, "%s]", stringa);
	return stringa;
}

vettoreRef sommaVettori(vettoreRef vr1, vettoreRef vr2) {

	vettoreRef vettoreSomma = (vettoreRef) malloc(sizeof(Vettore));

	if (vr1->n <= vr2->n) {
		vettoreSomma->vett = (float*) malloc(sizeof(float) * vr2->n);
		vettoreSomma->n = vr2->n;
		for (int i = 0; i <= vr1->n; i++)
			vettoreSomma->vett[i] = vr1->vett[i] + vr2->vett[i];
		for (int i = vr1->n; i <= vr2->n; i++) {
			vettoreSomma->vett[vr1->n + 1] = vr2->vett[i + 1];
		}
	} else {
		vettoreSomma->vett = (float*) malloc(sizeof(float) * vr1->n);
		vettoreSomma->n = vr1->n;
		for (int i = 0; i <= vr2->n; i++)
			vettoreSomma->vett[i] = vr2->vett[i] + vr1->vett[i];
		for (int i = vr2->n; i <= vr1->n; i++) {
			vettoreSomma->vett[vr2->n + 1] = vr1->vett[i + 1];
		}
	}
	return vettoreSomma;
}

void cancellaVettore(vettoreRef *vr) {
	free((*vr)->vett);
	free(*vr);
	*vr = NULL;
}

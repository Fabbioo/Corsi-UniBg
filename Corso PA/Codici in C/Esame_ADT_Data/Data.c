#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Data.h"

struct data {
	int giorno;
	int mese;
	int anno;
	char *fuso;
} Data;

dataRef creaData(int giorno, int mese, int anno, char *fuso) {

	dataRef newData = (dataRef) malloc(sizeof(Data));

	if (giorno < 1 || giorno > 31)
		newData->giorno = 1;
	else
		newData->giorno = giorno;

	if (mese < 1 || mese > 12)
		newData->mese = 1;
	else
		newData->mese = mese;

	newData->anno = anno;

	newData->fuso = (char*) malloc(sizeof(char) * (strlen(fuso) + 1));
	strcpy(newData->fuso, fuso);

	return newData;
}

char* toString(dataRef data) {
	char *stringa = (char*) malloc(sizeof(char) * (13 + strlen(data->fuso) + 1));
	sprintf(stringa, "%d-%d-%d - %s", data->giorno, data->mese, data->anno,	data->fuso);
	return stringa;
}

void distruttore(dataRef *data) {
	free((*data)->fuso);
	free(*data);
	*data = NULL;
}

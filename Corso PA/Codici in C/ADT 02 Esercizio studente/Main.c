#include <stdio.h>
#include <stdlib.h>
#include "studente.h"
#include "corso.h"

int main() {

	studenteRef stud1 = makeStudente("Piero", "Verdi");
	studenteRef stud2 = makeStudente("Mark", "Rossi");
	studenteRef stud3 = makeStudente("Carla", "Menei");

	printf("Metodo printStudente:\n");
	printStudente(stud1);
	printStudente(stud2);
	printStudente(stud3);

	printf("\nMetodo studentData:\n");
	char *cstud1 = studentData(stud1);
	char *cstud2 = studentData(stud2);
	char *cstud3 = studentData(stud3);
	printf("%s\n", cstud1);
	printf("%s\n", cstud2);
	printf("%s\n", cstud3);

	addVoto(stud1, 5);
	addVoto(stud1, 8);
	addVoto(stud1, 9);

	stampaMedia(stud1);

	corsoRef corso1 = makeCorso("Info3");
	addStudent(corso1, stud1);

	free(cstud1);
	free(cstud2);
	free(cstud3);

	cstud1 = NULL;
	cstud2 = NULL;
	cstud3 = NULL;

	deleteStudente(&stud1);
	deleteStudente(&stud2);
	deleteStudente(&stud3);

	return 0;

}

#ifndef CORSO_H_
#define CORSO_H_

#include "studente.h"

typedef struct corso *corsoRef;

corsoRef makeCorso(char*);
void addStudent(corsoRef, studenteRef);

#endif /* CORSO_H_ */

#ifndef STACK_H_
#define STACK_H_

#include <stdbool.h>

typedef struct stackk *stackRef;

stackRef creaStack();
char* toString(stackRef);
void push(stackRef, int);
int pop(stackRef);
bool isEmpty(stackRef);
void cancellaStack(stackRef);

#endif /* STACK_H_ */

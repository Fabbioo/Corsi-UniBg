#ifndef CANE_H_
#define CANE_H_

typedef struct cane *caneRef;

caneRef creaCane(char*);
void abbaia(caneRef);
void distruggiCane(caneRef*);

#endif /* CANE_H_ */

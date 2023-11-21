#include "Cane.h"

int main() {

	caneRef cane1 = creaCane("Fido");

	abbaia(cane1);
	abbaia(cane1);

	distruggiCane(&cane1);

	return 0;
}

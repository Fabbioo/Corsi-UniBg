/*
 * ATTENZIONE.
 * Anche se non esplicitamente scritto, la keyword extern viene automaticamente aggiunta ad ogni definizione.
 *
 * Stando così le cose, una funzione definita all'interno di un sorgente può essere utilizzata sia nel
 * sorgente stesso sia in altri sorgenti. Questo è il comportamento standard.
 *
 * Per alterare questo comportamento si può sfruttare la keyword static, la quale, se posta davanti alla
 * definizione di una funzione, ha come effetto quello di rendere visibile la funzione solo all'interno
 * del sorgente in cui è definita e dichiarata.
 */

extern int sommaExtern(int x, int y) {
	// Come già detto, la keyword extern viene automaticamente aggiunta dal compilatore, perciò la mia
	// definizione aggiuntiva è ridondante.
	return x + y;
}

static int sommaStatic(int x, int y) {
	return x + y;
}

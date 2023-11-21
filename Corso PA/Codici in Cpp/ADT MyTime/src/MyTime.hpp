#ifndef MYTIME_HPP_
#define MYTIME_HPP_

#include <iostream>

class MyTime {

// Con la notazione class tutti i campi dichiarati al suo interno vengono automaticamente definiti private,
// perciò il private alla riga 8 è ridondante.
private:
	int hour, min, sec;

// Anche se i campi vengono automaticamente definiti come private, si possono specificare delle diverse
// regole di visibilità come nel caso della riga 13.
public:
	MyTime();
	MyTime(int, int, int); // Si possono avere più costruttori (come in Java)
	void printOrario();
};

#endif /* MYTIME_HPP_ */

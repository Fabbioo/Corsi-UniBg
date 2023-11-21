#ifndef MYTIME_HPP_
#define MYTIME_HPP_

#include <iostream>

class MyTime {
	int hour, min, sec;
public:
	MyTime();
	MyTime(int, int, int);
	~MyTime();
	void printOrario();
};

#endif /* MYTIME_HPP_ */

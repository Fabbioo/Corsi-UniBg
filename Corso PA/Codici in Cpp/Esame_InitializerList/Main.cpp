#include "MyTime.hpp"

using namespace std;

int main() {

	MyTime t1 = MyTime();
	MyTime t2 = MyTime(12, 54, 10);

	cout << "t1 -> ";
	t1.printOrario();
	cout << "t2 -> ";
	t2.printOrario();

	return 0;
}

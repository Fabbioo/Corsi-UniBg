#include <iostream>

using namespace std;

int f(int &y, int *x) {
	cout << x[0] << x[1] << y << " ";
	if(*x == y) {
		int q = *(x + 1) * ++y;
		return f(q, x + 2);
	}
	return ++y + *x;
}

int main() {
	int a[] = {3, 2, 1, 0};
	int &b = a[0];
	int d = f(b, a);
	cout << a[0] << a[1] << a[2] << a[3] << b << " " << d << endl;
	return 0;
}

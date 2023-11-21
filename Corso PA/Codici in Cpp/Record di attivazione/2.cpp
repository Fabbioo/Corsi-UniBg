//#include <iostream>
//
//using namespace std;
//
//int f(int *pi, int &ri) {
//	if(*pi > ri) {
//		return ++ri;
//	} else {
//		*pi = *pi + 20;
//		return f(pi, ri);
//	}
//}
//
//int main() {
//	int a = 0;
//	int b = 10;
//	int *pa = &a;
//	int &rb = b;
//	cout << f(pa, rb) << endl;
//	return 0;
//}

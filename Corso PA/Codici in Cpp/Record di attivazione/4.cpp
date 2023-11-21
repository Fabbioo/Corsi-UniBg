//#include <iostream>
//
//using namespace std;
//
//int K = 2;
//
//int f(int a, int *b, int &c) {
//	if (a < K) {
//		(*b)++;
//		c++;
//		return *b + f(*b, &a, c);
//	} else {
//		b++;
//		return a * 10;
//	}
//}
//
//int main() {
//	int i = 0;
//	int *j = &i;
//	int &k = i;
//	cout << f(i, j, k) << endl;
//	return 0;
//}
//

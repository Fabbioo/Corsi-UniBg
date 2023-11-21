//#include <iostream>
//using namespace std;
//
//int K = 30;
//
//int m(int x[], int *y, int &z) {
//	if(*y != z) {
//		return m(x, y+1, z);
//	} else {
//		(*x)++;
//		return *x + K;
//	}
//}
//
//int main() {
//	int a[] = {1,4,8};
//	int *b = &a[0];
//	int &c = *(b+1);
//	int z = m(a,b,c);
//	cout << a[0] << " " << a[1] << " " << a[2] << " " << c << " " << z << endl;
//	return 0;
//}

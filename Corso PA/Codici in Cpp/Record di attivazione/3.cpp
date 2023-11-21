//#include <iostream>
//
//using namespace std;
//
//int K = 0;
//int check(int *z) {
//	return *z+K;
//}
//int f(int x, int &y) {
//	if(check(&x) >= y) {
//		int h = ++y;
//		cout << "y " << y << endl;
//		return f(x,h);
//	} else {
//		cout << "y " << y << endl;
//		return ++x * ++y;
//	}
//}
//int main() {
//	int i = 0;
//	int result = f(i,i);
//	cout << "f " << result << endl;
//	cout << "i " << i;
//	return 0;
//}

#include <iostream>

using namespace std;

/*
 * è possibile definire una intera classe come amica di un'altra classe.
 * La motivazione è semplice: consentire ai metodi della classe amica di accedere
 * ai membri privati della classe che la considera amica.
 */

class MyClass {

	int myAttr;

public:

	MyClass(int a) {
		this->myAttr = a;
	}

	int getMyAttr() {
		return this->myAttr;
	}

	friend class MyFriendClass;

	/*
	 * A questo punto la classe MyClass considera la classe MyFriendClass amica, perciò
	 * uno qualunque dei metodi della classe MyFriendClass può accedere al membro privato
	 * della classe MyClass, ovvero myAttr.
	 */
};

class MyFriendClass {
public:
	void setMyAttr(MyClass &mc, int x) {
		mc.myAttr = x;
	}
};

int main() {
	MyClass mc(20);
	cout << mc.getMyAttr() << endl;
	MyFriendClass mfc;
	mfc.setMyAttr(mc, 97);
	cout << mc.getMyAttr() << endl;
	return 0;
}

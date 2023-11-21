/*
 * Se l’ereditarietà è pubblica, si può assegnare un oggetto della sottoclasse a uno della superclasse,
 * ma fai attenzione al seguente aspetto: l’oggetto della classe derivata viene completamente assorbito
 * da quello della classe base, quindi tutti i suoi metodi cessano di esistere e rimangono visibili solo
 * quelli della classe base. Se poi i metodi della classe base sono pubblici, allora, oltre che essere
 * visibili, sono anche eseguibili. Questo è il fenomeno dello slicing: la specializzazione delle classi
 * derivate viene persa in favore di una maggiore generalizzazione.
 *
 * Non si può assegnare a un puntatore del tipo della classe base un riferimento ad un oggetto di una
 * sottoclasse privata.
 *
 * Il costruttore e il distruttore della classe base rimangono visibili per le classi derivate anche in
 * caso di ereditarietà private o protected.
 *
 * I membri privati di una classe possono essere usati solo ed esclusivamente all’interno della classe stessa.
 * Le variabili del main() li vedono, ma non possono accedervi.
 *
 * Sia l’ereditarietà private sia l’ereditarietà protected fanno perdere la relazione di sottotipo.
 */

#include <iostream>

using namespace std;

class A {
private:
	void stampaApri() {
		cout << "A pri" << endl;
	}
protected:
	void stampaApro() {
		cout << "A pro" << endl;
	}
public:
	void stampaApub() {
		cout << "A pub" << endl;
	}
};

class B: public A {
private:
	void stampaBpri() {
		cout << "B pri" << endl;
	}
protected:
	void stampaBpro() {
		cout << "B pro" << endl;
	}
public:
	void stampaBpub() {
		cout << "B pub" << endl;
	}
};

class C: private A {
private:
	void stampaCpri() {
		cout << "C pri" << endl;
	}
protected:
	void stampaCpro() {
		cout << "C pro" << endl;
	}
public:
	void stampaCpub() {
		cout << "C pub" << endl;
	}
};

int main() {

	cout << "VARIABILI STACK" << endl;

	A a;
	//a.stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//a.stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	a.stampaApub(); // Eseguibile senza errori.

	B b;
	//b.stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//b.stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	b.stampaApub(); // Eseguibile senza errori.
	//b.stampaBpri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//b.stampaBpro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	b.stampaBpub(); // Eseguibile senza errori.

	C c;
	//c.stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//c.stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	//c.stampaApub(); // Errore perchè C eredita in modo privato da A, dunque riesce a vedere i suoi membri, ma, seppur questi siano pubblici, non può accedervi.
	//c.stampaCpri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//c.stampaCpro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	c.stampaCpub(); // Eseguibile senza errori.

	cout << endl << "PUNTATORI NON POLIMORFICI" << endl;

	A *aa = new A();
	//aa->stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//aa->stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	aa->stampaApub();

	B *bb = new B();
	//bb->stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//bb->stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	bb->stampaApub(); // Eseguibile senza errori.
	//bb->stampaBpri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//bb->stampaBpro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	bb->stampaBpub(); // Eseguibile senza errori.

	C *cc = new C();
	//cc->stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//cc->stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	//cc->stampaApub(); // Errore perchè C eredita in modo privato da A, dunque riesce a vedere i suoi membri, ma, seppur questi siano pubblici, non può accedervi.
	//cc->stampaCpri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//cc->stampaCpro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	cc->stampaCpub(); // Eseguibile senza errori.

	cout << endl << "PUNTATORI POLIMORFICI" << endl;

	A *ab = new B();
	//ab->stampaApri(); // Errore perchè i membri privati di una classe sono eseguibili solo ed esclusivamente all'interno della classe.
	//ab->stampaApro(); // Errore perchè i membri protected di una classe sono eseguibili solo ed esclusivamente all'interno della classe base e delle sue classi derivate.
	ab->stampaApub();
	//ab->stampaBpri(); // Per effetto dello slicing il metodo stampaB() non può essere richiamato.
	//ab->stampaBpro(); // Per effetto dello slicing il metodo stampaB() non può essere richiamato.
	//ab->stampaBpub(); // Per effetto dello slicing il metodo stampaB() non può essere richiamato.

	//A *ac = new C(); // Polimorfismo non possibile perchè l'ereditarietà privata comporta una perdita della relazione di sottotipo.

	return 0;
}

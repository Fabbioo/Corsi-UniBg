#include <iostream>
#include <memory>

using namespace std;

class A {
public:
	A() {
		cout << "Costruzione oggetto A" << endl;
	}
	virtual ~A() {
		cout << "Distruzione oggetto A" << endl;
	}
	void stampaA(unique_ptr<A>& sp) {
		cout << "A" << endl;
	}
};

int main() {

	cout << "Raw pointer:" << endl;
	A *rawPointer = new A;

	cout << endl;

	cout << "Smart pointer:" << endl;
	unique_ptr<A> smartPointer(new A());
	smartPointer->stampaA(smartPointer);

	/*
	 * La differenza principale tra i raw pointers e gli smart pointers è che i secondi invocano
	 * automaticamente il distruttore di oggetti al termine dell'esecuzione del programma, mentre
	 * i primi lo fanno se e solo se viene esplicitata una delete dal programmatore.
	 * Il vantaggio che deriva dall'utilizzo di questo tipo di oggetti sta nel fatto che la
	 * deallocazione della memoria dinamica allocata sullo heap viene fatta esattamente nel momento in
	 * cui lo smart pointer esce dal proprio scope. Tale deallocazione viene fatta in maniera automatica
	 * e del tutto trasparente agli occhi del programmatore.
	 * Questo comportamento permette di evitare i memory leak.
	 *
	 * Gli smart pointer sono degli oggetti che contengono all'interno un puntatore. Tale puntatore
	 * è caratterizzato dal fatto di essere l'unico che può puntare ad una determinata area di memoria.
	 * Non è in alcun modo ammesso che più puntatori unique puntino ad una stessa area di memoria.
	 * Si può passare uno smart pointer come argomento di una funzione sfruttando il meccanismo dei
	 * reference. Usando un reference come parametro formale, il parametro formale viene fatto puntare
	 * alla stessa area di memoria dell'argomento. è ragionevole che sia così perchè i puntatori
	 * unique hanno la caratteristica di mantenere al proprio interno un indirizzo di memoria che non
	 * può in alcun modo essere duplicato (ovvero, non ci possono essere più riferimenti ad uno
	 * stesso indirizzo). Se uno smart pointer venisse passato come argomento ad una funzione per valore
	 * si verrebbero a creare due riferimenti ad una stessa area di memoria. Ciò è contro la logica di
	 * funzionamento degli smart pointer unique.
	 */

	return 0;

}

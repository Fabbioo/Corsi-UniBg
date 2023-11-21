#include <iostream>
#include <memory> // Per poter creare gli smart pointer devo necessariamente includere la libreria memory.

using namespace std;

class Canzone {
public:
	string s;
	Canzone(string s) {
		this->s = s;
		cout << "Costruzione di " << s << endl;
	}
	~Canzone() {
		cout << "Distruzione di " << s << endl;
	}
	void play() {}
};

void foo1(unique_ptr<Canzone> &p) {}

void foo2(shared_ptr<Canzone> p) {}

// I puntatori raw sono i puntatori che ho sempre utilizzato:
void useRawPointer() {
	// Costruisco un oggetto di classe Song nello heap:
	Canzone *rp = new Canzone("Mars1");
	rp->play(); // Accedo al metodo play().
	delete rp; // delete chiama automaticamente il distruttore dell'oggetto di classe Song.
	rp = NULL; // Buona prassi per evitare di avere in memoria dei dangling pointer.
}

void useSmartPointerUnique() {

	// In generale:
	// _ gli smart pointer occupano tanta memoria quanta ne occupano i raw pointer;
	// _ mai utilizzare new e malloc sugli smart pointer.

	// Creo uno smart pointer di tipo unique:
	unique_ptr<Canzone> spu(new Canzone("Mars2"));
	// Quello tra le parentesi < > è il tipo dello smart pointer.
	// Dentro le parentesi () viene specificato il costruttore di oggetti.

	// Gli smart pointer si comportano esattamente come i raw pointer, infatti:
	spu->play();

	foo1(spu);

	// Per il record di attivazione guarda il pdf su OneNote a pag118.
}

// Si possono avere più smart pointer che puntano ad uno stesso oggetto. è il caso degli shared pointer.
void useSmartPointerShared() {

	// Creo uno smart pointer di tipo shared:
	shared_ptr<Canzone> sps(new Canzone("Mars3"));
	foo2(sps);

	// Per il record di attivazione guarda il pdf su OneNote a pag118.
}

int main() {

	cout << " -> chiamata da raw pointer" << endl;
	useRawPointer();
	
	cout << "\n -> chiamata da smart pointer unique" << endl;
	useSmartPointerUnique();

	cout << "\n -> chiamata da smart pointer shared" << endl;
	useSmartPointerShared();
	
	return 0;
}

#include <iostream>

using namespace std;

class Persona {

private:

	mutable string nome;
	string cognome;

public:

	Persona(string nome, string cognome) {
		this->nome = nome;
		this->cognome = cognome;
		cout << "Creazione persona " << nome << " " << cognome << endl;
	}

	virtual ~Persona() {
		cout << "Distruzione persona " << nome << " " << cognome << endl;
	}

	string getNome() const {
		return this->nome;
	}

	void setNome(string nome) const {
		this->nome = nome;
	}

	void saluta() const {
		cout << "Saluti da " << nome << " " << cognome << endl;
	}
};

int main() {

	const Persona p("Fabio", "Mandalari");

	cout << "Output getNome(): " << p.getNome() << endl;

	p.saluta();

	// Discorso diverso per setNome() dato che questo metodo va a modificare il valore di
	// un campo di un oggetto dichiarato const.
	// Dichiarando come const il metodo setNome() scompare l'errore in compilazione presente
	// nella riga sottostante (ovvero p.setNome("Antonio");), ma compare un errore nella
	// definizione del metodo stesso. Questo accade perchè vanno in conflitto i due const
	// (sia quello del metodo setNome sia quello presente nella costruzione della Persona p).
	// Per risolvere questo conflitto bisogna aggiungere la keyword mutable davanti
	// all'attributo string nome. La keyword mutable indica che l'attributo nome è modificabile
	// anche nel caso in cui l'oggetto venga definito con const.
	p.setNome("Antonio");

	p.saluta();

	// A questo punto viene chiamato il distruttore dato che la variabile p risiede nello stack.

	return 0;
}

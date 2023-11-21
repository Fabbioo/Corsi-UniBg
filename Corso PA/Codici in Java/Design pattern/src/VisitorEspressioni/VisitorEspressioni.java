package VisitorEspressioni;

// Espressione da realizzare: (7 + 3) * 2 = 20.

interface Visitable {
	int accept(Visitor v);
}

interface Visitor {
	int visit(Numero n);
	int visit(Somma s);
	int visit(Prodotto p);
}

abstract class Espressione implements Visitable {}

abstract class Operazione implements Visitor {}

class Numero extends Espressione {
	
	private int valore;
	
	Numero(int numero) {
		this.valore = numero;
	}
	
	int getValue() {
		return valore;
	}
	
	public int accept(Visitor v) {
		return v.visit(this);
	}
}

class Somma extends Espressione {
	
	private Espressione e1;
	private Espressione e2;
	
	Somma(Espressione e1, Espressione e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	Espressione getE1() {
		return e1;
	}

	Espressione getE2() {
		return e2;
	}

	public int accept(Visitor v) {
		return v.visit(this);
	}
}

class Prodotto extends Espressione {
	
	private Espressione e1;
	private Espressione e2;

	Prodotto(Espressione e1, Espressione e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	Espressione getE1() {
		return e1;
	}

	Espressione getE2() {
		return e2;
	}

	public int accept(Visitor v) {
		return v.visit(this);
	}
}

class GetValue extends Operazione {

	// Decido arbitrariamente di non utilizzare il pattern Singleton.
	
	public int visit(Numero n) {
		return n.getValue();
	}

	public int visit(Somma s) {
		return s.getE1().accept(this) + s.getE2().accept(this);
	}

	public int visit(Prodotto p) {
		return p.getE1().accept(this) * p.getE2().accept(this);
	}
}

public class VisitorEspressioni {

	public static void main(String[] args) {

		// Costruisco i tre numeri:
		Numero n7 = new Numero(7);
		Numero n3 = new Numero(3);
		Numero n2 = new Numero(2);

		// Costruisco l'oggetto per il successivo calcolo della somma:
		Somma s = new Somma(n7, n3);

		// Costruisco l'oggetto per il successivo calcolo del prodotto:
		Prodotto p = new Prodotto(s, n2);

		// Stampo sia il valore della somma sia il valore del prodotto.
		GetValue gv = new GetValue();
		System.out.println("Somma = " + s.accept(gv));
		System.out.println("Prodotto = " + p.accept(gv));
		
	}
}

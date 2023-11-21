package VisitorEspressioniGenerics;

// Espressione da realizzare: (4 * 5) + 3 = 23.

interface Visitable {
	<T> T accept(Visitor<T> v);
}

interface Visitor<T> {
	T visit(Numero n);
	T visit(Prodotto p);
	T visit(Somma s);
}

abstract class Espressione implements Visitable {}

abstract class Operazione<T> implements Visitor<T> {}

class Numero extends Espressione {
	
	private int numero;

	Numero(int numero) {
		this.numero = numero;
	}
	
	int getNumero() {
		return numero;
	}
	
	public <T> T accept(Visitor<T> v) {
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

	public <T> T accept(Visitor<T> v) {
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

	public <T> T accept(Visitor<T> v) {
		return v.visit(this);
	}
}

class GetValue extends Operazione<Integer> {
	
	// Decido arbitrariamente di utilizzare il pattern Singleton.
	
	static private GetValue valore = null;
	private GetValue() {}
	static public GetValue creaValore() {
		if(valore == null)
			valore = new GetValue();
		return valore;
	}
	
	public Integer visit(Numero n) {
		return n.getNumero();
	}

	public Integer visit(Prodotto p) {
		return p.getE1().accept(this) * p.getE2().accept(this);
	}
	
	public Integer visit(Somma s) {
		return s.getE1().accept(this) + s.getE2().accept(this);
	}
}

class ToString extends Operazione<String> {
	
	// Decido arbitrariamente di utilizzare il pattern Singleton.
	
	static private ToString stringa = null;
	private ToString() {}
	static public ToString creaStringa() {
		if(stringa == null)
			stringa = new ToString();
		return stringa;
	}
	
	public String visit(Numero n) {
		return Integer.toString(n.getNumero());
	}

	public String visit(Prodotto p) {
		return p.getE1().accept(this) + " * " + p.getE2().accept(this);
	}
	
	public String visit(Somma s) {
		return s.getE1().accept(this) + " + " + s.getE2().accept(this);
	}
}

public class UsoVisitorPerEspressioniGeneric {

	public static void main(String[] args) {

		Numero n3 = new Numero(3);
		Numero n4 = new Numero(4);
		Numero n5 = new Numero(5);

		Prodotto p = new Prodotto(n4, n5);
		
		Somma s = new Somma(p, n3);
		
		GetValue gv = GetValue.creaValore();
		System.out.println("GetValue -> Prodotto generico: " + p.accept(gv));
		System.out.println("GetValue -> Somma generica: " + s.accept(gv));
		
		System.out.println();
		
		ToString ts = ToString.creaStringa();
		System.out.println("ToString -> Prodotto generico: " + p.accept(ts));
		System.out.println("ToString -> Somma generica: " + s.accept(ts));

	}

}

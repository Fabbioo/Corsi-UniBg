package VisitorFigure;

/*
 * Il design pattern Visitor serve per introdurre un grado di separazione tra quelle che sono le
 * classi Visitable (ovvero le classi atte al contenimento dei dati) e le classi Visitor (ovvero
 * le classi che devono effettuare delle operazioni sfruttando i dati immagazzinati nelle classi
 * Visitable).
 */

// Definizione dell'interfaccia Visitable:
interface Visitable {
	double accept(Visitor v); // Le classi Visitable devono accettare di farsi visitare dai Visitor.
}

// Definizione dell'interfaccia Visitor:
interface Visitor {
	double visit(Rettangolo r); // Metodo per la visita di un oggetto Rettangolo.
	double visit(Cerchio c); // Metodo per la visita di un oggetto Cerchio.
}

// Implementazione dell'interfaccia Visitable:
abstract class Figura implements Visitable {
	/*
	 * Sfrutto la terminologia della classe astratta per poi potermi riferire
	 * all'interfaccia Visitable facendo riferimento al tipo astratto Figure. Si
	 * tratta di uno zucchero sintattico che ha come solo scopo quello di migliorare
	 * la leggibilità del codice che viene scritto dopo. Si tratta di uno zucchero
	 * sintattico perchè avrei tranquillamente potuto fare a meno di definire la
	 * classe astratta Figure.
	 */
}

// Implementazione dell'interfaccia dei Visitor:
abstract class Operazione implements Visitor {
	/*
	 * Commento analogo a quello fatto per l'interfaccia Visitable.
	 */
}

class Rettangolo extends Figura {

	private int base;
	private int altezza;

	Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	int getBase() {
		return base;
	}

	int getAltezza() {
		return altezza;
	}

	public double accept(Visitor v) {
		return v.visit(this);
	}

}

class Cerchio extends Figura {

	private int raggio;

	Cerchio(int raggio) {
		this.raggio = raggio;
	}

	int getRaggio() {
		return raggio;
	}

	public double accept(Visitor v) {
		return v.visit(this);
	}
}

class CalcolaArea extends Operazione {

	// Decido arbitrariamente di utilizzare il pattern Singleton.
	
	static private CalcolaArea unicoOperatoreArea = null;

	private CalcolaArea() {
	}

	static public CalcolaArea creaUnicoOperatoreArea() {
		if (unicoOperatoreArea == null)
			unicoOperatoreArea = new CalcolaArea();
		return unicoOperatoreArea;
	}

	public double visit(Rettangolo r) {
		return r.getBase() * r.getAltezza();
	}

	public double visit(Cerchio c) {
		return Math.PI * c.getRaggio() * c.getRaggio();
	}
}

class CalcolaPerimetro extends Operazione {

	// Decido arbitrariamente di utilizzare il pattern Singleton.
	
	static private CalcolaPerimetro unicoOperatorePerimetro = null;

	private CalcolaPerimetro() {
	}

	static public CalcolaPerimetro creaUnicoOperatorePerimetro() {
		if (unicoOperatorePerimetro == null)
			unicoOperatorePerimetro = new CalcolaPerimetro();
		return unicoOperatorePerimetro;
	}

	public double visit(Rettangolo r) {
		return r.getAltezza() * 2 + r.getBase() * 2;
	}

	public double visit(Cerchio c) {
		return 2 * Math.PI * c.getRaggio();
	}
}

public class VisitorFigure {

	public static void main(String[] args) {

		Rettangolo r = new Rettangolo(4, 6);
		Cerchio c = new Cerchio(3);

		CalcolaArea ca = CalcolaArea.creaUnicoOperatoreArea();

		// L'oggetto ca viene utilizzato per calcolare l'area sia del rettangolo sia del cerchio.
		System.out.println("Area rettangolo: " + r.accept(ca));
		System.out.println("Area cerchio: " + c.accept(ca));

		System.out.println();

		CalcolaPerimetro cp = CalcolaPerimetro.creaUnicoOperatorePerimetro();

		// L'oggetto cp viene utilizzato per calcolare il perimetro sia del rettangolo sia del cerchio.
		System.out.println("Perimetro rettangolo: " + r.accept(cp));
		System.out.println("Perimetro cerchio: " + c.accept(cp));

	}
}

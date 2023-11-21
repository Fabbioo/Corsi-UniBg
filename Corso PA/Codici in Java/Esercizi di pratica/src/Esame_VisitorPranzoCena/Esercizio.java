package Esame_VisitorPranzoCena;

import java.util.List;
import java.util.ArrayList;

interface Visitable {
	int accept(Visitor v);
}

interface Visitor {
	int visit(Pranzo p);
	int visit(Cena c);
}

abstract class Pasto implements Visitable {
	int costo;
	int orario;
}

abstract class Calcola implements Visitor {
}

class Pranzo extends Pasto {

	Pranzo() {
		this.costo = 10;
		this.orario = 12;
	}

	int getCostoPranzo() {
		return costo;
	}

	public int accept(Visitor v) {
		return v.visit(this);
	}

}

class Cena extends Pasto {

	Cena() {
		this.costo = 20;
		this.orario = 20;
	}

	int getCostoCena() {
		return costo;
	}

	public int accept(Visitor v) {
		return v.visit(this);
	}
}

class CalcolaCosto extends Calcola {

	static private CalcolaCosto calcolatoreCosto = null;

	private CalcolaCosto() {
	}

	static public CalcolaCosto creaCalcolatoreCosto() {
		if (calcolatoreCosto == null)
			calcolatoreCosto = new CalcolaCosto();
		return calcolatoreCosto;
	}

	public int visit(Pranzo p) {
		return p.getCostoPranzo();
	}

	public int visit(Cena c) {
		return c.getCostoCena();
	}

}

public class Esercizio {

	static CalcolaCosto cc = CalcolaCosto.creaCalcolatoreCosto();

	static int sommaCosto(List<? extends Pasto> clienti) {
		// equivalentemente: static <T extends Pasto> int sommaCosto(List<T> clienti) {
		int costoTotale = 0;
		for (int i = 0; i < clienti.size(); i++)
			costoTotale += clienti.get(i).accept(cc);
		return costoTotale;
	}

	public static void main(String[] args) {

		Pasto p1 = new Pranzo();
		Pasto p2 = new Cena();

		Pranzo p3 = new Pranzo();
		Pranzo p4 = new Pranzo();

		Cena p5 = new Cena();
		Cena p6 = new Cena();

		System.out.println("PastoPranzo1: "  + p1.accept(cc));
		System.out.println("PastoCena2: "    + p2.accept(cc));
		System.out.println("PranzoPranzo3: " + p3.accept(cc));
		System.out.println("PranzoPranzo4: " + p4.accept(cc));
		System.out.println("CenaCena5: "     + p5.accept(cc));
		System.out.println("CenaCena6: "     + p6.accept(cc));

		List<Pasto> pasti = new ArrayList<>();
		pasti.add(p1);
		pasti.add(p2);
		System.out.println("\nCosto totale pasti: " + Esercizio.sommaCosto(pasti));

		List<Pranzo> pranzi = new ArrayList<>();
		pranzi.add(p3);
		pranzi.add(p4);
		System.out.println("Costo totale pranzi: " + Esercizio.sommaCosto(pranzi));

		List<Cena> cene = new ArrayList<>();
		cene.add(p5);
		cene.add(p6);
		System.out.println("Costo totale cene: " + Esercizio.sommaCosto(cene));

	}
}

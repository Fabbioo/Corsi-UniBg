package Esame_GenericsVisitorAtomicoComposto;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

interface Visitable {
	<T> T accept(Visitor<T> visitor);
}

interface Visitor<T> {
	T visit(Atomico a);

	T visit(Composto c);
}

abstract class Componente implements Visitable {
}

class Atomico extends Componente {
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}

class Composto extends Componente {
	List<Componente> componenti = new ArrayList<>();
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}

class GetPrezzo implements Visitor<Integer> {
	public Integer visit(Atomico a) {
		return 10;
	}

	public Integer visit(Composto c) {
		return c.componenti.stream().mapToInt(componente -> componente.accept(this)).sum();
	}
}

class GetNome implements Visitor<String> {
	public String visit(Atomico a) {
		return "C";
	}

	public String visit(Composto c) {
		String stringa = "[";
		for (Componente componente : c.componenti)
			stringa += componente.accept(this);
		return stringa + "]";
	}
}

public class Esercizio {

	static double sommaCosto(List<? extends Componente> c) {
		GetPrezzo p = new GetPrezzo();
		return c.stream().mapToDouble(componente -> componente.accept(p)).sum();
	}

	public static void main(String[] args) {

		Componente a = new Atomico();
		
		Visitor<String> n = new GetNome();
		System.out.println(a.accept(n));

		Atomico b = new Atomico();
		Composto c1 = new Composto();
		c1.componenti.addAll(Arrays.asList(a, b));
		
		Composto c2 = new Composto();
		c2.componenti.addAll(Arrays.asList(c1, a));
		
		System.out.println(c1.accept(n));

		Visitor<Integer> p = new GetPrezzo();
		System.out.println(c2.accept(p));

		Componente cp = new Atomico();
		List<Componente> lc = new ArrayList<Componente>();
		lc.addAll(Arrays.asList(c1, cp, c2, b));
		System.out.println(sommaCosto(lc));

		List<Atomico> la = new ArrayList<>();
		System.out.println(sommaCosto(la));
	}
}

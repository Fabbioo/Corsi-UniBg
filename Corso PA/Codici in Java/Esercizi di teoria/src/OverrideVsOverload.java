class W {
}

class Z extends W {
}

class A {
	void m(W h) {
		System.out.println("A");
	}
}

class B extends A {
	void m(Z l) {
		System.out.println("B"); // Overloading del metodo m() della classe A.
	}
}

class C extends A {
	void m(W h) {
		System.out.println("C"); // Overriding del metodo m() della classe A.
	}
}

public class OverrideVsOverload {

	public static void main(String[] args) {
		A a = new A();
		W w = new W();
		Z z = new Z();
		A c = new C();
		A b = new B();

		a.m(w);
		// a è di tipo A, quindi si cerca in A un metodo m() che prende in input un w.
		// Lo si trova, quindi viene eseguito.

		c.m(w);
		// a è di tipo A, quindi innanzitutto si cerca in A un metodo m() che prende in
		// input un w.
		// Lo si trova, ma in fase di esecuzione si "metabolizza" il fatto che c sia un
		// C, quindi
		// si va a cercare in C un metodo m() che prende in input un w. Lo si trova,
		// quindi viene
		// eseguito. In altre parole, viene eseguito il metodo m() della classe C perchè
		// è più
		// specifico di quello presente nella classe A.

		b.m(z);
		// b è di tipo A, quindi innanzitutto si cerca in A un metodo m() che prende in
		// input uno z.
		// z è di tipo Z e in A non si trova un metodo che prende uno Z in input, ma si
		// trova un m()
		// che prende un W. Non vi è alcun problema perchè la classe Z estende la classe
		// W, quindi si
		// sfrutta il metodo m() della classe A.
	}
}


public class MyFraction implements Comparable<MyFraction> {
	// Campi
	private int num;
	private int den;

	// Costruttori
	public MyFraction(int x, int y) {
		this.num = x;
		this.den = y;
	}

	public MyFraction(int x) {
		this(x, 1);
	}

	// Metodi
	public MyFraction piu(MyFraction f) {
		int n = this.num * f.den + this.den * f.num;
		int d = this.den * f.den;
		return new MyFraction(n, d);
	}

	public MyFraction meno(MyFraction f) {
		int n = this.num * f.den - this.den * f.num;
		int d = this.den * f.den;
		return new MyFraction(n, d);
	}

	public MyFraction per(MyFraction f) {
		int n = this.num * f.num;
		int d = this.den * f.den;
		return new MyFraction(n, d);
	}

	public MyFraction diviso(MyFraction f) {
		int n = this.num * f.den;
		int d = this.den * f.num;
		return new MyFraction(n, d);
	}

	public boolean isMinore(MyFraction f) {
		MyFraction g = this.meno(f);
		return g.num < 0;
	}

	public boolean isMaggiore(MyFraction f) {
		MyFraction g = this.meno(f);
		return g.num > 0;
	}

	public boolean equals(MyFraction f) {
		MyFraction g = this.meno(f);
		if (g.num == 0)
			return true;
		else
			return false;
	}

	public int compareTo(MyFraction f) {
		if (this.equals(f))
			return 0;
		else if (this.isMinore(f))
			return -1;
		else
			return 1;
	}
}

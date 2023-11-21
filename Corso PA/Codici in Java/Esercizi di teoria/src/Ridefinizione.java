class AA {
	void m(int x) {
		System.out.println("classe AA");
	}
}

class BB extends AA {
	void m(int x, float g) {
		System.out.println("classe BB");
	}
}

public class Ridefinizione {

	public static void main(String[] args) {
		
		BB b = new BB(); 
		b.m(5);
		b.m(5, 8);

	}

}

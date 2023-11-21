import java.util.*;

class Veicolo implements Comparable<Veicolo> {
	String targa;
	
	public String getTarga() {
		return targa;
	}

	public int compareTo(Veicolo o) {
		return this.getTarga().compareTo(o.getTarga());
	}
}

class Auto extends Veicolo {
	// Non è implements Comparable<Auto> !
}

public class UsoSuperBinding {
	
	static <T extends Comparable<? super T>> T getMax(List<T> l) {
		// T è un qualsiasi tipo che è confrontabile con oggetti di tipo T oppure con
		// oggetto di un supertipo di T.
		return null;
	}
	
	public static void main(String[] args) {
		
		Auto a1 = new Auto();
		Auto a2 = new Auto();
		
		// Auto possiede il compareTo() perchè lo eredita da Veicolo:
		System.out.println(a1.compareTo(a2));
		
		List<Veicolo> vv = new ArrayList<>();
		
		getMax(vv);
		
		List<Auto> aa = new ArrayList<>();
		
		getMax(aa);
			// Funziona grazie al <T extends Comparable<? super T>>.
	}

}

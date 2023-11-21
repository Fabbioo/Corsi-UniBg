package Esercizio03;

public class Test {

	public static void main(String[] args) {

		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";

		Pila pila = new PilaComposizione();

		System.out.println("Pila vuota? " + pila.isEmpty()); // true

		pila.push(a);
		pila.push(b);
		pila.push(c);
		pila.push(d);

		System.out.print("\nElementi nella pila: ");
		
		for (Object e : ((PilaComposizione) pila).pila)	System.out.print(e.toString()); // d c b a

		System.out.println("\n\nRimosso primo elemento dalla pila (ovvero " + pila.pop() + ")"); // d

		System.out.println("\nIl nuovo primo elemento della pila è: " + pila.top()); // c

		System.out.print("\nElementi nella pila: ");
		
		for (Object e : ((PilaComposizione) pila).pila)	System.out.print(e.toString()); // c b a
	}
}
import java.util.Arrays;

public class VarArgs {

	// VarArgs permette di non conoscere il numero di argomenti di input e si
	// realizza nel seguente modo: String ... strings.
	static void print(String ... strings) {
		// strings è un array dinamico di stringhe String[].
		// "Dinamico" nel senso che non si sa quante stringhe sono dentro strings.
		// Stampo la lista di stringhe:
		Arrays.asList(strings).forEach(x -> System.out.print(x + " - "));
		System.out.println();
	}

	public static void main(String[] args) {
		print("ciao");
		print("ciao", "aug");
		print("ciao", "uag", "ihjb");
	}
}

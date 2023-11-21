// Creo innanzitutto una eccezione: per farlo, occorre creare una classe che estende Exception.
// Nota che la dichiarazione di questa eccezione è fatto solo ed esclusivamente per esercizio;
// per raggiungere lo stesso scopo per cui uso questa classe potrei utilizzare direttamente ArithmeticException.

public class IllegalArgumentException extends Exception {
	public IllegalArgumentException(String msg) {
		super(msg);
	}
}

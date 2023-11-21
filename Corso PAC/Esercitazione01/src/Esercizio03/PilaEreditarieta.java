package Esercizio03;


import java.util.LinkedList;


public class PilaEreditarieta extends LinkedList implements Pila {
	
	/*
	 *  Se non ci fosse il extends LinkedList mi verrebbe notificato che devono essere fornite le
	 *  implementazioni dei metodi pop(), push(), isEmpty() e top().
	 *  Dato che queste implementazioni sono già presenti nella classe LinkedList, la implemento.
	 *  In questo modo rimane solo da fornire l'implementazione del metodo top().
	 */
	
	public Object top() {
		return this.getFirst();
	}
}
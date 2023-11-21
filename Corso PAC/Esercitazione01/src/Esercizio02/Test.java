package Esercizio02;

import java.util.List;
import java.util.LinkedList;

public class Test {
	
	public static void main(String[] args) {
		
		List<Studente> listaNoDup = new LinkedList<Studente>();
		
		listaNoDup.add(new Studente("ABC", "DEF", "10102021", "UniBg", 0));
		listaNoDup.add(new Studente("GHI", "LMN", "11102021", "UniMi", 1));
		listaNoDup.add(new Studente("OPQ", "RST", "10102021", "UniNa", 2));
		listaNoDup.add(new Studente("UVW", "XYZ", "12102021", "UniRc", 3));
		
			
		List<Studente> listaDup = new LinkedList<Studente>();
		
		listaDup.add(new Studente("ABC", "DEF", "10102021", "UniBg", 0));
		listaDup.add(new Studente("GHI", "LMN", "11102021", "UniBg", 0));
		listaDup.add(new Studente("OPQ", "RST", "10102021", "UniNa", 2));
		listaDup.add(new Studente("UVW", "XYZ", "12102021", "UniRc", 3));
		listaDup.add(new Studente("UVW", "XYZ", "12102021", "UniRc", 3));
		
		VerificaDup test_verificaDup = new VerificaDupImplements();
		
		System.out.println(test_verificaDup.verificaDup(listaNoDup)); // false
		System.out.println(test_verificaDup.verificaDup(listaDup)); // true
	}
}

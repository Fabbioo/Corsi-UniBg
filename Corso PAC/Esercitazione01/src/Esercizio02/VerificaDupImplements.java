package Esercizio02;

import java.util.List;
import java.util.ListIterator;

public class VerificaDupImplements implements VerificaDup {
	
	public boolean verificaDup(List S) {
		
		// Approccio: per ogni elemento della lista verifico che non ci sia un altro elemento uguale.
		
		ListIterator listIteratorExt = S.listIterator(); // ListIterator esterno

		while(listIteratorExt.hasNext()) {
			
			Object e_est = listIteratorExt.next();
			
			ListIterator listIteratorInt = S.listIterator(listIteratorExt.nextIndex()); // ListIterator interno, scorre gli elementi successivi a quello su cui quello esterno si è fermato
			
			while(listIteratorInt.hasNext()) {
				
				Object e_int = listIteratorInt.next();
				
				if(e_int.equals(e_est))
					return true;
			}
		}
		return false;
	}
}

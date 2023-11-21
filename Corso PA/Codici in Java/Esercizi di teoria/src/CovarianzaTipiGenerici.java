import java.util.*;

class Figura { }

class Rettangolo extends Figura { }

public class CovarianzaTipiGenerici {
	
	public static void main(String[] args) {
		
		Figura rettangoli[] = new Rettangolo[10]; // Ammissibile perchè ho la covarianza negli array.
		
		// è lecito inserire oggetti di classe Rettangolo nell'array rettangoli dato che il tipo del
		// riferimento è Figura e la classe Rettangolo deriva dalla classe Figura:
		rettangoli[0] = new Rettangolo();
		
		// Attenzione:
		rettangoli[0] = new Figura();
		/*
		 * Questo comando è perfettamente accettato, ma in esecuzione lancia una eccezione perchè sto
		 * inserendo un oggetto Figura laddove possono essere accettati solo oggetti Rettangolo.
		 * In particolare, viene lanciata una eccezione di classe ArrayStoreException.
		 */
		
		// Istanziando List con ArrayList e mantenendo lo stesso tipo generico non ho problemi:
		List<Figura> figuraList1 = new ArrayList<Figura>();
		List<Figura> figuraList2 = new ArrayList<>(); // Scrittura analoga alla precedente.
		
		// Se cambio il tipo generico specificando Rettangolo ottengo errore in compilazione perchè
		// tra i generici non esiste covarianza:
		//List<Figura> figuraList3 = new ArrayList<Rettangolo>();
			
	}
}
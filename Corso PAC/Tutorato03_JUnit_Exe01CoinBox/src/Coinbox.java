
public class Coinbox {
	
	private int nMonete;
	
	public Coinbox() {
		this.nMonete = 0;
	}
	
	public boolean erogaCaffe() {
		// Se il numero di monete è >= 2, allora eroga il caffè, altrimenti no.
		if(nMonete >= 2) {
			nMonete -= 2;
			return true;
		} else {
			return false;
		}
	}
	
	public void addMoneta() {
		nMonete++;
	}
	
	public int getMonete() {
		return nMonete;
	}
	
}

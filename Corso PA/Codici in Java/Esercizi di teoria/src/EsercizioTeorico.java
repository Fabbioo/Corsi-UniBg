class Persona {
	void setAge(int l) {
		System.out.println("P");

	}
}

class Studentee extends Persona {
	void setAge(int l) {
		System.out.println("S");

	}
}

class Anziano extends Persona {
	void setAge(long l) {
		System.out.println("A");

	}
}

public class EsercizioTeorico {

	public static void main(String[] args) {
		Object op = new Persona();
		Persona pp = new Persona();
		Persona ps = new Studentee();
		Persona pa = new Anziano();
		Anziano aa = new Anziano();
		int age = 30;
		long ageL = 200;
		
		aa.setAge(age);

		/*
		 * FAI ATTENZIONE.
		 * 
		 * In EB si cerca in Anziano un setAge(int). DATO CHE NON C'è si risale la gerarchia per
		 * provare a vedere se in Persona c'è un setAge(int).
		 * Dato che in Persona c'è setAge(int) allora viene selezionato!
		 * In LB si cerca in Anziano un setAge(int) come quello selezionato in EB. Dato che non c'è
		 * viene eseguito quello selezionato in EB.
		 * 
		 * Viene data più importanza alla risalita della gerarchia piuttosto che al cast da int a long!
		 */
		
	}

}
